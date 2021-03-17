package com.evgeniykim.vpntest.UI;

import android.view.animation.Interpolator;

public class BounceInterpolator implements Interpolator {

    private double mAmplitude, mFrequency;

    public BounceInterpolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    @Override
    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time / mAmplitude) * Math.cos(mFrequency * time));
    }
}
