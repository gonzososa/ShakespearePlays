package com.gmail.gonzaloantonio.examples.shakespeareplays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentTitles extends Fragment {
    private ListView listado;
    private OnTitleSelected listener;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_titles, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);

        listado = (ListView) getView().findViewById (R.id.lstListado);

        listado.setAdapter (new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_list_item_1,
                            Shakespeare.Titles) {

            @Override
            public View getView (int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder;

                if (convertView == null) {
                    convertView = getActivity().
                                    getLayoutInflater().
                                    inflate (R.layout.listitem_title, null);

                    viewHolder = new ViewHolder ();
                    viewHolder.title = (TextView) convertView.findViewById (R.id.txtTitle);

                    convertView.setTag (viewHolder);
                }
                else {
                    viewHolder = (ViewHolder) convertView.getTag ();
                }

                if (Shakespeare.Titles [position] != null) {
                    viewHolder.title.setText (Shakespeare.Titles [position]);
                }

                return convertView;
            }

        });

        listado.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (listener != null) {
                    listener.showDialogue (i);
                }
            }
        });

    }

    public void setOnTitleSelected (OnTitleSelected listener) {
        this.listener = listener;
    }

    class ViewHolder { TextView title; }
}
