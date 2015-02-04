package fr.eseo.firstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by etudiant on 03/02/2015.
 */
public class HintActivity extends Activity {

    private int levelId;
    private ArrayList<String> responses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        Intent intent = getIntent();
        int question_ID = intent.getIntExtra("id", -1);
        String question = intent.getStringExtra("question");
        responses = intent.getStringArrayListExtra("reponses_word");
        levelId = intent.getIntExtra("level_Id", 0);

        TextView questionSentence = (TextView) findViewById(R.id.hint_question);
        questionSentence.setText(question);

        final EditText editText = (EditText) findViewById(R.id.hint_userResponse);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String hint_userResponse = v.getText().toString();

                    TextView responseWord = (TextView) findViewById(R.id.hint_response);

                    int arraySize=responses.size(),i=0;
                    boolean trouve=false;
                    do {

                        if (hint_userResponse.trim().equalsIgnoreCase(responses.get(i)))
                        {
                            responseWord.setText(responses.get(i));
                            trouve=true;
                            Intent LevelIntent = new Intent(HintActivity.this, QuestionActivity.class);
                            LevelIntent.putExtra("level_Id", levelId);
                            startActivity(LevelIntent);
                        }
                        i++;
                    }while (!trouve && i!=arraySize );
                    editText.setText(null);
                    return true;
                }
                return false;
            }
        });
    }
}
