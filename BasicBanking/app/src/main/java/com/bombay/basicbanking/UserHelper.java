package com.bombay.basicbanking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bombay.basicbanking.UserContract.UserEntry;

import java.util.StringJoiner;

public class UserHelper  extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /* DATABASE NAME */
    private static final String DATABASE_NAME ="users.db";

    /*  DATABASE VERSION*/
    private static final String DATABASE_VERSION = "1";

    /* Create Constructor for class  */
    public UserHelper (Context context){
        super(context, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
    }

    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1234,'Brijesh Patel', 'brijesh@gmail.com','bank0076','8653754321', 14000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5678,'Sunil Yadav', 'sunil43@gmail.com','bank0754','7654462465', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1235,'Divakar Prajapati', 'divakar24@gmail.com','bank0646','9868696535', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8643,'Tanmay Patel', 'tanmay@gmail.com','bank0056','7845127512', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7435,'Shanvi Joshi', 'shanvi@gmail.com','bank0096','1346798525', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7432,'Piyush Bharmal', 'bharmal@gmail.com','bank0043','2255887744', 9300)");
        db.execSQL("insert into " + TABLE_NAME + " values(6356,'Rizvan Shaikh', 'rizvan@gmail.com','bank0756','9944562532', 4600)");
        db.execSQL("insert into " + TABLE_NAME + " values(5356,'Sonu Rajbhar', 'soun@gmail.com','bank4552','8842512451', 92003)");
        db.execSQL("insert into " + TABLE_NAME + " values(8434,'Rajesh Sharma', 'rajesh@gmail.com','bank0746','9858653258', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7788,'Nitesh Verma', 'nitesh@gmail.com','bank2276','8745263521', 3200)");
        db.execSQL("insert into " + TABLE_NAME + " values(2233,'Rahul Bole', 'rahul@gmail.com','bank3076','7854215968', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(8744,'Dimple Wines', 'dimple@gmail.com','bank4076','9685743225', 11440)");
        db.execSQL("insert into " + TABLE_NAME + " values(1452,'Mayuri Hajare', 'mayuri@gmail.com','bank5076','6985744857', 5790)");
        db.execSQL("insert into " + TABLE_NAME + " values(6242,'Kavita Shetty', 'kavita@gmail.com','bank0546','8754268574', 3240)");
        db.execSQL("insert into " + TABLE_NAME + " values(5735,'Vicky Jhadav', 'vicky@gmail.com','bank0636','9858568547', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}