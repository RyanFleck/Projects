package com.rcf.cb_helloandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int x = 0;
    private TextView tv;
    private SharedPreferences prefs;
    private String storage_key = "count-value";

    private Switch resetEnable;
    private Button decrementButton;
    private Button resetButton;

    private boolean resetVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide decorations, clear status bar color.
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);

        prefs = getApplicationContext().getSharedPreferences("cb-counter", 0);

        decrementButton = findViewById(R.id.button_lower);
        resetButton = findViewById(R.id.button_reset);

        resetEnable = (Switch) findViewById(R.id.reset_enable);
        resetEnable.setChecked(false);
        resetVisible = false;


        if (prefs.contains(storage_key)) {
            x = prefs.getInt(storage_key, 0);
        }

        // Set textview, update text.
        tv = findViewById(R.id.upper_text);
        updateText();

        resetEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resetVisible = resetEnable.isChecked();
                updateText();
            }
        });
    }

    // Onclick property set on button.
    public void increment(View view) {
        x++;
        updateText();
    }

    public void decrement(View view) {
        x--;

        // X cannot go below zero.
        if (x < 0) {
            x = 0;
        }

        updateText();
    }

    public void reset(View view) {
        x = 0;
        resetEnable.setChecked(false);
        updateText();
    }

    private void updateText() {
        tv.setText(String.valueOf(x));

        // Set visibility of decrement button.
        if (x > 0) {
            resetEnable.setClickable(true);

            if (resetVisible) {
                decrementButton.setVisibility(View.INVISIBLE);
                resetButton.setVisibility(View.VISIBLE);
            } else {
                decrementButton.setVisibility(View.VISIBLE);
                resetButton.setVisibility(View.INVISIBLE);
            }

        } else {
            resetEnable.setClickable(false);
            decrementButton.setVisibility(View.INVISIBLE);
            resetButton.setVisibility(View.INVISIBLE);
        }

        prefs.edit().putInt(storage_key, x).apply();

    }
}
