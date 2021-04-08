package com.aman.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import  android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spn1,spn2;
    Button btn1, btn2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner1);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button1);

        tv = findViewById(R.id.textview);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String col_name = spn1.getSelectedItem().toString();
                int color = getColor(col_name);
                tv.setTextColor(color);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = Integer.parseInt(spn2.getSelectedItem().toString());

                tv.setTextSize(size);

            }
        });
    }

    public int getColor(String color_name) {
        if (color_name.equals("Red")) { return Color.RED;}
        if (color_name.equals("Blue")) { return Color.BLUE; }
        if (color_name.equals("Black")) { return Color.BLACK; }
        if(color_name.equals("Green")){ return Color.GREEN;}
        if(color_name.equals("Gray")){ return Color.GRAY;}
        if(color_name.equals("Cyan")){ return Color.CYAN;}
        else{ return Color.MAGENTA; }
    }
}