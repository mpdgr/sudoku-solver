package com.pdgr.SudokuSolver;

import java.util.*;

public abstract class BoardChecker {

    /* static method checkMatrix returns:
        0 if given Sudoku matrix is complete and correct
        1 if given Sudoku matrix has repeats (may also have empty spaces)
        2 if given Sudoku matrix has empty spaces but no repeats
     */

    public static int checkMatrix (Integer[][] matrix){

        //create lists to check columns, rows and squares for correct input

        //rows
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        List<Integer> row3 = new ArrayList<>();
        List<Integer> row4 = new ArrayList<>();
        List<Integer> row5 = new ArrayList<>();
        List<Integer> row6 = new ArrayList<>();
        List<Integer> row7 = new ArrayList<>();
        List<Integer> row8 = new ArrayList<>();
        List<Integer> row9 = new ArrayList<>();
        //columns
        List<Integer> col1 = new ArrayList<>();
        List<Integer> col2 = new ArrayList<>();
        List<Integer> col3 = new ArrayList<>();
        List<Integer> col4 = new ArrayList<>();
        List<Integer> col5 = new ArrayList<>();
        List<Integer> col6 = new ArrayList<>();
        List<Integer> col7 = new ArrayList<>();
        List<Integer> col8 = new ArrayList<>();
        List<Integer> col9 = new ArrayList<>();
        //squares
        List<Integer> sqr1 = new ArrayList<>();
        List<Integer> sqr2 = new ArrayList<>();
        List<Integer> sqr3 = new ArrayList<>();
        List<Integer> sqr4 = new ArrayList<>();
        List<Integer> sqr5 = new ArrayList<>();
        List<Integer> sqr6 = new ArrayList<>();
        List<Integer> sqr7 = new ArrayList<>();
        List<Integer> sqr8 = new ArrayList<>();
        List<Integer> sqr9 = new ArrayList<>();

        //loops add given matrix elements to array lists for checking

        //rows
        for (int x = 0; x < 9; x++) {row1.add(matrix[x][0]);}
        for (int x = 0; x < 9; x++) {row2.add(matrix[x][1]);}
        for (int x = 0; x < 9; x++) {row3.add(matrix[x][2]);}
        for (int x = 0; x < 9; x++) {row4.add(matrix[x][3]);}
        for (int x = 0; x < 9; x++) {row5.add(matrix[x][4]);}
        for (int x = 0; x < 9; x++) {row6.add(matrix[x][5]);}
        for (int x = 0; x < 9; x++) {row7.add(matrix[x][6]);}
        for (int x = 0; x < 9; x++) {row8.add(matrix[x][7]);}
        for (int x = 0; x < 9; x++) {row9.add(matrix[x][8]);}
        //columns
        for (int y = 0; y < 9; y++) {col1.add(matrix[0][y]);}
        for (int y = 0; y < 9; y++) {col2.add(matrix[1][y]);}
        for (int y = 0; y < 9; y++) {col3.add(matrix[2][y]);}
        for (int y = 0; y < 9; y++) {col4.add(matrix[3][y]);}
        for (int y = 0; y < 9; y++) {col5.add(matrix[4][y]);}
        for (int y = 0; y < 9; y++) {col6.add(matrix[5][y]);}
        for (int y = 0; y < 9; y++) {col7.add(matrix[6][y]);}
        for (int y = 0; y < 9; y++) {col8.add(matrix[7][y]);}
        for (int y = 0; y < 9; y++) {col9.add(matrix[8][y]);}
        //squares
        for (int x = 0; x < 3; x++) {for (int y = 0; y < 3; y++) {sqr1.add(matrix[x][y]);}}
        for (int x = 0; x < 3; x++) {for (int y = 3; y < 6; y++) {sqr2.add(matrix[x][y]);}}
        for (int x = 0; x < 3; x++) {for (int y = 6; y < 9; y++) {sqr3.add(matrix[x][y]);}}
        for (int x = 3; x < 6; x++) {for (int y = 0; y < 3; y++) {sqr4.add(matrix[x][y]);}}
        for (int x = 3; x < 6; x++) {for (int y = 3; y < 6; y++) {sqr5.add(matrix[x][y]);}}
        for (int x = 3; x < 6; x++) {for (int y = 6; y < 9; y++) {sqr6.add(matrix[x][y]);}}
        for (int x = 6; x < 9; x++) {for (int y = 0; y < 3; y++) {sqr7.add(matrix[x][y]);}}
        for (int x = 6; x < 9; x++) {for (int y = 3; y < 6; y++) {sqr8.add(matrix[x][y]);}}
        for (int x = 6; x < 9; x++) {for (int y = 6; y < 9; y++) {sqr9.add(matrix[x][y]);}}

        //linked list of all rows, cols and sqrs
        List<List<Integer>> listsList = new LinkedList<>();

        listsList.add(row1); listsList.add(col1); listsList.add(sqr1);
        listsList.add(row2); listsList.add(col2); listsList.add(sqr2);
        listsList.add(row3); listsList.add(col3); listsList.add(sqr3);
        listsList.add(row4); listsList.add(col4); listsList.add(sqr4);
        listsList.add(row5); listsList.add(col5); listsList.add(sqr5);
        listsList.add(row6); listsList.add(col6); listsList.add(sqr6);
        listsList.add(row7); listsList.add(col7); listsList.add(sqr7);
        listsList.add(row8); listsList.add(col8); listsList.add(sqr8);
        listsList.add(row9); listsList.add(col9); listsList.add(sqr9);

        //list to include results of checking of all lists for completes, empty spaces and repeats

        List<Integer> checkListResults = new LinkedList<>();

        //loop runs a check of every list for completes, empty spaces and repeats and adds scores to the results list
        //(using method checkList)

        for (List<Integer> list : listsList){
            int result = checkList(list);
            checkListResults.add(result);
        }

        int checkResult = 0;
        for (int i = 0; i < checkListResults.size(); i++){
            checkResult += checkListResults.get(i);
        }

        //Sudoku final check results

        if (checkResult == 0){
            return 0;                       //Sudoku complete (no repeats, no empty spaces)
        }
        else if (checkResult < 100 || checkResult % 100 != 0){
            return 1;                       //Sudoku has repeats (may also have empty spaces)
        }
        else return 2;                      //Sudoku has empty spaces but no repeats
    }

    //method runs a check of given list for completes, empty spaces and repeats

    public static int checkList (List<Integer> list){
        //sorting the list to find repeated values (other than 0)
        list.sort((Integer a, Integer b) -> {return Integer.valueOf(a) - Integer.valueOf(b);});

        //checking for repeats
        for (int i = 0; i < list.size() - 1; i++){
            if (Objects.equals(list.get(i), list.get(i + 1)) && list.get(i) != 0){
                return 1;                       //list has repeats
            }
        }
        if (list.contains(0)){
            return 100;                         //list includes empty spaces
        }
        else return 0;                          //list complete
    }
}
