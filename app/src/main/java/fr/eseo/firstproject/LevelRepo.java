package fr.eseo.firstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sirt on 03/02/2015.
 */
public class LevelRepo {
    private DataBaseHelper dbHelper;

    public LevelRepo(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    public int insert(Level level) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Level.KEY_number, level.getNumber());

        // Inserting Row
        long level_Id = db.insert(Level.TABLE, null, values);
        db.close();
        return (int) level_Id;
    }

    public void delete(int level_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Level.TABLE, Level.KEY_ID + "= ?", new String[] { String.valueOf(level_Id) });
        db.close();
    }

    public void update(Level level) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Level.KEY_number, level.getNumber());

        db.update(Level.TABLE, values, Level.KEY_ID + "= ?", new String[] { String.valueOf(level.getLevel_ID()) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getLevelList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Level.KEY_ID + "," +
                Level.KEY_number +
                " FROM " + Level.TABLE;


        ArrayList<HashMap<String, String>> levelList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> level = new HashMap<String, String>();
                level.put("id", cursor.getString(cursor.getColumnIndex(Level.KEY_ID)));
                level.put("number", cursor.getString(cursor.getColumnIndex(Level.KEY_number)));
                levelList.add(level);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return levelList;

    }

    public Level getLevelById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Level.KEY_ID + "," +
                Level.KEY_number +
                " FROM " + Level.TABLE
                + " WHERE " +
                Level.KEY_ID + "=?";

        Level level = new Level();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                level.setLevel_ID(cursor.getInt(cursor.getColumnIndex(Level.KEY_ID))) ;
                level.setNumber(cursor.getInt(cursor.getColumnIndex(Level.KEY_number))) ;
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return level;
    }
}
