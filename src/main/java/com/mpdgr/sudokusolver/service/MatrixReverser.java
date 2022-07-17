package com.mpdgr.sudokusolver.service;


public class MatrixReverser {

    public Integer[][] reverse(Integer[][] matrix, ReverseMode reverseMode) {
        Integer[][] reversed;
        switch (reverseMode) {
            case NONE:
                reversed = matrix;
                break;
            case X:
                reversed = reverseX(matrix);
                break;
            case Y:
                reversed = reverseY(matrix);
                break;
            case XY:
                reversed = reverseXY(matrix);
                break;
            case DIAG:
                reversed = reverseDiagonal(matrix);
                break;
            case OTHERDIAG:
                reversed = reverseOtherDiagonal(matrix);
                break;
            default:
                throw new IllegalStateException("Reverser exception");
        }
        return reversed;
    }

    public Integer[][] reverseX(Integer[][] matrix) {
        Integer[][] reversed = new Integer[matrix.length][matrix.length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                reversed[y][x] = matrix[y][matrix.length - x -1];
            }
        }
        return reversed;
    }

    public Integer[][] reverseY(Integer[][] matrix) {
        Integer[][] reversed = new Integer[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            reversed[i] = matrix[matrix.length - i - 1];
        }
        return reversed;
    }

    public Integer[][] reverseXY(Integer[][] matrix) {
        return reverseX(reverseY(matrix));
    }

    public Integer[][] reverseDiagonal(Integer[][] matrix) {
        Integer[][] reversed = new Integer[matrix.length][matrix.length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                reversed[y][x] = matrix[x][y];
            }
        }
        return reversed;
    }

    public Integer[][] reverseOtherDiagonal(Integer[][] matrix) {
        Integer[][] reversed = new Integer[matrix.length][matrix.length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                reversed[y][x] = matrix[matrix.length - x - 1][matrix.length - y - 1];
            }
        }
        return reversed;
    }
}

