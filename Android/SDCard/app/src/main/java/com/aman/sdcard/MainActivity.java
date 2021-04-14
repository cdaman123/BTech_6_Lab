package com.aman.sdcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
{
    private static final int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    EditText e1;
    Button write,read;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                EXTERNAL_STORAGE_PERMISSION_CODE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1= (EditText) findViewById(R.id.editText);
        write= (Button) findViewById(R.id.btn_write);
        read= (Button) findViewById(R.id.btn_read);

        write.setOnClickListener(v -> {
            String message=e1.getText().toString();
            try
            {
                File f=new File("/sdcard/aman.txt");
                f.createNewFile();
                FileOutputStream fout=new FileOutputStream(f);
                fout.write(message.getBytes());
                fout.close();
                Toast.makeText(getBaseContext(),"Written Successfully",Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        read.setOnClickListener(v -> {
            String message;
            StringBuilder buf = new StringBuilder();
            try
            {
                File f = new File("/sdcard/myfile.txt");
                FileInputStream fin = new FileInputStream(f);
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                while ((message = br.readLine()) != null)
                {
                    buf.append(message);
                }
                e1.setText(buf.toString());
                br.close();
                fin.close();
                Toast.makeText(getBaseContext(),"Data Received Successfully",Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}