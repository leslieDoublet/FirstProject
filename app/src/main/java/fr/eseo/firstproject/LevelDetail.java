package fr.eseo.firstproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
/**
 * Created by sirt on 03/02/2015.
 */
public class LevelDetail  extends ActionBarActivity  {


    TextView textNumber;
    private int _Level_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        textNumber = (TextView) findViewById(R.id.textQuestion);


        _Level_Id =0;
        Intent intent = getIntent();
        _Level_Id =intent.getIntExtra("level_Id", 0);
        LevelRepo repo = new LevelRepo(this);
        Level level = new Level();
        level = repo.getLevelById(_Level_Id);

        textNumber.setText(String.valueOf(level.number));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
