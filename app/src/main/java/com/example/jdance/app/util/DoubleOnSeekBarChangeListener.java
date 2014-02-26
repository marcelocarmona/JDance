package com.example.jdance.app.util;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by mclo on 20/02/14.
 * <p/>
 * Listener para mostrar el velor del seekbar mientras se mueve
 */
public class DoubleOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

    private TextView numberLabel;
    private double percentage;

    public DoubleOnSeekBarChangeListener(TextView numberLabel, double percentage) {
        this.numberLabel = numberLabel;
        this.percentage = percentage;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        numberLabel.setText(String.format("%.1f", (progress * percentage)));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
