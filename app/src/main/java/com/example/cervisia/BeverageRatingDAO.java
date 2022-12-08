package com.example.cervisia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BeverageRatingDAO {
    @Query("SELECT * FROM beveragerating")
    List<BeverageRating> getAll();

    @Insert
    void insertRating(BeverageRating... beverageRatings);

    @Delete
    void delete(BeverageRating beverageRating);
}
