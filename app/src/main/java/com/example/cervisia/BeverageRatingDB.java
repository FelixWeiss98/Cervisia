package com.example.cervisia;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BeverageRating.class}, version = 1)
public abstract class BeverageRatingDB extends RoomDatabase {
    public abstract BeverageRatingDAO beverageRatingDAO();

    private static BeverageRatingDB INSTANCE;

    public static BeverageRatingDB getDatabaseInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BeverageRatingDB.class, "rating-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
