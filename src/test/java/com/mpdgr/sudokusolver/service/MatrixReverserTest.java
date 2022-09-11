package com.mpdgr.sudokusolver.service;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MatrixReverserTest {
    Integer[][] testMatrix = new Integer[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    Integer[][] diagReversed1 = new Integer[][]{
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
    };

    Integer[][] otherDiagReversed = new Integer[][]{
            {9, 6, 3},
            {8, 5, 2},
            {7, 4, 1}
    };

    Integer[][] xReversed = new Integer[][]{
            {3, 2, 1},
            {6, 5, 4},
            {9, 8, 7}
    };

    Integer[][] yReversed = new Integer[][]{
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    Integer[][] xyReversed = new Integer[][]{
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
    };

    Integer[][] testMatrixLong = new Integer[][]{
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10, 11, 12},
            {13, 14, 15, 16},
    };

    Integer[][] xyReversedLong = new Integer[][]{
            {16, 15, 14, 13},
            {12, 11, 10,  9},
            { 8,  7,  6,  5},
            { 4,  3,  2,  1},
    };

    @Test
    void reverseXtest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseX(testMatrix);
        assertTrue(Arrays.deepEquals(reversed, xReversed));
    }

    @Test
    void reverseYtest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseY(testMatrix);
        assertTrue(Arrays.deepEquals(reversed, yReversed));
    }

    @Test
    void reverseXYTest() {
        MatrixReverser reverser = new MatrixReverser();

        Integer[][] reversed = reverser.reverseXY(testMatrixLong);
        assertTrue(Arrays.deepEquals(xyReversedLong, reversed));

        Integer[][] reversed1 = reverser.reverseY(reverser.reverseX(testMatrixLong));
        assertTrue(Arrays.deepEquals(xyReversedLong, reversed1));
        Integer[][] reversed2 = reverser.reverseX(reverser.reverseY(testMatrixLong));
        assertTrue(Arrays.deepEquals(xyReversedLong, reversed2));
    }

    @Test
    void reverseDiagonalTest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseDiagonal(testMatrix);
        assertTrue(Arrays.deepEquals(diagReversed1, reversed));
    }

    @Test
    void reverseOtherDiagonalTest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseOtherDiagonal(testMatrix);
        assertTrue(Arrays.deepEquals(otherDiagReversed, reversed));
    }

    @Test
    void reverseDiagAndBackTest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseDiagonal(testMatrix);
        Integer[][] reversedBack = reverser.reverseDiagonal(reversed);
        assertFalse(Arrays.deepEquals(reversed, reversedBack));
        assertTrue(Arrays.deepEquals(testMatrix, reversedBack));
    }

    @Test
    void reverseOtherDiagAndBackTest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseOtherDiagonal(testMatrix);
        Integer[][] reversedBack = reverser.reverseOtherDiagonal(reversed);
        assertTrue(Arrays.deepEquals(testMatrix, reversedBack));
    }

    @Test
    void reverseXYAndBackTest() {
        MatrixReverser reverser = new MatrixReverser();
        Integer[][] reversed = reverser.reverseXY(testMatrix);
        Integer[][] reversedBack = reverser.reverseXY(reversed);
        assertFalse(Arrays.deepEquals(reversed, reversedBack));
        assertTrue(Arrays.deepEquals(testMatrix, reversedBack));
    }

    @Test
    void reverseTest() {
        MatrixReverser reverser = new MatrixReverser();
        TransposeMode mode = TransposeMode.X;
        Integer[][] reversed = reverser.reverse(testMatrixLong, mode);
        Integer[][] back = reverser.reverse(reversed, mode);
        assertFalse(Arrays.deepEquals(reversed, back));
        assertTrue(Arrays.deepEquals(back, testMatrixLong));
    }
}