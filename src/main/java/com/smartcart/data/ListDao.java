package com.smartcart.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ListDao {
    @Insert
    void insertList(ListEntity list);

    @Update
    void updateList(ListEntity list);

    @Delete
    void deleteList(ListEntity list);

    @Query("SELECT * FROM lists ORDER BY creationDate DESC")
    LiveData<List<ListEntity>> getAllLists();
}