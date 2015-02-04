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


    private int response_ID;
    private String word;
    private int question;
    private boolean found;

    public int getResponse_ID() {
        return response_ID;
    }

    public void setResponse_ID(int response_ID) {
        this.response_ID = response_ID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
