package com.mpdgr.sudokusolver.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

class WorkerTest {

    @Test
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
        ReverseMode reverseMode = ReverseMode.NONE;
        CountDownLatch latch = new CountDownLatch(3);
        worker.setReverseMode(reverseMode);
        worker.setTask(testSudoku);
        worker.setLatch(latch);
        System.out.println(Arrays.deepToString(worker.call().getSolution()));
    }
}