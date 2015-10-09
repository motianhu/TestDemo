package com.smona.app.demo.curve;

import android.view.animation.Interpolator;

public class PolynomialInterpolator implements Interpolator {
    private final double[] coef;

    public PolynomialInterpolator(double[] c) {
        this.coef = c;
    }

    public float getInterpolation(float x) {
        double y = 0.0D;
        int N = this.coef.length;

        for (int i = 0; i < N; i++) {
            double p = 1.0D;
            for (int j = 0; j < i; j++) {
                p *= x;
            }
            y += this.coef[(N - 1 - i)] * p;
        }

        return (float) y;
    }
}