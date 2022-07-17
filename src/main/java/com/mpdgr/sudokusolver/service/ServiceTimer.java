package com.mpdgr.sudokusolver.service;

import lombok.SneakyThrows;
import java.util.concurrent.CountDownLatch;

public class ServiceTimer implements Runnable {
    private final long deadline;
    private final CountDownLatch latch;
    private final InTimeCheck inTimeCheck;

    public ServiceTimer(long deadline, CountDownLatch latch, InTimeCheck inTimeCheck) {
        this.deadline = deadline;
        this.latch = latch;
        this.inTimeCheck = inTimeCheck;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (getTime() < deadline){
            Thread.sleep(1000);
        }
        inTimeCheck.timeOut();
        latch.countDown();
    }
    private long getTime(){
        return System.currentTimeMillis();
    }
}
