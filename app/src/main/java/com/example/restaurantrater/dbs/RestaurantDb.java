package com.example.restaurantrater.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RestaurantDb extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "restaurants.db";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS restaurants (" +
            "restaurantid integer primary key autoincrement, " +
            "name text not null, " +
            "city text not null, " +
            "address text not null, " +
            "state text not null, " +
            "zipcode integer not null);";


    public RestaurantDb(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS restaurants");
        onCreate(sqLiteDatabase);
    }
}
