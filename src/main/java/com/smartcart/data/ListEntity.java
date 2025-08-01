package com.smartcart.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lists")
public class ListEntity {
    @PrimaryKey(autoGenerate = true)
    public int listId;

    @NonNull
    public String title;

    public boolean isShared;
    public String priorityLevel;
    public String creationDate;
}