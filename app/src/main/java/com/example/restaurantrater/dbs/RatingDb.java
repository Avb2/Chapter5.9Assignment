package com.example.restaurantrater.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RatingDb extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "restaurants.db";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ratings (" +
            "dishid integer primary key autoincrement, " +
            "name text not null, " +
            "type text not null, " +
            "rating integer not null, " +
            "restaurantid integer not null, " +
            "constraint fk_restaurantid foreign key (restaurantid) references restaurants(restaurantid));";

    public RatingDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ratings");
        onCreate(sqLiteDatabase);
    }
}
