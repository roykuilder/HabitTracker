package com.example.android.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.myapplication.data.HabitContract.HabitEntry;
import com.example.android.myapplication.data.HabitDbHelper;

public class HabitTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker);

        insert();
    }

    public void insert() {

        // create a new habitDbHelper to communicate with the database
        HabitDbHelper dbHelper = new HabitDbHelper(this);

        // Create a new writable database object
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Dummy Data to insert into database using ContentValues class
        ContentValues habitContent = new ContentValues();
        habitContent.put(HabitEntry.COLUMN_DATE, 15);
        habitContent.put(HabitEntry.COLUMN_SETS, 3);
        habitContent.put(HabitEntry.COLUMN_NUMBER_PUSHUPS, 12);
        habitContent.put(HabitEntry.COLUMN_FEELING, "Haven't done this in a while so is was hard");

        // insert dummy data into database with content from the ContentValues Object
        long insertReturn = db.insert(HabitEntry.TABLE_NAME, null, habitContent);

        //and again...
        ContentValues habitContent2 = new ContentValues();
        habitContent2.put(HabitEntry.COLUMN_DATE, 1500029853);
        habitContent2.put(HabitEntry.COLUMN_SETS, 5);
        habitContent2.put(HabitEntry.COLUMN_NUMBER_PUSHUPS, 80);
        habitContent2.put(HabitEntry.COLUMN_FEELING, "wow so much progress i so little time");

        long insertReturn2 = db.insert(HabitEntry.TABLE_NAME, null, habitContent2);
    }

    public Cursor readHabitData() {
        // create a new habitDbHelper to communicate with the database
        HabitDbHelper dbHelper = new HabitDbHelper(this);

        // create a new readable database
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // this projection is used to return the requested columns
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_DATE,
                HabitEntry.COLUMN_SETS,
                HabitEntry.COLUMN_NUMBER_PUSHUPS,
                HabitEntry.COLUMN_FEELING
        };

        // return Cursor Object
        return db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);
    }
}
