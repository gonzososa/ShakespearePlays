package com.gmail.gonzaloantonio.examples.shakespeareplays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements OnTitleSelected {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        FragmentTitles frgTitles =
                (FragmentTitles) getSupportFragmentManager().findFragmentById (R.id.frgTitles);

        if (frgTitles != null) {
            frgTitles.setOnTitleSelected (this);
        }

        /*if (getView != null) {
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction ();
            FragmentDialogues dialogues = FragmentDialogues.getInstance (0); //replace for index in Bundle
            trans.replace (R.id.dummyContent, dialogues);
            trans.commit ();
        }*/
    }

    public void showDialogue(int index) {
        if (findViewById (R.id.dummyContent) != null) {
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction ();
            FragmentDialogues dialogues = FragmentDialogues.getInstance (index);
            trans.replace (R.id.dummyContent, dialogues);
            trans.setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            trans.commit ();
        }
        else {
            Intent intent = new Intent (this, DialogueActivity.class);
            intent.putExtra ("DIALOGUE", index);
            startActivity (intent);
        }
    }
}
