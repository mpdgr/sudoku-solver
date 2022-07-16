package com.mpdgr.sudokusolver.service;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class SudokuModel {

    //holds given Sudoku board
    private final Integer[][] matrix;

    //indicates fixed points i.e. cells where values were input at the beginning
    private final int[][] fixedPointsMatrix;

    public SudokuModel(Integer[][] matrix){
        this.matrix = matrix;
        fixedPointsMatrix = Arrays.copyOf(cellBlocker(matrix), 9);
    }

    //takes the input matrix and returns matrix indicating fixed cells (as 11 value)
    int[][] cellBlocker(Integer[][] matrix) {
        int[][] fixedCellsTemp = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (matrix[x][y] != 0) {
                    fixedCellsTemp[x][y] = 11;      //value 11 indicates fixed cell
                } else {
                    fixedCellsTemp[x][y] = 0;
                }
            }
        }
        return fixedCellsTemp;
    }

    @Override
    public String toString() {
        return "Sudoku Board {" + Arrays.deepToString(matrix) + '}';
    }
}
