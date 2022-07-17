package com.mpdgr.sudokusolver.controller;

import com.mpdgr.sudokusolver.controller.Mapper.InputMapper;
import com.mpdgr.sudokusolver.data.SudokuEntity;
import com.mpdgr.sudokusolver.data.SudokuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatrixValidatorTest {
    @Autowired
    SudokuRepository repository;
    @Autowired
    InputMapper mapper;


    @Test
    void inputNotContradictory() {
        MatrixValidator validator = new MatrixValidator();
        boolean allValid = true;
        List<SudokuEntity> sudokus = repository.findAll();
        List<Integer[][]> matrices = sudokus.stream()
                .map(s -> {
                    try {
                        return mapper.inputToMatrix(s);
                    } catch (InvalidInputException e) {
                        e.printStackTrace();
                    }
                    return new Integer[9][9];
                })
                .collect(Collectors.toList());
        for (var matrix : matrices){
            if (!validator.inputNotContradictory(matrix)){
                allValid = false;
            }
            System.out.println("checked");
        }
        assertTrue(allValid);
    }

    @Test
    void printTest() {
        String[][] matrix = new String[][]{{"x1","x2","x3"},{"y1","y2","y3"}};
        System.out.println(matrix[1][2]);
        System.out.println(Arrays.deepToString(matrix));
        List<SudokuEntity> sudokus = repository.findAll();
        List<Integer[][]> matrices = sudokus.stream()
                .map(s -> {
                    try {
                        return mapper.inputToMatrix(s);
                    } catch (InvalidInputException e) {
                        e.printStackTrace();
                    }
                    return new Integer[9][9];
                })
                .collect(Collectors.toList());
        for (var mtrx : matrices){
            System.out.println(Arrays.deepToString(mtrx));
        }
    }
}