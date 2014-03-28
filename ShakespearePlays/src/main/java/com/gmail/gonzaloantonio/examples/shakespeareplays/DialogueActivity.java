package com.gmail.gonzaloantonio.examples.shakespeareplays;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DialogueActivity extends FragmentActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dialogue);

        int index = getIntent().getIntExtra ("DIALOGUE", 0);

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction ();
        FragmentDialogues frgDialogues = FragmentDialogues.getInstance (index);
        trans.add (R.id.dialoguesContent, frgDialogues);
        trans.commit ();
    }

}
