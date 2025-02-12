package com.example.restaurantrater.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "restaurants.db";

    private static final String CREATE_RESTAURANTS_TABLE =
            "CREATE TABLE IF NOT EXISTS restaurants (" +
                    "restaurantid integer primary key autoincrement, " +
                    "name text not null, " +
                    "city text not null, " +
                    "address text not null, " +
                    "state text not null, " +
                    "zipcode integer not null);";

    private static final String CREATE_RATINGS_TABLE =
            "CREATE TABLE IF NOT EXISTS ratings (" +
                    "dishid integer primary key autoincrement, " +
                    "name text not null, " +
                    "type text not null, " +
                    "rating real not null, " +
                    "restaurantid integer not null, " +
                    "FOREIGN KEY (restaurantid) REFERENCES restaurants(restaurantid));";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RESTAURANTS_TABLE);
        db.execSQL(CREATE_RATINGS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ratings");
        db.execSQL("DROP TABLE IF EXISTS restaurants");
        onCreate(db);
    }
}