package fr.eseo.firstproject;

/**
 * Created by sirt on 02/02/2015.
 */
public class Question {
    public static final String TABLE = "Question";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_sentence = "sentence";
    public static final String KEY_level = "level";


    private int question_ID;
    private String sentence;
    private int level;

    public int getQuestion_ID() {
        return question_ID;
    }

    public void setQuestion_ID(int question_ID) {
        this.question_ID = question_ID;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
