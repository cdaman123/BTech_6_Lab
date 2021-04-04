package com.aman.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

        // allowing the insert of the same word multiple times by passing a
        // conflict resolution strategy
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(User user);

        @Delete
        void delet(User user);

        @Update
        void update(User user);

        @Query("DELETE FROM user_table")
        void deleteAll();

        @Query("SELECT * FROM user_table ORDER BY age ASC")
        LiveData<User> getSortedAgeList();

        @Query("SELECT * FROM user_table ORDER BY fname ASC")
        LiveData<User> getSortedfNameList();

        @Query("SELECT * FROM user_table ORDER BY lname ASC")
        LiveData<User> getSortedlNameList();

}
