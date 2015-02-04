package fr.eseo.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by etudiant on 02/02/2015.
 */
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
        Intent intent = getIntent();
        levelId =intent.getIntExtra("level_Id", 0);
        QuestionRepo qrepo = new QuestionRepo(this);
        Question question= qrepo.getQuestionByLevel(levelId);

        TextView questionSentence = (TextView) findViewById(R.id.question);
        questionSentence.setText(question.sentence);

        questionId=question.question_ID;
        question_string=question.sentence;
        ResponseRepo rrepo = new ResponseRepo(LevelActivity.this);
        responses =rrepo.getResponseByQuestion(LevelActivity.this.questionId);


        final EditText editText = (EditText) findViewById(R.id.userResponse);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String userResponse = v.getText().toString();
                    RatingBar rate = (RatingBar) findViewById(R.id.ratingBar);

                    TextView responseWord = (TextView) findViewById(R.id.response);

                    int arraySize=responses.size(),i=0;
                    boolean trouve=false;
                    do {

                        if (userResponse.trim().equalsIgnoreCase(responses.get(i).word))
                        {
                            rate.setRating(1);
                            responseWord.setText(responses.get(i).word);
                            trouve=true;
                        }
                        i++;
                    }while (trouve==false && i!=arraySize );
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
            responses_word.add(responses.get(i).word);

        intent.putExtra("reponses_word", responses_word );
        intent.putExtra("question", question_string );
        intent.putExtra("id", questionId);
        intent.putExtra("level_Id", levelId);
        startActivity(intent);
    }

}
/*public class LevelActivity extends FragmentActivity {

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_level);

        // Création de la liste de Fragments que fera défiler le PagerAdapter
        List<Fragment> fragments = new Vector<Fragment>();

        // Ajout des Fragments dans la liste
        fragments.add(Fragment.instantiate(this, Question_frag.class.getName()));
        fragments.add(Fragment.instantiate(this, Response_frag.class.getName()));

        // Création de l'adapter qui s'occupera de l'affichage de la liste de Fragments
        this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager) super.findViewById(R.id.viewPager);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);
    }
}
*/
