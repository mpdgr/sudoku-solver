package com.pdgr.SudokuSolver;

import java.time.Instant;
import java.util.Date;

public class Processor {

    public static SudokuOutputModel process(Integer[][] newSudoku){
        long timeStart = System.currentTimeMillis();
        GameBoard sudoku = new GameBoard(newSudoku);
        BoardCrawler boardCrawler = new BoardCrawler();
        int[] boardAsArray =  boardCrawler.matrixArrayGenerator(sudoku.getMatrix());
        int[] fixedPointsAsArray = boardCrawler.fixedPointsArrayGenerator(sudoku.getFixedPointsMatrix());
        int startPoint = 0;
        int direction = 1;
        Integer[][] solvedSudoku = boardCrawler.crawler(boardAsArray, fixedPointsAsArray, startPoint, direction);
        long timeEnd = System.currentTimeMillis();
        long totalTime = timeEnd - timeStart;
        //printer(solvedSudoku, totalTime);
        return modelGenerator(solvedSudoku, totalTime);
    }

    public static void printer (Integer[][] sudoku, long totalTime){
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(sudoku[x][y] + "  ");
                System.out.print(y == 8 ? '\n' : "");
            }
        }
        System.out.println("\nOperation time: " + totalTime + " milliseconds");
    }

    public static SudokuOutputModel modelGenerator (Integer[][] sudoku, long totalTime){
        SudokuOutputModel outputModel = new SudokuOutputModel();

        outputModel.setV11(sudoku[0][0].toString());
        outputModel.setV21(sudoku[0][1].toString());
        outputModel.setV31(sudoku[0][2].toString());
        outputModel.setV41(sudoku[0][3].toString());
        outputModel.setV51(sudoku[0][4].toString());
        outputModel.setV61(sudoku[0][5].toString());
        outputModel.setV71(sudoku[0][6].toString());
        outputModel.setV81(sudoku[0][7].toString());
        outputModel.setV91(sudoku[0][8].toString());

        outputModel.setV12(sudoku[1][0].toString());
        outputModel.setV22(sudoku[1][1].toString());
        outputModel.setV32(sudoku[1][2].toString());
        outputModel.setV42(sudoku[1][3].toString());
        outputModel.setV52(sudoku[1][4].toString());
        outputModel.setV62(sudoku[1][5].toString());
        outputModel.setV72(sudoku[1][6].toString());
        outputModel.setV82(sudoku[1][7].toString());
        outputModel.setV92(sudoku[1][8].toString());

        outputModel.setV13(sudoku[2][0].toString());
        outputModel.setV23(sudoku[2][1].toString());
        outputModel.setV33(sudoku[2][2].toString());
        outputModel.setV43(sudoku[2][3].toString());
        outputModel.setV53(sudoku[2][4].toString());
        outputModel.setV63(sudoku[2][5].toString());
        outputModel.setV73(sudoku[2][6].toString());
        outputModel.setV83(sudoku[2][7].toString());
        outputModel.setV93(sudoku[2][8].toString());

        outputModel.setV14(sudoku[3][0].toString());
        outputModel.setV24(sudoku[3][1].toString());
        outputModel.setV34(sudoku[3][2].toString());
        outputModel.setV44(sudoku[3][3].toString());
        outputModel.setV54(sudoku[3][4].toString());
        outputModel.setV64(sudoku[3][5].toString());
        outputModel.setV74(sudoku[3][6].toString());
        outputModel.setV84(sudoku[3][7].toString());
        outputModel.setV94(sudoku[3][8].toString());

        outputModel.setV15(sudoku[4][0].toString());
        outputModel.setV25(sudoku[4][1].toString());
        outputModel.setV35(sudoku[4][2].toString());
        outputModel.setV45(sudoku[4][3].toString());
        outputModel.setV55(sudoku[4][4].toString());
        outputModel.setV65(sudoku[4][5].toString());
        outputModel.setV75(sudoku[4][6].toString());
        outputModel.setV85(sudoku[4][7].toString());
        outputModel.setV95(sudoku[4][8].toString());

        outputModel.setV16(sudoku[5][0].toString());
        outputModel.setV26(sudoku[5][1].toString());
        outputModel.setV36(sudoku[5][2].toString());
        outputModel.setV46(sudoku[5][3].toString());
        outputModel.setV56(sudoku[5][4].toString());
        outputModel.setV66(sudoku[5][5].toString());
        outputModel.setV76(sudoku[5][6].toString());
        outputModel.setV86(sudoku[5][7].toString());
        outputModel.setV96(sudoku[5][8].toString());

        outputModel.setV17(sudoku[6][0].toString());
        outputModel.setV27(sudoku[6][1].toString());
        outputModel.setV37(sudoku[6][2].toString());
        outputModel.setV47(sudoku[6][3].toString());
        outputModel.setV57(sudoku[6][4].toString());
        outputModel.setV67(sudoku[6][5].toString());
        outputModel.setV77(sudoku[6][6].toString());
        outputModel.setV87(sudoku[6][7].toString());
        outputModel.setV97(sudoku[6][8].toString());

        outputModel.setV18(sudoku[7][0].toString());
        outputModel.setV28(sudoku[7][1].toString());
        outputModel.setV38(sudoku[7][2].toString());
        outputModel.setV48(sudoku[7][3].toString());
        outputModel.setV58(sudoku[7][4].toString());
        outputModel.setV68(sudoku[7][5].toString());
        outputModel.setV78(sudoku[7][6].toString());
        outputModel.setV88(sudoku[7][7].toString());
        outputModel.setV98(sudoku[7][8].toString());

        outputModel.setV19(sudoku[8][0].toString());
        outputModel.setV29(sudoku[8][1].toString());
        outputModel.setV39(sudoku[8][2].toString());
        outputModel.setV49(sudoku[8][3].toString());
        outputModel.setV59(sudoku[8][4].toString());
        outputModel.setV69(sudoku[8][5].toString());
        outputModel.setV79(sudoku[8][6].toString());
        outputModel.setV89(sudoku[8][7].toString());
        outputModel.setV99(sudoku[8][8].toString());

        outputModel.setTotalTime(String.valueOf(totalTime));
        outputModel.setIterNr(String.valueOf(IterationCount.getIter()));

        return outputModel;
    }
}