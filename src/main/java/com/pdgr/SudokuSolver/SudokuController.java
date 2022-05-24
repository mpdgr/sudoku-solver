package com.pdgr.SudokuSolver;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/solve")
public class SudokuController {
    @GetMapping
    public String showSolver(Model model) {
        model.addAttribute("input", new SudokuInputModel());
        return "sdk";
    }

    @PostMapping
    public String showSolution(@ModelAttribute SudokuInputModel input, Model model) {
        if (InitialCheck.initialCheck(input)){
            SqlExport.exportToMySql(input);
            SudokuOutputModel outputModel = Sudoku.compSudoku(input);
            model.addAttribute("output", outputModel);
            return "sdk_output";
        }
        else {
            return "error";}
    }
}
