package fr.eseo.firstproject;

/**
 * Created by sirt on 02/02/2015.
 */
public class Level {
    public static final String TABLE = "Level";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_number = "number";


    private int level_ID;
    private int number;

    public int getLevel_ID() {
        return level_ID;
    }

    public void setLevel_ID(int level_ID) {
        this.level_ID = level_ID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
