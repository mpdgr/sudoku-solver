package com.mpdgr.sudokusolver.data;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CSVReader {
    private final SudokuRepository repository;

    @PostConstruct
    public void writeCsvFromBean() throws FileNotFoundException {
        String fileBase = "src\\main\\resources\\static\\database\\sudoku_base3.csv";
        List<SudokuEntity> sudokus = beanBuilder(fileBase, SudokuEntity.class);
        sudokus.forEach(repository::save);
        System.out.println(repository.getById(1L));
    }

    public <T> List<T> beanBuilder(String fileName, Class<T> type) throws FileNotFoundException {
        return new CsvToBeanBuilder<T>(new FileReader(fileName))
                .withIgnoreEmptyLine(true)
                .withType(type)
                .build()
                .parse();
    }
}