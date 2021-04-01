package com.aman.graphicalprimitives;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Bitmap bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);

        bg =  Bitmap.createBitmap(720,1280,Bitmap.Config.RGB_565);
        img.setImageBitmap(bg);
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setTextSize(50);

        //1.
        paint.setColor(Color.RED);
        canvas.drawText("Rectangle",60,70,paint);
        canvas.drawRect(50,100,300,500,paint);

        //2.
        paint.setColor(Color.YELLOW);
        canvas.drawText("Square",450,70,paint);
        canvas.drawRect(450,150,650,350,paint);

        //3.
        paint.setColor(Color.CYAN);
        canvas.drawText("Circle",100,600,paint);
        canvas.drawCircle(175,800,125,paint);

        //4.
        paint.setColor(Color.MAGENTA);
        canvas.drawText("Oval",450,600,paint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(450,650,600,925,paint);
        }

        //5.
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10);
        canvas.drawText("Line",300,1000,paint);
        canvas.drawLine(100,1100,600,1100,paint);


    }
}