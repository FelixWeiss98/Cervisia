package com.example.cervisia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BeverageRatingDAO {
    @Query("SELECT * FROM beveragerating")
    List<BeverageRating> getAll();

    @Query("SELECT * FROM beveragerating WHERE beverage_name=:name ")
    List<BeverageRating> getRating(String name);

    @Insert
    void insertRating(BeverageRating... beverageRatings);

    @Delete
    void deleteRating(BeverageRating beverageRating);

    @Update
    void updateRating(BeverageRating... beverageRating);
}
