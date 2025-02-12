package com.example.restaurantrater.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurantrater.dbs.DbHelper;
import com.example.restaurantrater.models.RatingModel;

public class RatingData {
    private SQLiteDatabase db;
    private DbHelper ratingDb;

    String restaurantName;
    String address;

    public RatingData(Context context, String restaurantName, String address){
        this.ratingDb = new DbHelper(context);
        this.restaurantName = restaurantName;
        this.address = address;
    }

    public void open() throws SQLException {
        this.db = this.ratingDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }


    public void insertVals(RatingModel ratingModel){
        int foreignKey = -1;
        try {
            foreignKey = getFK(this.restaurantName, this.address);
        } catch (Exception e) {}

        ContentValues vals = new ContentValues();

        vals.put("name", ratingModel.getName());
        vals.put("type", ratingModel.getType());
        vals.put("rating", ratingModel.getRating());
        vals.put("restaurantid", foreignKey);

        try {
            this.db.insert("ratings", null, vals);
        } catch (Exception e) {
        }
    }


    public int getFK(String restaurantName, String address) throws SQLException {
        int restaurantId = -1;

        Cursor cursor = this.db.rawQuery("SELECT restaurantid FROM restaurants WHERE name = ? AND address = ?",
                new String[]{restaurantName, address});

        if (cursor.moveToFirst()) {
            restaurantId = cursor.getInt(0);
        }

        cursor.close();

        System.out.println(restaurantId);
        return restaurantId;
    }
}
