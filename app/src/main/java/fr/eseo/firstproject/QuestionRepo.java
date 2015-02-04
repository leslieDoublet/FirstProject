package fr.eseo.firstproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sirt on 03/02/2015.
 */
public class QuestionRepo {
    private DataBaseHelper dbHelper;

    public QuestionRepo(Context context) {
        dbHelper = new DataBaseHelper(context);
    }

    public int insert(Question question) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Question.KEY_level, question.getLevel());
        values.put(Question.KEY_sentence, question.getSentence());

        // Inserting Row
        long question_Id = db.insert(Question.TABLE, null, values);
        db.close();
        return (int) question_Id;
    }

    public void delete(int question_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Question.TABLE, Question.KEY_ID + "= ?", new String[] { String.valueOf(question_Id) });
        db.close();
    }

    public void update(Question question) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Question.KEY_level, question.getLevel());
        values.put(Question.KEY_sentence, question.getSentence());

        db.update(Question.TABLE, values, Question.KEY_ID + "= ?", new String[] { String.valueOf(question.getQuestion_ID()) });
        db.close();
    }
    public Question getQuestionById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Question.KEY_ID + "," +
                Question.KEY_sentence +
                " FROM " + Question.TABLE
                + " WHERE " +
                Question.KEY_ID + "=?";

        Question question = new Question();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                question.setQuestion_ID(cursor.getInt(cursor.getColumnIndex(Question.KEY_ID)));
                question.setSentence(cursor.getString(cursor.getColumnIndex(Question.KEY_sentence)));
                question.setLevel(cursor.getInt(cursor.getColumnIndex(Question.KEY_level)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return question;
    }
    public Question getQuestionByLevel(int levelId){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Question.KEY_ID + "," +
                Question.KEY_level + "," +
                Question.KEY_sentence +
                " FROM " + Question.TABLE
                + " WHERE " +
                Question.KEY_level + "=?";

        Question question = new Question();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(levelId) } );

        if (cursor.moveToFirst()) {
            do {
                question.setQuestion_ID(cursor.getInt(cursor.getColumnIndex(Question.KEY_ID)));
                question.setSentence(cursor.getString(cursor.getColumnIndex(Question.KEY_sentence)));
                question.setLevel(cursor.getInt(cursor.getColumnIndex(Question.KEY_level)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return question;
    }
}
