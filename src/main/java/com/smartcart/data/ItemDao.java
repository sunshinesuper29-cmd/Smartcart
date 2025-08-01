package com.smartcart.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insertItem(ItemEntity item);

    @Update
    void updateItem(ItemEntity item);

    @Delete
    void deleteItem(ItemEntity item);

    @Query("SELECT * FROM items WHERE listId = :listId ORDER BY itemId ASC")
    LiveData<List<ItemEntity>> getItemsByList(int listId);
}