package com.aman.database1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn, btn_save, btn_del, btn_delall;
    EditText et_name, et_roll, et_marks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDatabase udb = UserDatabase.getDatabase(getApplicationContext());

        btn = findViewById(R.id.btn_viewall);
        btn_save = findViewById(R.id.btn_ins);
        btn_del = findViewById(R.id.btn_del);
        btn_delall = findViewById(R.id.btn_delall);
        et_name = findViewById(R.id.et_nam);
        et_roll = findViewById(R.id.et_rol);
        et_marks = findViewById(R.id.et_mark);

        Intent intent  = new Intent(this, All_student.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(intent);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = et_name.getText().toString();
                String roll = et_roll.getText().toString();
                String marks = et_marks.getText().toString();

                User user = new User(roll,name,marks);

                try {

                    udb.userDao().insert(user);
                    Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(), "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roll = et_roll.getText().toString();
                User user = udb.userDao().getUser(roll);

                try {
                    udb.userDao().delet(user);
                    Toast.makeText(getBaseContext(), "Delete Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(), "Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_delall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    udb.userDao().deleteAll();
                    Toast.makeText(getBaseContext(), "Table Deleted", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}