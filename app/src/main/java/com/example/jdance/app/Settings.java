package com.example.jdance.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Administrador on 10/12/13.
 */
public class Settings extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

    }

}
