package com.mpdgr.sudokusolver.controller;

import com.mpdgr.sudokusolver.controller.Mapper.VModelMapper;
import com.mpdgr.sudokusolver.controller.Mapper.OutputMapper;
import com.mpdgr.sudokusolver.service.ServiceException;
import com.mpdgr.sudokusolver.service.Solution;
import com.mpdgr.sudokusolver.service.SudokuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/solve")
public class SudokuController {
    private final VModelMapper inMapper;
    private final OutputMapper outMapper;
    private final MatrixValidator validator;
    private final SudokuService service;

    @GetMapping
    public String showSolver(Model model) {
        model.addAttribute("input", new SudokuInput());
        return "sdk";
    }

    @PostMapping
    public String showSolution(@ModelAttribute SudokuInput input, Model model) {
        final Integer[][] sudokuMatrix;
        try {
            sudokuMatrix = inMapper.inputToMatrix(input);
        } catch (InvalidInputException e) {
            return "invalidinput";
        }
        if (!validator.containsValidInts(sudokuMatrix)) {
            return "invalidinput";
        }
        if (!validator.inputNotContradictory(sudokuMatrix)) {
            return "nosolution";
        }
        SudokuOutput outputModel;
        try {
            Solution solution = service.process(sudokuMatrix);
            if (solution.isSolvable()) {
                outputModel = outMapper.solutionToOutput(solution);
            }
            else
                return "nosolution";
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
            return "servererror";
        }
        model.addAttribute("output", outputModel);
        return "sdkoutput";
    }
}