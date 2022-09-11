package com.mpdgr.sudokusolver.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

@Data
@NoArgsConstructor
public class Worker implements Callable<Solution> {
    private Integer[][] task;
    private CountDownLatch latch;
    private TransposeMode transposeMode;
    private SolverAlgorithm algorithm;
    private int threadNr;

    public Worker(Integer[][] task, CountDownLatch latch, TransposeMode transposeMode) {
        this.task = task;
        this.latch = latch;
        this.transposeMode = transposeMode;
        this.algorithm = new SolverAlgorithm();
    }

    @Override
    public Solution call() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverse(task, transposeMode);
        SudokuModel sudoku = new SudokuModel(reversed);
        int[] boardAsArray = algorithm.matrixArrayGenerator(sudoku.getMatrix());
        int[] fixedPointsAsArray = algorithm.fixedCellsArrayGenerator(sudoku.getFixedPointsMatrix());
        Solution solution = new Solution();
        try {
            solution = algorithm.crawler(boardAsArray, fixedPointsAsArray);
        } catch (InterruptedException ignored) {}

        latch.countDown();
        solution.setSolution(reverser.reverse(solution.getSolution(), transposeMode));
        solution.setWinnerThreadNr(threadNr);
        solution.setWinnerMode(transposeMode);
        return solution;
    }
}