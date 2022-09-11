package com.mpdgr.sudokusolver.controller;

import com.mpdgr.sudokusolver.service.BoardChecker;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MatrixValidator {

    //check if each cell contains integer between 0 and 9 and no repeated values at cells, cols and sqrs
    public boolean containsValidInts(Integer[][] matrix) {
        if (new BoardChecker().checkMatrix(matrix) == 1){
            return false;
        }
        for (Integer[] input : matrix) {
            for (Integer integer : input) {
                if (integer < 0 || integer > 9) {
                    return false;
                }
            }
        }
        return true;
    }

    //check if each empty cell has at least one possible/valid input
    public boolean inputNotContradictory(Integer[][] matrix) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (matrix[y][x] == 0) {
                    Set<Integer> colValues = getColValues(x, matrix);
                    Set<Integer> rowValues = getRowValues(y, matrix);
                    Set<Integer> sqrValues = getSqrValues(y, x, matrix);
                    Set<Integer> legitValues = getLegitValues(colValues, rowValues, sqrValues);
                    if (legitValues.isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Set<Integer> getColValues(int x, Integer[][] matrix){
        Set<Integer> colValues = new HashSet<>();
        for (int y = 0; y < 9; y++) {
            colValues.add(matrix[y][x]);
        }
        return colValues;
    }

    public Set<Integer> getRowValues(int y, Integer[][] matrix){
        Set<Integer> rowValues = new HashSet<>();
        for (int x = 0; x < 9; x++) {
            rowValues.add(matrix[y][x]);
        }
        return rowValues;
    }

    public Set<Integer> getSqrValues(int y, int x, Integer[][] matrix) {
        Set<Integer> sqrValues = new HashSet<>();
        for (int i = y - y % 3; i < y - y % 3 + 3; i++) {
            for (int j = x - x % 3; j < x - x % 3 + 3; j++) {
                sqrValues.add(matrix[i][j]);
            }
        }
        return sqrValues;
    }

    public Set<Integer> getLegitValues(Set<Integer> colValues, Set<Integer> rowValues, Set<Integer> sqrValues) {
        Set<Integer> legitValues = new HashSet<>();
        for (int i = 1; i <= 9; i++){
            if (!colValues.contains(i) && !rowValues.contains(i) && !sqrValues.contains(i)){
                legitValues.add(i);
            }
        }
        return legitValues;
    }
}
