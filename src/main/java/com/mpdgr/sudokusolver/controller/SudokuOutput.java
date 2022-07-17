package com.mpdgr.sudokusolver.controller;

import com.mpdgr.sudokusolver.service.SudokuStrings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SudokuOutput extends SudokuStrings {
    private String totalTime;
    private String iterNr;
    private String winnerThreadNr;
    private String winnerMode;
    }
