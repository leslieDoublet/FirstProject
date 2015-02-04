package fr.eseo.firstproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by etudiant on 03/02/2015.
 */
public class Question2_frag extends Fragment {

    private String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question2_frag, container, false);
        Button question = (Button) view.findViewById(R.id.question2);
        question.setText(text);
        return view;
    }

    public void setButtonText(String text)
    {
        this.text = text;
    }
}
