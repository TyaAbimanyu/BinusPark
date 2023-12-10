package com.example.binuspark;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "BinusPark";
    private static final int DB_VERSION = 1;
    private static final String ID_COL = "id";
    private static final String TABLE_NAME = "user";
    private static final String NAME_COL = "name";
    private static final String EMAIL_COL = "email";
    private static final String PASS_COL = "password";
    private static final String PHONENUM_COL = "phonenumber";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  "
                + NAME_COL + " TEXT NOT NULL,"
                + EMAIL_COL + " TEXT NOT NULL,"
                + PASS_COL + " TEXT NOT NULL,"
                + PHONENUM_COL + " INT NOT NULL)";

        db.execSQL(query);

    }

    public void addNewUser(String name, String email, String password, int phonenum) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(EMAIL_COL, email);
        values.put(PASS_COL, password);
        values.put(PHONENUM_COL, phonenum);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<UserModel> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<UserModel> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new UserModel(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getInt(4)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

    public void updateCourse(String originalname , String name, String email, String password, int phonenum) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(EMAIL_COL, email);
        values.put(PASS_COL, password);
        values.put(PHONENUM_COL, phonenum);

        db.update(TABLE_NAME, values, "name=?", new String[]{originalname});
        db.close();
    }
    public void deleteCourse(String UserName) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "name=?", new String[]{UserName});
        db.close();
    }

    public UserModel authentication(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE email = " + email + " AND password = " + password, null);

        UserModel user;

        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                user = new UserModel(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getInt(4));
            } while (cursorCourses.moveToNext());
            return user;
        }
        cursorCourses.close();
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
