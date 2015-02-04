package fr.eseo.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LevelActivity extends FragmentActivity {

    private int levelId;
    private int questionId;
    private String question_string;
    private  ArrayList<Response> responses ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        levelId =0;
        questionId=0;
        Intent intent = getIntent();
        levelId =intent.getIntExtra("level_Id", 0);
        questionId=intent.getIntExtra("question_Id", 0);

        QuestionRepo qrepo = new QuestionRepo(this);
        Question question= qrepo.getQuestionById(questionId);

        TextView questionSentence = (TextView) findViewById(R.id.question);
        questionSentence.setText(question.getSentence());
        question_string=question.getSentence();

        ResponseRepo rrepo = new ResponseRepo(LevelActivity.this);
        responses =rrepo.getResponseByQuestion(questionId);
        int i=0,arraySize=responses.size(),idResponse,idRate;
        if(arraySize !=0) {
            do {
                if (responses.get(i).isFound())
                {
                    idResponse = getResources().getIdentifier("view_response"+i, "id", "fr.eseo.firstproject");
                    idRate = getResources().getIdentifier("ratingBar_response"+i, "id", "fr.eseo.firstproject");
                    TextView responseWord = (TextView) findViewById(idResponse);
                    RatingBar rate = (RatingBar) findViewById(idRate);
                    rate.setRating(1);
                    responseWord.setText(responses.get(i).getWord());
                }
                i++;
            }while ( i!=arraySize );
        }else{
            Toast.makeText(this, "No Responses in this question !", Toast.LENGTH_SHORT).show();
        }

        //On écoute les actions
        final EditText editText = (EditText) findViewById(R.id.userResponse);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //Si l'utilisateur appuie sur entrée pour envoyer sa réponse
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    String userResponse = v.getText().toString();   //La réponse de l'utilisateur

                    ResponseRepo rrepo = new ResponseRepo(LevelActivity.this);

                    int arraySize=responses.size(),i=0,idResponse,idRate;
                    boolean trouve=false;
                    do {
                        if (userResponse.trim().equalsIgnoreCase(responses.get(i).getWord()))   //Si la réponse est correcte...
                        {
                            idResponse = getResources().getIdentifier("view_response"+i, "id", "fr.eseo.firstproject");
                            idRate = getResources().getIdentifier("ratingBar_response"+i, "id", "fr.eseo.firstproject");

                            TextView responseWord = (TextView) findViewById(idResponse);
                            RatingBar rate = (RatingBar) findViewById(idRate);

                            responseWord.setText(responses.get(i).getWord());   //On écrit la réponse...
                            rate.setRating(1);  //Et on coche l'étoile correspondante

                            responses.get(i).setFound(true);    //Dans la DB on indique que le mot a été trouvé
                            rrepo.update(responses.get(i));
                            trouve=true;

                            HorizontalScrollView scroll = (HorizontalScrollView) findViewById(R.id.scrollView);
                            scroll.fullScroll(View.FOCUS_RIGHT);
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

    public void getHint (View view)
    {
        ResponseRepo rrepo = new ResponseRepo(LevelActivity.this);
        Response response = rrepo.getNotFoundResponse(questionId);
        //Encore des mots à trouver ?
        if(response!=null)
        {
            Intent intent = new Intent(this, HintActivity.class);

            String response_word = response.getWord();
            int response_id = response.getResponse_ID();

            intent.putExtra("responseToFind_Id", response_id);  //Id de la réponse dont on veut l'indice
            intent.putExtra("responseToFind", response_word);   //Mot dont on veut l'indice
            intent.putExtra("question", question_string);   //La question
            intent.putExtra("level_Id", levelId);   //Id du niveau
            intent.putExtra("question_Id", questionId); //Id de la question
            startActivity(intent);
        }
        else
        {
            Toast.makeText(LevelActivity.this, "Aucun mot à trouver", Toast.LENGTH_SHORT).show();
        }
    }

    public void getBack(View view)
    {
        Intent intent = new Intent(LevelActivity.this, QuestionActivity.class);
        intent.putExtra("level_Id", levelId);
        finish();
      //  startActivity(intent);
    }

}
