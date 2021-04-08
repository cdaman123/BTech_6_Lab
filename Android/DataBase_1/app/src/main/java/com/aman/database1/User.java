package com.aman.database1;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "roll_no")
    private String rollNo;

    @ColumnInfo(name = "Name")
    private String name;


    @ColumnInfo(name = "Marks")
    private String marks;

    public User(@NonNull String rollNo, String name, String marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
