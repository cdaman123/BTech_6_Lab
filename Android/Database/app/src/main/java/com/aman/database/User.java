package com.aman.database;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Entity(tableName = "user_table")
public class User {



    @NonNull
    @ColumnInfo(name = "fname")
    private String fName;
    @NonNull
    @ColumnInfo(name = "lname")
    private String lName;
    @NonNull
    @ColumnInfo(name = "age")
    private int age;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "mail")
    private String mail;


    public User(@NonNull String fname,
                @NonNull String lname,
                @NonNull int age,
                @NonNull String mail
                ) {this.fName = fname;
                    this.lName = lname;
                    this.age = age;
                    this.mail = mail;}

    public String getfName(){return this.fName;}
    public String getlName(){return this.lName;}
    public int getAge(){return this.age;}
    public String getMail(){return this.mail;}





}