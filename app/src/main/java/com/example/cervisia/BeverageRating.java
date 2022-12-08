package com.example.cervisia;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class BeverageRating {

    //Attributes
    @PrimaryKey(autoGenerate = true)
    public int beverageID;

    @ColumnInfo(name = "beverage_name")
    public String beverageName;

    @ColumnInfo(name = "beverage_price")
    public String beveragePrice;
}
