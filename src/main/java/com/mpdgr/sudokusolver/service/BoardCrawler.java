package com.mpdgr.sudokusolver.service;

import java.util.Arrays;

public class BoardCrawler {

/*
    Class contains crawler method to scan through the board and look for correct values
    Sudoku matrix is transformed to an array, processed and transformed back to matrix
    Kill method is used to interrupt counting in case other thread completes the task faster
*/

    private boolean isActive = true;

    public void kill() {
        isActive = false;
    }

    public Solution crawler (int[] boardStart, int[] fixStart) throws InterruptedException {
        BoardChecker boardChecker = new BoardChecker();
        int[] board = Arrays.copyOf(boardStart, boardStart.length);
        int[] fix = Arrays.copyOf(fixStart, fixStart.length);
        int loc = 0;
        int dir = 1;
        int iter = 0;

        int firstFreeLoc = -1;
        for(int i = 0; i < fix.length; i++){
            if (fix[i] != 11) {
                firstFreeLoc = i;
                break;
            }
        }

        while (true) {
            if (!isActive) {
                throw new InterruptedException();
            }
            iter++;
            int score = boardChecker.checkMatrix(backToMatrixGenerator(board));
            if (loc == firstFreeLoc && board[loc] == 9 && (dir == -1 || score == 1))
            {
                return new Solution(false, iter);
            }
            if (score == 0)
            {
                return new Solution(backToMatrixGenerator(board), iter);
            }
            else if (fix[loc] == 11 &&
                    ((loc == 80 && score == 1 && dir == 1) || (loc > 0 && loc < 80 && score == 2 && dir == -1)))
            {
                loc--;
                dir = -1;
            }
            else if ((fix[loc] == 11 && loc < 80) || (fix[loc] == 0 && board[loc] > 0 && loc < 80) &&
                    score == 2 && dir == 1)
            {
                loc++;
                dir = 1;
            }
            else if (fix[loc] == 0 && board[loc] == 9 &&
                    (loc > 0 && loc < 80 &&
                            ((score == 2 && dir == -1) || (score == 1 && dir == 1))))
            {
                board[loc] = 0;
                loc--;
                dir = -1;
            }
            else
            {
                board[loc] = board[loc] + 1;
                dir = 1;
            }
        }
    }

    //transforms given sudoku matrix and fixed points matrix to arrays
    //(two dimensional arrays to one dimensional arrays)

    public int[] matrixArrayGenerator(Integer[][] matrix) {
        int[] boardAsArray = new int[81];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                boardAsArray[y + (9 * x)] = matrix[x][y];
            }
        }
        return boardAsArray;
    }

    public int[] fixedCellsArrayGenerator(int[][] fixPoints) {
        int[] fixedPointsAsArray = new int[81];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                fixedPointsAsArray[y + (9 * x)] = fixPoints[x][y];
            }
        }
        return fixedPointsAsArray;
    }

    //transforms one dimensional array to sudoku matrix

    public Integer[][] backToMatrixGenerator(int[] boardAsArray) {
        Integer[][] reverseMatrix = new Integer[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                reverseMatrix[x][y] = boardAsArray[y + (9 * x)];
            }
        }
        return reverseMatrix;
    }
}
