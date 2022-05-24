package com.pdgr.SudokuSolver;

import java.util.Arrays;

public class BoardCrawler {

    /* this class contains crawler method to scan through the board and look for correct values
     */

    public Integer[][] crawler (int[] boardStart, int[] fixStart, int locStart, int dirStart){
        int[] board = Arrays.copyOf(boardStart, boardStart.length);
        int[] fix = Arrays.copyOf(fixStart, fixStart.length);
        int loc = locStart;
        int dir = dirStart;
        int iter = 0;
        boolean complete = false;

        while (true){
            iter++;
            int score = BoardChecker.checkMatrix(reverseMatrixGenerator(board));
            if (score == 0) {
                IterationCount.setIter(iter);
                return reverseMatrixGenerator(board);
            }
            else if (fix[loc] == 11
                    && ((loc == 80 && score == 1 && dir == 1)
                    || (loc > 0 && loc < 80 && score == 2 && dir == -1))) {
                loc--;
                dir = -1;
            }
            else if ((fix[loc] == 11 && loc < 80)
                    || (fix[loc] == 0 && board[loc] > 0 && loc < 80)
                    && score == 2 && dir == 1) {
                loc++;
                dir = 1;
            }
            else if (fix[loc] == 0 && board[loc] == 9
                    && (loc > 0 && loc < 80
                    && ((score == 2 && dir == -1) || (score == 1 && dir == 1)))) {
                board[loc] = 0;
                loc--;
                dir = -1;
            }
            else {
                board[loc] = board[loc] + 1;
                dir = 1;
            }
        }
    }

    //methods transforms given sudoku matrix array and fixed points matrix to arrays
    //(two dimensional arrays to one dimensional arrays)

    public int[] matrixArrayGenerator (Integer[][] matrix){
        int[] boardAsArray = new int[81];
        for (int x = 0; x < 9; x++) {for (int y = 0; y < 9; y++)
        {boardAsArray[y + (9 * x)] = matrix[x][y];}}
        return boardAsArray;
    }

    public int[] fixedPointsArrayGenerator (int[][] fixPoints){
        int[] fixedPointsAsArray = new int[81];
        for (int x = 0; x < 9; x++) {for (int y = 0; y < 9; y++)
        {fixedPointsAsArray[y + (9 * x)] = fixPoints[x][y];}}
        return fixedPointsAsArray;
    }

    //methods transforms one dimensional array to sudoku matrix

    public Integer[][] reverseMatrixGenerator (int[] boardAsArray){
        Integer[][] reverseMatrix = new Integer[9][9];
        for (int x = 0; x < 9; x++) {for (int y = 0; y < 9; y++)
        {reverseMatrix[x][y] = boardAsArray[y + (9 * x)];}}
        return reverseMatrix;
    }
}
