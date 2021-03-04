package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bDot,bAdd,bSub,bMul,bDiv,bEql,bClr,bDel;
    TextView disp;
    String eval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b_1);
        b2 = (Button) findViewById(R.id.b_2);
        b3 = (Button) findViewById(R.id.b_3);
        b4 = (Button) findViewById(R.id.b_4);
        b5 = (Button) findViewById(R.id.b_5);
        b6 = (Button) findViewById(R.id.b_6);
        b7 = (Button) findViewById(R.id.b_7);
        b8 = (Button) findViewById(R.id.b_8);
        b9 = (Button) findViewById(R.id.b_9);
        b0 = (Button) findViewById(R.id.b_0);
        bDot = (Button) findViewById(R.id.b_dot);
        bAdd = (Button) findViewById(R.id.b_add);
        bSub = (Button) findViewById(R.id.b_sub);
        bMul = (Button) findViewById(R.id.b_mul);
        bDiv = (Button) findViewById(R.id.b_div);
        bEql = (Button) findViewById(R.id.b_eql);
        bClr = (Button) findViewById(R.id.b_c);
        bDel = (Button) findViewById(R.id.b_del);

        disp = (TextView) findViewById(R.id.display);

        eval = "0";

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '1';
                disp.setText(eval);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '2';
                disp.setText(eval);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '3';
                disp.setText(eval);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '4';
                disp.setText(eval);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '5';
                disp.setText(eval);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '6';
                disp.setText(eval);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '7';
                disp.setText(eval);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '8';
                disp.setText(eval);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '9';
                disp.setText(eval);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '0';
                disp.setText(eval);
            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '+';
                disp.setText(eval);
            }
        });
        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '-';
                disp.setText(eval);
            }
        });
        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '/';
                disp.setText(eval);
            }
        });
        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '*';
                disp.setText(eval);
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval += '.';
                disp.setText(eval);
            }
        });
        bClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval =  "0";
                disp.setText(eval);
            }
        });
        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eval.length() >0) {
                    eval = eval.substring(0,eval.length()-1);
                    disp.setText(eval);
                }


            }
        });
        bEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eval.length()>0){
                Expression expression = new ExpressionBuilder(eval).build();
                try {
                    double result = expression.evaluate();
                    disp.setText(Double.toString(result));
                    eval = "0";
                }
                catch (RuntimeException ex){
                    disp.setText("ERROR");
                    eval = "0";
                }
            }}
        });

    }
}