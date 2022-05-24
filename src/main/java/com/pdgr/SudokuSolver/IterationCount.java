package com.pdgr.SudokuSolver;

public abstract class IterationCount {
    private static int iter;

    public static int getIter() {
        return iter;
    }
    public static void setIter(int iter) {
        IterationCount.iter = iter;
    }
}
