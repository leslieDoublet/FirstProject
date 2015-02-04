package fr.eseo.firstproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sirt on 04/02/2015.
 */
public class QuestionActivity extends Activity {

    ArrayList<Question> questions;
    TextView questionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        int levelId=0;
        Intent intent = getIntent();
        levelId =intent.getIntExtra("level_Id", 0);

        QuestionRepo qrepo = new QuestionRepo(this);
        questions= qrepo.getQuestionByLevel(levelId);

        View.OnClickListener cl= new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int levelId=questions.get(0).getLevel();
                int questionId = findViewById(R.id.question0).getId();
                Intent objIndent = new Intent(getApplicationContext(),LevelActivity.class);
                objIndent.putExtra("level_Id", levelId);
                objIndent.putExtra("question_Id", questionId);
                startActivity(objIndent);
            }
        };

        int i=0,arraySize=questions.size(),idQuestion;
        do {
            idQuestion = getResources().getIdentifier("question"+i, "id", "fr.eseo.firstproject");
            Button question = (Button) findViewById(idQuestion);
            question.setText(questions.get(i).getSentence());
          //  question.setOnClickListener(cl);
            i++;
        }while ( i!=arraySize );


    }
    public void onClick0(View v) {
        int levelId=questions.get(0).getLevel();
        int questionId = questions.get(0).getQuestion_ID();
        Intent objIndent = new Intent(getApplicationContext(),LevelActivity.class);
        objIndent.putExtra("level_Id", levelId);
        objIndent.putExtra("question_Id", questionId);
        startActivity(objIndent);
    }
    public void onClick1(View v) {

        int levelId=questions.get(1).getLevel();
        int questionId = questions.get(1).getQuestion_ID();
        Intent objIndent = new Intent(getApplicationContext(),LevelActivity.class);
        objIndent.putExtra("level_Id", levelId);
        objIndent.putExtra("question_Id", questionId);
        startActivity(objIndent);
    }
    public void onClick2(View v) {
        int levelId=questions.get(2).getLevel();
        int questionId = questions.get(2).getQuestion_ID();
        Intent objIndent = new Intent(getApplicationContext(),LevelActivity.class);
        objIndent.putExtra("level_Id", levelId);
        objIndent.putExtra("question_Id", questionId);
        startActivity(objIndent);
    }
}
/* à échanger avec LevelActivity

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionActivity extends Activity {
    private int levelId;
    private int questionId;
    private String question_string;
    private ArrayList<Response> responses ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        levelId =0;
        Intent intent = getIntent();
        levelId =intent.getIntExtra("level_Id", 0);
        QuestionRepo qrepo = new QuestionRepo(this);
        Question question= qrepo.getQuestionByLevel(levelId);

        TextView questionSentence = (TextView) findViewById(R.id.question);
        questionSentence.setText(question.getSentence());
        questionId=question.getQuestion_ID();
        question_string=question.getSentence();

        ResponseRepo rrepo = new ResponseRepo(QuestionActivity.this);
        responses =rrepo.getResponseByQuestion(questionId);
        int i=0,arraySize=responses.size(),idResponse,idRate;

        do {

            if (responses.get(i).isFound())
            {
                idResponse = getResources().getIdentifier("view_response"+i, "id", "fr.eseo.firstproject");
                idRate = getResources().getIdentifier("ratingBar_response"+i, "id", "fr.eseo.firstproject");
                TextView responseWord = (TextView) findViewById(idResponse);
                RatingBar rate = (RatingBar) findViewById(idRate);
                rate.setRating(1);
                responseWord.setText(responses.get(i).getWord());            }
            i++;
        }while ( i!=arraySize );



        final EditText editText = (EditText) findViewById(R.id.userResponse);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String userResponse = v.getText().toString();



                    ResponseRepo rrepo = new ResponseRepo(QuestionActivity.this);

                    int arraySize=responses.size(),i=0,idResponse,idRate;
                    boolean trouve=false;
                    do {

                        if (userResponse.trim().equalsIgnoreCase(responses.get(i).getWord()))
                        {
                            idResponse = getResources().getIdentifier("view_response"+i, "id", "fr.eseo.firstproject");
                            idRate = getResources().getIdentifier("ratingBar_response"+i, "id", "fr.eseo.firstproject");
                            TextView responseWord = (TextView) findViewById(idResponse);
                            RatingBar rate = (RatingBar) findViewById(idRate);

                            rate.setRating(1);
                            responseWord.setText(responses.get(i).getWord());
                            responses.get(i).setFound(true);
                            rrepo.update(responses.get(i));
                            trouve=true;
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
        Intent intent = new Intent(this,HintActivity.class);

        ArrayList<String> responses_word = new ArrayList<String>();
        for(int i=0; i<responses.size(); i++)
            responses_word.add(responses.get(i).getWord());

        intent.putExtra("reponses_word", responses_word );
        intent.putExtra("question", question_string );
        intent.putExtra("id", questionId);
        intent.putExtra("level_Id", levelId);
        startActivity(intent);
    }

}
*/