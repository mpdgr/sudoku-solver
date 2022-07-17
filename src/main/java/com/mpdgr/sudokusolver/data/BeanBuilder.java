package com.mpdgr.sudokusolver.data;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class BeanBuilder {
    public <T> List<T> beanBuilder(String fileName, Class<T> type) throws FileNotFoundException {
        return new CsvToBeanBuilder<T>(new FileReader(fileName))
                .withIgnoreEmptyLine(true)
                .withType(type)
                .build()
                .parse();
    }
}
