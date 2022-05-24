package com.pdgr.SudokuSolver;


import java.util.Arrays;

public class GameBoard {

    //this matrix holds given Sudoku board
    private final Integer[][] matrix;

    //this matrix holds fixed points indicating values input at the start into Sudoku board
    private final int[][] fixedPointsMatrix;

    //getters for given Sudoku matrix and fixed point matrix
    public Integer[][] getMatrix() {
        return matrix;
    }
    public int[][] getFixedPointsMatrix() { return fixedPointsMatrix; }

    //constructor creates the board and generates the board indicating fixed points for input (non-zero) values
    public GameBoard(Integer[][] matrix){
        this.matrix = matrix;
        fixedPointsMatrix = Arrays.copyOf(pointsBlocker(matrix), 9);
    }

    //this method takes the input matrix and returns matrix indicating fixed points (as 11 value)
    int[][] pointsBlocker(Integer[][] matrix){
        int[][] fixedPointsTemp = new int[9][9];
        for (int x = 0; x < 9; x++) {for (int y = 0; y < 9; y++) {
            if (matrix[x][y] != 0) {
                fixedPointsTemp[x][y] = 11;      //value 11 indicates fixed point
            }
            else fixedPointsTemp [x][y] = 0;
        }
        }
        return fixedPointsTemp;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "matrix=" +
                Arrays.deepToString(matrix) +
                '}';
    }
}
