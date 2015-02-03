package fr.eseo.firstproject;

/**
 * Created by sirt on 02/02/2015.
 */
public class Response {
    public static final String TABLE = "Response";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_word = "word";
    public static final String KEY_question = "question";
    public static final String KEY_found = "found";


    public int response_ID;
    public String word;
    public int question;
    public boolean found;

}
