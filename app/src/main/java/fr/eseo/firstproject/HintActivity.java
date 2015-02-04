package fr.eseo.firstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by etudiant on 03/02/2015.
 */
public class HintActivity extends Activity {

    private int levelId;
    private String response_word;
    private Response response;
    private int questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        Intent intent = getIntent();
        String question = intent.getStringExtra("question");
        response_word = intent.getStringExtra("responseToFind");
        int response_ID = intent.getIntExtra("responseToFind_Id", 0);
        levelId = intent.getIntExtra("level_Id", 0);
        questionId = intent.getIntExtra("question_Id", 0);

        //Affiche la question
        TextView questionSentence = (TextView) findViewById(R.id.hint_question);
        questionSentence.setText(question);

        //Affiche l'indice sous forme " A _ _ _ _ "
        TextView hintResponse = (TextView) findViewById(R.id.hint_response);
        int length = response_word.length()*2-1;
        char[] tab = new char[length];
        tab[0] = response_word.charAt(0);
        for(int i=1; i<length; i++)
        {
            tab[i]=' ';
            i++;
            tab[i]='_';
        }
        hintResponse.setText(String.valueOf(tab));

        //Récupère la réponse de type Response correspondant au mot cherché
        ResponseRepo rrepo = new ResponseRepo(HintActivity.this);
        response = rrepo.getResponseById(response_ID);

        //On écoute les actions
        final EditText editText = (EditText) findViewById(R.id.hint_userResponse);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //Si l'utilisateur appuie sur entrée pour envoyer sa réponse
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    String hint_userResponse = v.getText().toString();  //La réponse de l'utilisateur

                    TextView responseWord = (TextView) findViewById(R.id.hint_response);

                    boolean trouve=false;
                    if (hint_userResponse.trim().equalsIgnoreCase(response_word))   //Si la réponse est correcte...
                    {
                        responseWord.setText(response_word);    //On écrit la réponse

                        if (hint_userResponse.trim().equalsIgnoreCase(response_word))
                        {
                            responseWord.setText(response_word);
                            trouve=true;
                            Intent LevelIntent = new Intent(HintActivity.this, QuestionActivity.class);
                            LevelIntent.putExtra("level_Id", levelId);
                            startActivity(LevelIntent);
                        }
                        trouve=true;
                        ResponseRepo rrepo = new ResponseRepo(HintActivity.this);
                        response.setFound(true);        //Dans la DB on indique que le mot a été trouvé
                        rrepo.update(response);

                        //On retourne à l'activité précédente
                        Intent LevelIntent = new Intent(HintActivity.this, LevelActivity.class);
                        LevelIntent.putExtra("level_Id", levelId);
                        LevelIntent.putExtra("question_Id", questionId); //Id de la question
                        startActivity(LevelIntent);
                    }
                    editText.setText(null);
                    return true;
                }
                return false;
            }
        });
    }

    public void getBack(View view)
    {
        finish();

       /* Intent intent = new Intent(HintActivity.this, LevelActivity.class);
        intent.putExtra("level_Id", levelId);   //Id du niveau
        intent.putExtra("question_Id", questionId); //Id de la question
         startActivity(intent);
        */
    }
}
