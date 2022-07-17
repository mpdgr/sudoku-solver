package com.mpdgr.sudokusolver.service;

import com.mpdgr.sudokusolver.controller.InvalidInputException;
import com.mpdgr.sudokusolver.controller.Mapper.InputMapper;
import com.mpdgr.sudokusolver.data.SudokuEntity;
import com.mpdgr.sudokusolver.data.SudokuRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SudokuServiceTest {
    @Autowired
    SudokuRepository repository;
    @Autowired
    InputMapper mapper;

    @Test
    @Disabled
    void processTest() {
        SudokuService service = new SudokuService();
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

        List<Boolean> solutions = matrices.stream()
                .map(m -> {
                    try {
                        Solution s = service.process(m);
                        printer(s);
                        return s;
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                    return new Solution();
                })
                .map(s -> {
                    return s.isSolvable();
                })
                .collect(Collectors.toList());

        Assertions.assertFalse(solutions.contains(false));
    }

    public void printer (Solution solution){
        Integer[][] sudoku = solution.getSolution();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(sudoku[x][y] + "  ");
                System.out.print(y == 8 ? '\n' : "");
            }
        }
        System.out.println("Iterations " + solution.getIterationCount());
        System.out.println("Op time " + solution.getOperationTime());
        System.out.println("Winner mode " + solution.getWinnerMode());
        System.out.println("Winner thread " + solution.getWinnerThreadNr());
    }
}