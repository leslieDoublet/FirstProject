package fr.eseo.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by sirt on 04/02/2015.
 */
public class QuestionActivity extends FragmentActivity {

    private ArrayList<Question> questions;
    private TextView questionId;

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //SWIPE ************
        // Création de la liste de Fragments que fera défiler le PagerAdapter
        List<Fragment> fragments = new Vector<>();

        // Ajout des Fragments dans la liste
        fragments.add(Fragment.instantiate(QuestionActivity.this, Question0_frag.class.getName()));
        //fragments.add(Fragment.instantiate(this, Response_frag.class.getName()));
        fragments.add(Fragment.instantiate(QuestionActivity.this, Question1_frag.class.getName()));
        fragments.add(Fragment.instantiate(QuestionActivity.this, Question2_frag.class.getName()));

        // Création de l'adapter qui s'occupera de l'affichage de la liste de Fragments
        this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager) super.findViewById(R.id.viewPager);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);
        //******************

        int levelId = 0;
        Intent intent = getIntent();
        levelId = intent.getIntExtra("level_Id", 0);

        QuestionRepo qrepo = new QuestionRepo(this);
        questions = qrepo.getQuestionByLevel(levelId);

        //int i=0,arraySize=questions.size(),idQuestion;
        //do {
        //idQuestion = getResources().getIdentifier("question"+i, "id", "fr.eseo.firstproject");
        //Button question = (Button) findViewById(idQuestion);
        //question.setText(questions.get(i).getSentence());
        ((Question0_frag) fragments.get(0)).setButtonText(questions.get(0).getSentence());
        ((Question1_frag) fragments.get(1)).setButtonText(questions.get(1).getSentence());
        ((Question2_frag) fragments.get(2)).setButtonText(questions.get(2).getSentence());

        // i++;
        // }while ( i!=arraySize );
    }


    public void onClick(View v) {
        int questionId=0;
        int levelId=questions.get(0).getLevel();
        if (v.getId()==R.id.question0) {
            questionId = questions.get(0).getQuestion_ID();
        }else if(v.getId()==R.id.question1){
            questionId = questions.get(1).getQuestion_ID();
        }else if(v.getId()==R.id.question2){
            questionId = questions.get(2).getQuestion_ID();
        }
        Intent objIndent = new Intent(getApplicationContext(),LevelActivity.class);
        objIndent.putExtra("level_Id", levelId);
        objIndent.putExtra("question_Id", questionId);
        startActivity(objIndent);
    }

    /*public void onClick0(View v) {
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
    }*/

    public void getBack(View view)
    {
        Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}