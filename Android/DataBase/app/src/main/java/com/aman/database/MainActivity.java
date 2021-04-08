package com.aman.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mName[] = {"Aman1","Aman2","Aman3","Aman4","Aman5","Aman6","Aman7","Aman8","Aman9","Aman10","Aman11","Aman12"};
    String nRNo[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviwe);

        MyAdapter adapter = new MyAdapter(this,mName,nRNo);

        listView.setAdapter(adapter);





    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rName[];
        String rRoll[];

        MyAdapter(Context c, String name[], String RollNo[]){
            super(c, R.layout.row, R.id.listviwe, name);
            this.context = c;
            this.rName = name;
            this.rRoll = RollNo;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent,false);
            TextView tv1 = row.findViewById(R.id.name);
            TextView tv2 = row.findViewById(R.id.rno);

            tv1.setText(rName[position]);
            tv2.setText(rRoll[position]);




            return row;
        }
    }
}