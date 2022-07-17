package com.mpdgr.sudokusolver.service;

public class InTimeCheck {
    private boolean inTime = true;

    public void timeOut() {
        this.inTime = false;
    }

    public boolean inTime() {
        return inTime;
    }
}
