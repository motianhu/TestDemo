package com.smona.app.demo.curve;

public class SampleTable {

    private final float[] mTable;
    private final float mStart;
    private final float mEnd;
    private final int mNum;

    public SampleTable(float start, float end, int num, float[] table) {
        this.mStart = start;
        this.mEnd = end;
        this.mNum = num;
        this.mTable = table;
    }

    public boolean inTable(float t) {
        return (t >= this.mStart) && (t <= this.mEnd);
    }

    public float getValue(float t) {
        int index = (int) ((t - this.mStart) / (this.mEnd - this.mStart) * (this.mNum - 1));
        return this.mTable[index];
    }
}
