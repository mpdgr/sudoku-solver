package com.mpdgr.sudokusolver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
    method checkMatrix returns:
        0 if given Sudoku matrix is complete and correct
        1 if given Sudoku matrix has repeats (may also have empty spaces)
        2 if given Sudoku matrix has empty spaces but no repeats
*/

public class BoardChecker {

    public int checkMatrix(Integer[][] matrix) {
        //List of all columns, rows, and squares
        List<List<Integer>> allLists = new ArrayList<>();
        allLists.addAll(getColumns(matrix));
        allLists.addAll(getRows(matrix));
        allLists.addAll(getSqrs(matrix));

        //Each list is checked for repeats and empty spaces,
        //results added to results list
        List<Integer> checkListResults = new ArrayList<>();

        for (List<Integer> list : allLists) {
            int result = checkList(list);
            checkListResults.add(result);
        }

        //Sudoku final check results
        int result;
        if (checkListResults.contains(1)){
            result = 1;
        } else if (checkListResults.contains(2)){
            result = 2;
        } else
            result = 0;
        return result;
    }

    public List<List<Integer>> getColumns(Integer[][] matrix){
        List<List<Integer>> columns = new ArrayList<>();
        for (int x = 0; x < 9; x++) {
            List<Integer> column = new ArrayList<>();
            for (int y = 0; y < 9; y++) {
                column.add(matrix[y][x]);
            }
            columns.add(column);
        }
        return columns;
    }

    public List<List<Integer>> getRows(Integer[][] matrix){
        List<List<Integer>> rows = new ArrayList<>();
        for (int y = 0; y < 9; y++) {
            List<Integer> row = new ArrayList<>();
            for (int x = 0; x < 9; x++) {
                row.add(matrix[y][x]);
            }
            rows.add(row);
        }
        return rows;
    }

    public List<List<Integer>> getSqrs(Integer[][] matrix) {
        List<List<Integer>> sqrs = new ArrayList<>();
        for (int y = 0; y <= 6; y += 3) {
            for (int x = 0; x <= 6; x += 3) {
                List<Integer> sqr = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sqr.add(matrix[y + i][x + j]);
                    }
                }
                sqrs.add(sqr);
            }
        }
        return sqrs;
    }

    //list checked for repeats and empty spaces
    public int checkList (List<Integer> list){

        list.sort((Integer a, Integer b) -> {return Integer.valueOf(a) - Integer.valueOf(b);});

        for (int i = 0; i < 8; i++){
            if ((Objects.equals(list.get(i), list.get(i + 1))) && list.get(i) != 0){
                return 1;        //list has repeats
            }
        }

        if (list.contains(0)){
            return 2;            //list includes empty spaces
        } else
            return 0;            //list complete
    }
}
