

package com.aman.sum;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    double  res;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.n1);
        number2 =  (EditText)  findViewById(R.id.n2);
        Button button;
        button = (Button) findViewById(R.id.sum_b);
        result = findViewById(R.id.sum_r);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(number1.getText().toString());
                double n2 = Double.parseDouble(number2.getText().toString());

                res = n1+n2;

                result.setTextColor(Color.GREEN);
                result.setTextSize(30);
                result.setText(Double.toString(res));



            }
        });

    }
}