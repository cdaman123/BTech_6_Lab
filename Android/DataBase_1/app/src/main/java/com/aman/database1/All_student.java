package com.aman.database1;

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

import java.util.List;

public class All_student extends AppCompatActivity {
    ListView listView;


    List<User> allUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_student);

        UserDatabase udbn = UserDatabase.getDatabase(getApplicationContext());

        listView = findViewById(R.id.listviwe);

        allUser = udbn.userDao().getAll();

        MyAdapter adapter = new MyAdapter(this,allUser);

        listView.setAdapter(adapter);

    }


    class MyAdapter extends ArrayAdapter<User> {
        Context context;
        String rName[];
        String rRoll[];

        List<User> users;

        MyAdapter(Context c, List<User> users){
            super(c, R.layout.row, R.id.listviwe, users);
            this.context = c;
            this.users = users;
            //this.rRoll = RollNo;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent,false);
            TextView tv1 = row.findViewById(R.id.name);
            TextView tv2 = row.findViewById(R.id.rno);
            TextView tv3 = row.findViewById(R.id.marks);

            tv1.setText(users.get(position).getName());
            tv2.setText(users.get(position).getRollNo());
            tv3.setText(users.get(position).getMarks());




            return row;
        }
    }
}