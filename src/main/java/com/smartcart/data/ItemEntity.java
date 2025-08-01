package com.smartcart.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")
public class ItemEntity {
    @PrimaryKey(autoGenerate = true)
    public int itemId;

    @NonNull
    public String name;
    public int quantity;
    public String unit;
    public boolean isChecked;
    public int listId; // Foreign key reference
}