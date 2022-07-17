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
    private ReverseMode reverseMode;
    private BoardCrawler crawler;
    private int threadNr;

    public Worker(Integer[][] task, CountDownLatch latch, ReverseMode reverseMode) {
        this.task = task;
        this.latch = latch;
        this.reverseMode = reverseMode;
        this.crawler = new BoardCrawler();
    }

    @Override
    public Solution call() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverse(task, reverseMode);
        SudokuModel sudoku = new SudokuModel(reversed);
        int[] boardAsArray = crawler.matrixArrayGenerator(sudoku.getMatrix());
        int[] fixedPointsAsArray = crawler.fixedCellsArrayGenerator(sudoku.getFixedPointsMatrix());
        Solution solution = new Solution();
        try {
            solution = crawler.crawler(boardAsArray, fixedPointsAsArray);
        } catch (InterruptedException ignored) {}

        latch.countDown();
        solution.setSolution(reverser.reverse(solution.getSolution(), reverseMode));
        solution.setWinnerThreadNr(threadNr);
        solution.setWinnerMode(reverseMode);
        return solution;
    }
}