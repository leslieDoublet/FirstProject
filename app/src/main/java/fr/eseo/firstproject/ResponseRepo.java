package fr.eseo.firstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sirt on 03/02/2015.
 */
public class ResponseRepo {
    private DataBaseHelper dbHelper;

    public ResponseRepo(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    public int insert(Response response) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Response.KEY_found, response.found);
        values.put(Response.KEY_word, response.word);
        values.put(Response.KEY_question, response.question);

        // Inserting Row
        long response_Id = db.insert(Response.TABLE, null, values);
        db.close();
        return (int) response_Id;
    }

    public void delete(int response_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Response.TABLE, Response.KEY_ID + "= ?", new String[] { String.valueOf(response_Id) });
        db.close();
    }

    public void update(Response response) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Response.KEY_found, response.found);
        values.put(Response.KEY_word, response.word);
        values.put(Response.KEY_question, response.question);

        db.update(Response.TABLE, values, Response.KEY_ID + "= ?", new String[] { String.valueOf(response.response_ID) });
        db.close();
    }
    public Response getResponseById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Response.KEY_ID + "," +
                Response.KEY_word +
                Response.KEY_found +
                " FROM " + Response.TABLE
                + " WHERE " +
                Response.KEY_ID + "=?";

        int iCount =0;
        Response response = new Response();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                response.response_ID =cursor.getInt(cursor.getColumnIndex(Response.KEY_ID));
                response.word =cursor.getString(cursor.getColumnIndex(Response.KEY_word));
                response.question =cursor.getInt(cursor.getColumnIndex(Response.KEY_question));
             //   response.found =cursor.getInt(cursor.getColumnIndex(Response.KEY_found));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return response;
    }
    public Response getResponseByQuestion(int questionId){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Response.KEY_ID + "," +
                Response.KEY_word +
                Response.KEY_found +
                " FROM " + Response.TABLE
                + " WHERE " +
                Response.KEY_question + "=?";

        int iCount =0;
        Response response = new Response();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(questionId) } );

        if (cursor.moveToFirst()) {
            do {
                response.response_ID =cursor.getInt(cursor.getColumnIndex(Response.KEY_ID));
                response.word =cursor.getString(cursor.getColumnIndex(Response.KEY_word));
                response.question =cursor.getInt(cursor.getColumnIndex(Response.KEY_question));
                //   response.found =cursor.getInt(cursor.getColumnIndex(Response.KEY_found));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return response;
    }
}
