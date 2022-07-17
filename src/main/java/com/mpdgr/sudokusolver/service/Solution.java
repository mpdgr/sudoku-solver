package com.mpdgr.sudokusolver.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Solution {
    private Integer[][] solution = new Integer[9][9];
    private long operationTime;
    private int iterationCount;
    private int winnerThreadNr;
    private ReverseMode winnerMode;
    private boolean solvable = true;
    private boolean done = false;

    public Solution(Integer[][] solution, int iterationCount) {
        this.solution = solution;
        this.iterationCount = iterationCount;
    }

    public Solution(boolean solvable, int iterationCount) {
        this.solvable = solvable;
        this.iterationCount = iterationCount;
    }
}
