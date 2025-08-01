package com.smartcart.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ListEntity.class, ItemEntity.class}, version = 1)
public abstract class SmartCartDatabase extends RoomDatabase {
    public abstract ListDao listDao();
    public abstract ItemDao itemDao();

    private static SmartCartDatabase INSTANCE;

    public static SmartCartDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                SmartCartDatabase.class, "smartcart_db")
                .fallbackToDestructiveMigration()
                .build();
        }
        return INSTANCE;
    }
}