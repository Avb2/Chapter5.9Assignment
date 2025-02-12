package com.example.restaurantrater.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurantrater.dbs.RatingDb;
import com.example.restaurantrater.models.RatingModel;

public class RatingData {
    private SQLiteDatabase db;
    private RatingDb ratingDb;

    String restaurantName;
    String address;

    public RatingData(Context context, String restaurantName, String address){
        this.ratingDb = new RatingDb(context);
    }

    public void open() throws SQLException {
        this.db = this.ratingDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }


    public void insertVals(RatingModel ratingModel){
        ContentValues vals = new ContentValues();

        vals.put("name", ratingModel.getName());
        vals.put("type", ratingModel.getType());
        vals.put("rating", ratingModel.getRating());

        try {
            this.db.insert("ratings", null, vals);
        } catch (Exception e) {
        }
    }


    public void getFK(){
        this.db.execSQL("SELECT restaurantid FROM restaurants WHERE name = ? AND address = ?", new Object[] {this.restaurantName, this.address});
    }
}
