package fr.eseo.firstproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 13;

        // Database Name
        private static final String DATABASE_NAME = "crud.db";

        public DataBaseHelper(Context context ) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String CREATE_TABLE_LEVEL = "CREATE TABLE " + Level.TABLE  + "("
                    + Level.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + Level.KEY_number + " INTEGER ) ";
            db.execSQL(CREATE_TABLE_LEVEL);

            String CREATE_TABLE_QUESTION = "CREATE TABLE " + Question.TABLE  + "("
                    + Question.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + Question.KEY_sentence + " TEXT ,"
                    + Question.KEY_level  + " INTEGER NOT NULL , FOREIGN KEY ("
                    + Question.KEY_level+") REFERENCES "
                    + Level.TABLE+"("+Level.KEY_ID +")) ";
            db.execSQL(CREATE_TABLE_QUESTION);

            String CREATE_TABLE_RESPONSE = "CREATE TABLE " + Response.TABLE  + "("
                    + Response.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + Response.KEY_word + " TEXT ,"
                    + Response.KEY_found + " INTEGER ,"
                    + Response.KEY_question  + " INTEGER NOT NULL , FOREIGN KEY ("
                    + Response.KEY_question+") REFERENCES "
                    + Question.TABLE+"("+Question.KEY_ID +")) ";
            db.execSQL(CREATE_TABLE_RESPONSE);


            String INSERT_TABLE_LEVEL;
            //insert level
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(1) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(2) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(3) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(4) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(5) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(6) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(7) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(8) ";
            db.execSQL(INSERT_TABLE_LEVEL);
            INSERT_TABLE_LEVEL = "INSERT INTO " + Level.TABLE  + " ("+Level.KEY_number+") VALUES(9) ";
            db.execSQL(INSERT_TABLE_LEVEL);

            //insert question
            String INSERT_TABLE_QUESTION;
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Arbre',1) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Ocean',2) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Choses que l on trouve dans une trousse',3) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Cirque',2) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Outil de bricolage',1) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Métier dangereux',1) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Espèce de reptile',2) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('GPS',3) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Créature imaginaire',3) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Excuse pour justifier son retard',4) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Ce que l on trouve dans le refrigerateur',4) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            INSERT_TABLE_QUESTION = "INSERT INTO " + Question.TABLE  + " ("+Question.KEY_sentence+","+Question.KEY_level+") VALUES('Sport sans balle ni ballon',4) ";
            db.execSQL(INSERT_TABLE_QUESTION);
            //insert response
            String INSERT_TABLE_RESPONSE;
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Tronc',0,1) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Branche',0,1) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Feuille',0,1) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Eau',0,2) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Poisson',0,2) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Bateau',0,2) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Gomme',0,3) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Ciseaux',0,3) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Stylo',0,3) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Pompier',0,6) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Policier',0,6) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Militaire',0,6) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Pelle',0,5) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Rateau',0,5) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Scie',0,5) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Chapiteau',0,4) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Clown',0,4) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Animaux',0,4) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Serpent',0,7) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Tortue',0,7) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Iguane',0,7) ";
            db.execSQL(INSERT_TABLE_RESPONSE);

            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Itineraire',0,8) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Voiture',0,8) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Carte',0,8) ";
            db.execSQL(INSERT_TABLE_RESPONSE);

            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Dragon',0,9) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Licorne',0,9) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Sorcière',0,9) ";
            db.execSQL(INSERT_TABLE_RESPONSE);

            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Embouteillage',0,10) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Panne',0,10) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Réveil',0,10) ";
            db.execSQL(INSERT_TABLE_RESPONSE);

            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Fromage',0,11) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Boisson',0,11) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Légumes',0,11) ";
            db.execSQL(INSERT_TABLE_RESPONSE);

            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Gymnastique',0,12) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Natation',0,12) ";
            db.execSQL(INSERT_TABLE_RESPONSE);
            INSERT_TABLE_RESPONSE = "INSERT INTO " + Response.TABLE  + " ("+Response.KEY_word+","+Response.KEY_found+","+Response.KEY_question+") VALUES('Athlétisme',0,12) ";
            db.execSQL(INSERT_TABLE_RESPONSE);





        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed, all data will be gone!!!
            db.execSQL("DROP TABLE IF EXISTS " + Level.TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + Question.TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + Response.TABLE);

            // Create tables again
            onCreate(db);

        }
    }
