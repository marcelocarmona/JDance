package com.example.jdance.app.util;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by mclo on 20/02/14.
 * <p/>
 * Listener para mostrar el velor del seekbar mientras se mueve
 */
public class NegativeOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

    private TextView numberLabel;
    private int negativeProgress;

    public NegativeOnSeekBarChangeListener(TextView numberLabel, int negativeProgress) {
        this.numberLabel = numberLabel;
        this.negativeProgress = negativeProgress;
    }

    public NegativeOnSeekBarChangeListener(TextView numberLabel) {
        this.numberLabel = numberLabel;
        negativeProgress = 0;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        numberLabel.setText(String.valueOf(progress - negativeProgress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
