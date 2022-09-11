package com.mpdgr.sudokusolver.controller;

import com.mpdgr.sudokusolver.service.SudokuContent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SudokuOutput extends SudokuContent {
    private String totalTime;
    private String iterNr;
    private String winnerThreadNr;
    private String winnerMode;
    }
