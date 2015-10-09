package com.smona.app.demo.curve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.view.animation.Interpolator;

public class InterpolatorCreator {
    private static InterpolatorCreator mInterpolatorCreator;
    private Map<String, double[]> mCoef = new HashMap<String, double[]>();

    public static InterpolatorCreator getInstance() {
        if (mInterpolatorCreator == null) {
            mInterpolatorCreator = new InterpolatorCreator();
        }
        return mInterpolatorCreator;
    }

    private InterpolatorCreator() {
        double[] A1InCubic = { 1.009570851042731D, -0.050295189132742D,
                0.03655554503885847D, -0.001167285803721024D };
        this.mCoef.put("A1-InCubic", A1InCubic);

        double[] A2InCirc = { 17895.095139779809D, -101582.11787746361D,
                252097.8769573044D, -359135.80484689452D, 324222.09034276358D,
                -193223.43030295739D, 76803.278031709764D,
                -20108.002596298949D, 3344.9211807689189D,
                -330.23399637978019D, 17.646729537344939D,
                -0.3449828415031531D, 0.0023755547653918D };
        this.mCoef.put("A2-InCirc", A2InCirc);

        double[] B1OutCubic = { -0.3356966727136838D, 1.692212251699857D,
                -3.424160444341367D, 3.060555798155701D, 0.003855727620805224D };
        this.mCoef.put("B1-OutCubic", B1OutCubic);

        double[] B2OutCirc = { -20.75151171579331D, 69.66663720328566D,
                -92.251687659036321D, 61.427554333354422D, -22.38715641091008D,
                5.197958483631661D, 0.0894100925667214D };
        this.mCoef.put("B2-OutCirc", B2OutCirc);

        double[] C1InOutCubict = { 641.63505940992286D, -2926.1621699991142D,
                5481.9334998362083D, -5418.6155108540033D, 3027.9950921095092D,
                -962.6316847881252D, 170.42836883313191D, -14.122831306966591D,
                0.5459971154878925D, -0.003614723179886091D };
        this.mCoef.put("C1-InOutCubict", C1InOutCubict);

        double[] C2InOutCustom1 = { 26.939940146188899D, -82.698165917815572D,
                83.06107520319992D, -14.100933492159561D, -27.306764365307899D,
                15.89380478913834D, -0.7951250637672376D, 0.0119664585489408D };
        this.mCoef.put("C2-InOutCustom1", C2InOutCustom1);

        double[] C3InOutCustom2 = { -696.19648285432072D, 3448.4656240279428D,
                -7268.6467050474739D, 8491.5813663876252D,
                -5994.7525847729676D, 2607.7738692725188D, -676.2918733448912D,
                91.082072444885867D, -2.029385818759387D, 0.009958686492732844D };
        this.mCoef.put("C3-InOutCustom2", C3InOutCustom2);

        double[] D1InBack = { 2.475233878944223D, -1.393858461193097D,
                -0.08902580512803852D, 0.005176066960818057D };
        this.mCoef.put("D1-InBack", D1InBack);

        double[] D2OutBack = { 2.571359456085631D, -6.204501718034058D,
                4.613747015250927D, 0.01588301485229142D };
        this.mCoef.put("D2-OutBack", D2OutBack);

        double[] D3InOutBack = { 120991.3359733135D, -786143.49882281211D,
                2244974.0269057131D, -3702155.5949229458D, 3897160.7360286089D,
                -2734940.7356395498D, 1299516.491462447D, -417124.5804916523D,
                88918.93234400556D, -12165.87611555044D, 1018.433914847953D,
                -49.494846923660369D, 0.8299519770978654D,
                -0.002682223396852069D };
        this.mCoef.put("D3-InOutBack", D3InOutBack);

        double[] E1OutElastic = { 18056.73921212499D, -100937.4165249572D,
                241885.2865035889D, -323847.28338413982D, 264338.98794679629D,
                -134419.10382828189D, 41544.553104034509D,
                -7155.7612643042739D, 534.11782572036122D, 0.8650299146053114D,
                0.0158953175401044D };
        this.mCoef.put("E1-OutElastic", E1OutElastic);
    }

    ArrayList<SampleTable> createSampleList(String name) {
        ArrayList<SampleTable> list = null;
        SampleTable table = null;

        if (name.equals("C2-InOutCustom1")) {
            list = new ArrayList<SampleTable>();
            float[] c2Sample1 = { 0.0F, 0.0F, 0.002F, 0.002F, 0.002F, 0.004F,
                    0.006F, 0.008F, 0.01F, 0.012F, 0.014F };
            table = new SampleTable(0.0F, 0.05F, 11, c2Sample1);
            list.add(table);
            float[] c2Sample2 = { 0.9968F, 0.9971F, 0.9974F, 0.9977F, 0.9981F,
                    0.9985F, 0.9989F, 0.99993F, 0.9997F, 0.9998F, 1.0F };
            table = new SampleTable(0.95F, 1.0F, 11, c2Sample2);
            list.add(table);
        } else if (name.equals("C3-InOutCustom2")) {
            list = new ArrayList<SampleTable>();
            float[] c3Sample1 = { 0.0F, 0.002F, 0.002F, 0.004F, 0.008F, 0.014F,
                    0.02F, 0.026F, 0.036F, 0.046F, 0.06F };
            table = new SampleTable(0.0F, 0.05F, 11, c3Sample1);
            list.add(table);
            float[] c3Sample2 = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F,
                    1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
            table = new SampleTable(0.94F, 1.0F, 13, c3Sample2);
            list.add(table);
        } else if (name.equals("B2-OutCirc")) {
            list = new ArrayList<SampleTable>();
            float[] OutCirc = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F,
                    1.0F };
            table = new SampleTable(0.92F, 1.0F, 9, OutCirc);
            list.add(table);
        }
        return list;
    }

    public Interpolator create(String name) {
        double[] c = (double[]) this.mCoef.get(name);
        ArrayList<SampleTable> listSample = createSampleList(name);

        if (c == null) {
            return null;
        }

        if (listSample == null) {
            return new PolynomialInterpolator(c);
        }

        return new PolySampleInterploator(new PolynomialInterpolator(c),
                listSample);
    }

    public Set<String> getNames() {
        return this.mCoef.keySet();
    }
}
