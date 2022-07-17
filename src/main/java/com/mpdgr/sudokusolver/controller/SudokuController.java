package com.mpdgr.sudokusolver.controller;

import com.mpdgr.sudokusolver.controller.Mapper.EntityMapper;
import com.mpdgr.sudokusolver.controller.Mapper.InputMapper;
import com.mpdgr.sudokusolver.controller.Mapper.OutputMapper;
import com.mpdgr.sudokusolver.data.SudokuEntity;
import com.mpdgr.sudokusolver.data.SudokuRepository;
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
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class SudokuController {
    private final InputMapper inMapper;
    private final OutputMapper outMapper;
    private final EntityMapper entityMapper;
    private final MatrixValidator validator;
    private final SudokuService service;
    private final SudokuRepository examplesRepository;

    @GetMapping(path = "/solve")
    public String showSolver(Model model) {
        model.addAttribute("input", new SudokuInput());
        return "sdk";
    }

    @GetMapping(path = "/example")
    public String showExample(Model model) {
        List<Long> entityIds = examplesRepository.findAll().stream()
                .map(SudokuEntity::getId)
                .collect(Collectors.toList());
        Random random = new Random();
        long randomID = entityIds.get(random.nextInt(entityIds.size()));
        SudokuInput input = entityMapper.entityToInput(examplesRepository.getById(randomID));
        model.addAttribute("input", input);
        return "sdk";
    }

    @PostMapping(path = "/solve")
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