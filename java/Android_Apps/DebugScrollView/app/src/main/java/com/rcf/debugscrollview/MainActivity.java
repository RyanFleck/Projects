package com.rcf.debugscrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get main linear layout.
        LinearLayout x = findViewById(R.id.main_linear_layout);

        for(int i=1; i<=100; i++){
            TextView y = new TextView(this);
            String text = Calendar.getInstance().getTime().toString()+" I'm #"+i;
            y.setText(text);
            x.addView(y);
        }


    }
}
