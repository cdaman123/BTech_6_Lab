package com.aman.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,badd,bsub,bmul,bdiv,bclr,bdel,beql,bbkt;
    TextView eqn, ans;
    String equatin;
    byte sign_flag = 0;
    byte ans_flag = 0;
    byte dot_flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.btn0);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 =  findViewById(R.id.btn7);
        b8 =  findViewById(R.id.btn8);
        b9 =  findViewById(R.id.btn9);
        bdot =  findViewById(R.id.point);
        badd =  findViewById(R.id.add);
        bsub =  findViewById(R.id.sub);
        bmul =  findViewById(R.id.mlt);
        bdiv =  findViewById(R.id.dev);
        bclr =  findViewById(R.id.clr);
        bdel =  findViewById(R.id.del);
        beql =  findViewById(R.id.eql);
        bbkt =  findViewById(R.id.brkt);

        eqn = findViewById(R.id.eqn);
        ans = findViewById(R.id.ans);

        equatin = "0";

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin+= '0';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin+= '1';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '2';
                eqn.setText(equatin);
                ans.setText("0");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '3';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '4';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '5';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '6';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '7';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '8';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(equatin == "0"){
                    equatin = "";
                }
                sign_flag = 0;
                equatin += '9';
                eqn.setText(equatin);
                ans.setText("0");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sign_flag == 0) {
                    if (dot_flag == 0) {
                        dot_flag = 1;
                        sign_flag = 1;
                        equatin += '.';
                        eqn.setText(equatin);
                        ans.setText("0");
                    }
                }
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans_flag == 1){
                    ans_flag = 0;
                    equatin = (String) ans.getText();
                    dot_flag = 0;
                }
                if (sign_flag == 0) {
                    equatin += '+';
                    eqn.setText(equatin);
                    ans.setText("0");
                    sign_flag = 1;
                    dot_flag = 0;
                }
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans_flag == 1){
                    ans_flag = 0;
                    equatin = (String) ans.getText();
                    dot_flag = 0;
                }
                if (sign_flag == 0) {
                    sign_flag = 1;
                    equatin += '-';
                    eqn.setText(equatin);
                    ans.setText("0");
                    dot_flag = 0;
                }
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans_flag == 1){
                    ans_flag = 0;
                    equatin = (String) ans.getText();
                    dot_flag = 0;
                }
                if (sign_flag == 0) {
                    sign_flag = 1;
                    equatin += '*';
                    eqn.setText(equatin);
                    ans.setText("0");
                    dot_flag = 0;
                }
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans_flag == 1){
                    ans_flag = 0;
                    equatin = (String) ans.getText();
                    dot_flag = 0;
                }
                if (sign_flag == 0) {
                    sign_flag = 1;
                    equatin += '/';
                    eqn.setText(equatin);
                    ans.setText("0");
                    dot_flag = 0;
                }
            }
        });
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equatin = "0";
                eqn.setText(equatin);
                ans.setText("0");
                sign_flag = 0;
                dot_flag = 0;
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equatin.length() >1) {
                    equatin = equatin.substring(0,equatin.length()-1);
                    eqn.setText(equatin);
                    ans.setText("0");
                    if (equatin.charAt(equatin.length()-1) == '+' ||
                            equatin.charAt(equatin.length()-1) == '-' ||
                            equatin.charAt(equatin.length()-1) == '*' ||
                            equatin.charAt(equatin.length()-1) == '/' ||
                            equatin.charAt(equatin.length()-1) == '.' ||
                            equatin.charAt(equatin.length()-1) == '^'){
                        sign_flag = 1;
                    }
                    else{
                        sign_flag = 0;
                    }
                    if(equatin.charAt(equatin.length()-1) == '.'){
                        dot_flag = 0;
                    }
                }
                else{
                    if (equatin.length()== 1){
                        equatin = "0";
                        sign_flag = 0;
                        eqn.setText(equatin);
                        ans.setText("0");
                        dot_flag = 0;
                    }
                }
            }
        });
        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equatin.length()>0) {
                    Expression expression = new ExpressionBuilder(equatin).build();
                    try {
                        double result = expression.evaluate();
                        if (Math.round(result) == result){
                            ans.setText(Long.toString(Math.round(result)));
                        }
                        else {
                            ans.setText(Double.toString(result));
                        }
                        eqn.setText(equatin);
                        equatin = "0";
                    } catch (RuntimeException ex) {
                        ans.setText("ERROR");
                        eqn.setText(equatin);
                        equatin = "0";
                    }
                    sign_flag = 0;
                    ans_flag = 1;
                    dot_flag = 0;
                    eqn.setText(equatin);
                }
            }
        });
        bbkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans_flag == 1){
                    ans_flag = 0;
                    equatin = (String) ans.getText();
                    dot_flag = 0;
                }
                if (sign_flag == 0) {
                    sign_flag = 1;
                    equatin += '^';
                    eqn.setText(equatin);
                    ans.setText("0");
                    dot_flag = 0;
                }
            }
        });



    }
}