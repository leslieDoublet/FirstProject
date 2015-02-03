package fr.eseo.firstproject;

//import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Vector;

/**
 * Created by etudiant on 02/02/2015.
 */
public class LevelActivity extends FragmentActivity {

    Adapter adapter;
    ViewPager pager;
    private int levelId;

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

        //TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());


        final EditText editText = (EditText) findViewById(R.id.userResponse);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String userResponse = v.getText().toString();
                    //Toast.makeText(LevelActivity.this, response, Toast.LENGTH_SHORT).show();
                    RatingBar rate = (RatingBar) findViewById(R.id.ratingBar);
                    TextView response = (TextView) findViewById(R.id.response);
                    Intent intent = getIntent();
                    if (userResponse.trim().equalsIgnoreCase(intent.getStringExtra("response")))
                    {
                        rate.setRating(1);
                        response.setText(intent.getStringExtra("response"));
                    }
                    editText.setText(null);
                    return true;
                }
                return false;
            }
        });
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
