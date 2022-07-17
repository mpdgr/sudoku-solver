package com.mpdgr.sudokusolver.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SudokuRepository extends JpaRepository<SudokuEntity, Long> {
}
