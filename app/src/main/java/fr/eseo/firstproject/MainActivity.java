package fr.eseo.firstproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity{

    TextView level_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //affichage liste des niveaux
        LevelRepo repo = new LevelRepo(this);

        ArrayList<HashMap<String, String>> levelList =  repo.getLevelList();
        if(levelList.size()!=0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    level_Id = (TextView) view.findViewById(R.id.level_Id);
                    String levelId = level_Id.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(),LevelActivity.class);
                    objIndent.putExtra("level_Id", Integer.parseInt(levelId));
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter = new SimpleAdapter( MainActivity.this,levelList, R.layout.view_level_entry, new String[] { "id","number"}, new int[] {R.id.level_Id, R.id.level_number});
            setListAdapter(adapter);
        }else{
            Toast.makeText(this,"No level!",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick1(View view)
    {
        Intent intent = new Intent(this, LevelActivity.class);
        //  intent.putExtra("question", getString(R.string.question1));
        //  intent.putExtra("response", getString(R.string.reponse1));
        intent.putExtra("question", getString(R.string.question1));
        intent.putExtra("response", getString(R.string.reponse1));
        startActivity(intent);
    }

    public void onClick2(View view)
    {
        Intent intent = new Intent(this, LevelActivity.class);
        intent.putExtra("question", getString(R.string.question2));
        intent.putExtra("response", getString(R.string.reponse2));
        startActivity(intent);
        //Toast.makeText(this, "level 2", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
