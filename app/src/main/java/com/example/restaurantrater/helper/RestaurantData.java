package com.example.restaurantrater.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurantrater.dbs.DbHelper;
import com.example.restaurantrater.models.RestaurantModel;

public class RestaurantData {
    private SQLiteDatabase db;
    private DbHelper restaurantDb;

    public RestaurantData(Context context) {
        this.restaurantDb = new DbHelper(context);
    }


    public void open() throws SQLException {
        this.db = this.restaurantDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }


    public void insertVals(RestaurantModel restaurantModel) throws SQLException {
        ContentValues vals = new ContentValues();

        vals.put("name", restaurantModel.getName());
        vals.put("city", restaurantModel.getCity());
        vals.put("state", restaurantModel.getState());
        vals.put("address", restaurantModel.getAddress());
        vals.put("zipcode", restaurantModel.getZipcode());

        try {
            this.db.insert("restaurants",null,  vals);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
