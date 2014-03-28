package com.gmail.gonzaloantonio.examples.shakespeareplays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class FragmentDialogues extends Fragment {
    //Singleton NOT WORK MUST BE REPLACED BY FACTORY PATTERN
    public static FragmentDialogues getInstance (int index) {
        FragmentDialogues dialogues = new FragmentDialogues ();
        //demasiados objetos bundle...
        Bundle bundle = new Bundle();
        bundle.putInt ("index", index);

        dialogues.setArguments (bundle);
        return dialogues;
    }

    private int getDialogueIndex () {
        return getArguments().getInt ("index");
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //crear cada vez un textview es costoso en ram...
        TextView txtDialogues = new TextView (getActivity());
        int padding = (int) TypedValue.applyDimension (TypedValue.COMPLEX_UNIT_DIP, 4, new DisplayMetrics());
        txtDialogues.setTextSize (24);
        txtDialogues.setPadding (padding, padding, padding, padding);
        txtDialogues.setText (Shakespeare.Dialogue [getDialogueIndex ()]);

        ScrollView scroller = new ScrollView (getActivity ());
        scroller.addView (txtDialogues);

        return scroller;
    }
}
