package fr.eseo.firstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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
        values.put(Response.KEY_found, response.isFound()== true ? 1 : 0);
        values.put(Response.KEY_word, response.getWord());
        values.put(Response.KEY_question, response.getQuestion());

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
        values.put(Response.KEY_found, response.isFound()== true ? 1 : 0);
        values.put(Response.KEY_word, response.getWord());
        values.put(Response.KEY_question, response.getQuestion());

        db.update(Response.TABLE, values, Response.KEY_ID + "= ?", new String[] { String.valueOf(response.getResponse_ID()) });
        db.close();
    }
    public Response getResponseById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Response.KEY_ID + "," +
                Response.KEY_word  + "," +
                Response.KEY_question +","+
                Response.KEY_found +
                " FROM " + Response.TABLE
                + " WHERE " +
                Response.KEY_ID + "=?";

        Response response = new Response();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                response.setResponse_ID(cursor.getInt(cursor.getColumnIndex(Response.KEY_ID)));
                response.setWord(cursor.getString(cursor.getColumnIndex(Response.KEY_word)));
                response.setQuestion(cursor.getInt(cursor.getColumnIndex(Response.KEY_question)));
                response.setFound(cursor.getInt(cursor.getColumnIndex(Response.KEY_found))== 1 ? true : false);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return response;
    }
    public ArrayList<Response> getResponseByQuestion(int questionId){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Response> responses= new ArrayList<Response>();
        String selectQuery =  "SELECT  " +
                Response.KEY_ID + "," +
                Response.KEY_word +","+
                Response.KEY_question +","+
                Response.KEY_found +
                " FROM " + Response.TABLE
                + " WHERE " +
                Response.KEY_question + "=?";


        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(questionId) } );

        if (cursor.moveToFirst()) {
            do {
                Response response = new Response();
                response.setResponse_ID(cursor.getInt(cursor.getColumnIndex(Response.KEY_ID)));
                response.setWord(cursor.getString(cursor.getColumnIndex(Response.KEY_word)));
                response.setQuestion(cursor.getInt(cursor.getColumnIndex(Response.KEY_question)));
                response.setFound(cursor.getInt(cursor.getColumnIndex(Response.KEY_found))== 1 ? true : false);
                responses.add(response);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return responses;
    }

    public Response getNotFoundResponse(int questionId){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " + Response.KEY_word + "," + Response.KEY_ID +
                                " FROM " + Response.TABLE +
                                " WHERE " + Response.KEY_found + "=0 " +
                                " AND " + Response.KEY_question + "=?";

        Response response = new Response();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(questionId) } );

        if (cursor.moveToFirst()) {
                response.setWord(cursor.getString(cursor.getColumnIndex(Response.KEY_word)));
                response.setResponse_ID(cursor.getInt(cursor.getColumnIndex(Response.KEY_ID)));
        }
        else{
            response=null;
        }

        cursor.close();
        db.close();
        return response;
    }
}
