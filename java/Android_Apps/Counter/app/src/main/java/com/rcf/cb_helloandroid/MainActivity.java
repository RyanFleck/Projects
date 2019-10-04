package com.rcf.cb_helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int x = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.upper_text);
        updateText();
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

    private void updateText() {
        tv.setText(String.valueOf(x));

        // Set visibility of decrement button.
        if (x > 0) {
            findViewById(R.id.button_lower).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.button_lower).setVisibility(View.INVISIBLE);
        }
    }
}
