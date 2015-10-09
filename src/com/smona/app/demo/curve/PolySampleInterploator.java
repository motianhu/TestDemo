package com.smona.app.demo.curve;

import java.util.ArrayList;

import android.view.animation.Interpolator;

public class PolySampleInterploator implements Interpolator {
    private final PolynomialInterpolator mPolynomialInterpolator;
    private final ArrayList<SampleTable> mListSample;

    PolySampleInterploator(PolynomialInterpolator polyInt,
            ArrayList<SampleTable> listSample) {
        this.mPolynomialInterpolator = polyInt;
        this.mListSample = listSample;
    }

    public float getInterpolation(float t) {
        for (SampleTable table : this.mListSample) {
            if (table.inTable(t)) {
                return table.getValue(t);
            }
        }

        if (this.mPolynomialInterpolator != null) {
            return this.mPolynomialInterpolator.getInterpolation(t);
        }

        return t;
    }
}
