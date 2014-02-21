package com.example.jdance.app.util;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by mclo on 20/02/14.
 * <p/>
 * Listener para mostrar el velor del seekbar mientras se mueve
 */
public class MyOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

    private TextView numberLabel;
    private int NegativeProgress;

    public MyOnSeekBarChangeListener(TextView numberLabel, int negativeProgress) {
        this.numberLabel = numberLabel;
        NegativeProgress = negativeProgress;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        numberLabel.setText(String.valueOf(progress - NegativeProgress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
