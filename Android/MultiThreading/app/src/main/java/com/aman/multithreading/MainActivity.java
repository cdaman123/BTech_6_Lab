package com.aman.multithreading;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity
{
    ImageView img;
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button)findViewById(R.id.btn);
        bt2= (Button) findViewById(R.id.btn2);
        img = (ImageView)findViewById(R.id.iv);

        bt1.setOnClickListener(v -> new Thread(() -> img.post(() -> img.setImageResource(R.drawable.a))).start());

        bt2.setOnClickListener(v -> new Thread(() -> img.post(() -> img.setImageResource(R.drawable.b))).start());
    }
}