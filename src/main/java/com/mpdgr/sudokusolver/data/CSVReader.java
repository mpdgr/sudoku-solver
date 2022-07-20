package com.mpdgr.sudokusolver.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CSVReader {
    private final BeanBuilder beanBuilder;
    private final SudokuRepository repository;

    @PostConstruct
    public void writeCsvFromBean() throws FileNotFoundException {
        String fileBase = "src\\main\\resources\\static\\database\\sudoku_base3.csv";
        List<SudokuEntity> sudokus = beanBuilder.beanBuilder(fileBase, SudokuEntity.class);
        sudokus.forEach(repository::save);
        System.out.println(repository.getById(1L));
    }
}