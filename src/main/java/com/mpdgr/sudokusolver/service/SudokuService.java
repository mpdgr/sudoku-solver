package com.mpdgr.sudokusolver.service;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

/*
    Process method transposes given input sudoku matrix into 6 new matrices and starts 6 worker thread,
    each solving one matrix. The fastest thread returns the solution (transposed back to match initial input).
    After the solution is found, remaining threads are stopped.
    Additional thread is started for timer - to stop the method in case no solution is found
    (which indicates unexpected error).  .
 */

@Component
public class SudokuService {

    public Solution process(Integer[][] newSudoku) throws ServiceException {

        long timeStart = System.currentTimeMillis();
        long deadline = timeStart + 100_000;
        InTimeCheck timeCheck = new InTimeCheck();

        CountDownLatch latch = new CountDownLatch(1);

        ServiceTimer timer = new ServiceTimer(deadline, latch, timeCheck);
        Thread timerDaemon = new Thread(timer);
        timerDaemon.setDaemon(true);
        timerDaemon.start();

        Stream<TransposeMode> modeStream = Stream.of(TransposeMode.values());

        List<Worker> workers = new ArrayList<>();
        List<Callable<Solution>> solvers = new ArrayList<>();

        modeStream.forEach(mode -> {
            Worker solver = new Worker(newSudoku, latch, mode);
            solvers.add(solver);
            workers.add(solver);
        });

        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).setThreadNr(i + 1);
        }

        List<Future<Solution>> futureSolutions = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (Callable<Solution> solver : solvers) {
            Future<Solution> f = executor.submit(solver);
            futureSolutions.add(f);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Solution solution = new Solution();
        boolean futureDone = false;

        while (!futureDone && timeCheck.inTime()) {
            for (var futureSolution : futureSolutions) {
                if (futureSolution.isDone()) {
                    try {
                        solution = futureSolution.get();
                        solution.setDone(true);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    futureDone = true;
                    break;
                }
            }
        }
        for (var worker : workers) {
            worker.getAlgorithm().kill();
        }

        if (!futureDone) {
            throw new ServiceException("Computation error");
        }

        executor.shutdownNow();

        long timeEnd = System.currentTimeMillis();
        long totalTime = timeEnd - timeStart;
        solution.setOperationTime(totalTime);

        return solution;
    }
}