package com.example.yararalilaneclosure;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ButtonDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "button_db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "button_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_SECOND_NAME = "second_name";

    public ButtonDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_SECOND_NAME + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(dropTableQuery);
        onCreate(db);
    }

    public void insertButtonNames(String firstName, String secondName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, firstName);
        values.put(COLUMN_SECOND_NAME, secondName);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Pair<String, String>> getButtonNames() {
        List<Pair<String, String>> buttonNamesList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME));
                @SuppressLint("Range") String secondName = cursor.getString(cursor.getColumnIndex(COLUMN_SECOND_NAME));
                Pair<String, String> buttonNames = new Pair<>(firstName, secondName);
                buttonNamesList.add(buttonNames);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return buttonNamesList;
    }
    public void deleteButtonNames(String firstName, String secondName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause;
        String[] whereArgs;

        if (firstName != null && secondName != null) {
            // Delete based on both firstName and secondName
            whereClause = COLUMN_FIRST_NAME + "=? AND " + COLUMN_SECOND_NAME + "=?";
            whereArgs = new String[]{firstName, secondName};
        } else if (firstName != null) {
            // Delete based on firstName only
            whereClause = COLUMN_FIRST_NAME + "=?";
            whereArgs = new String[]{firstName};
        } else if (secondName != null) {
            // Delete based on secondName only
            whereClause = COLUMN_SECOND_NAME + "=?";
            whereArgs = new String[]{secondName};
        } else {
            // No criteria provided, return without deleting
            return;
        }

        db.delete(TABLE_NAME, whereClause, whereArgs);
        db.close();
    }

}
