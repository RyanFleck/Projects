package com.rcf.cb_helloandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int x = 0;
    private TextView tv;
    private SharedPreferences prefs;
    private String storage_key = "count-value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide decorations, clear status bar color.
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);

        prefs = getApplicationContext().getSharedPreferences("cb-counter",0);



        if(prefs.contains(storage_key)){
            x = prefs.getInt(storage_key,0);
            Toast.makeText(this, "Counter has val "+x, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "New counter.", Toast.LENGTH_SHORT).show();
        }

        // Set textview, update text.
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

    public void set(int y){
        x = y;

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

        prefs.edit().putInt(storage_key,x).apply();

    }
}
