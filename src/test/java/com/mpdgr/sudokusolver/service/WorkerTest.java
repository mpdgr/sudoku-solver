package com.mpdgr.sudokusolver.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

class WorkerTest {

    @Test
    @Disabled
    void callTest() {
        Integer[][] testSudoku = {
                {3, 2, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}

        };
        Worker worker = new Worker();
        TransposeMode transposeMode = TransposeMode.NONE;
        CountDownLatch latch = new CountDownLatch(3);
        worker.setTransposeMode(transposeMode);
        worker.setTask(testSudoku);
        worker.setLatch(latch);
        System.out.println(Arrays.deepToString(worker.call().getSolution()));
    }
}