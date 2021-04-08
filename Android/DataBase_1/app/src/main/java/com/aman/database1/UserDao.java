package com.aman.database1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Delete
    void delet(User user);

    @Query("SELECT * FROM user_table")
    List<User> getAll();

    @Query("SELECT * FROM user_table WHERE roll_no == :roll")
    User getUser(String roll);

    @Query("DELETE FROM user_table")
    void deleteAll();
}
