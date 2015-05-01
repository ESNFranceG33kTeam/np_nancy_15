package org.esn.geekteam.npnancy15.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.models.Award;

import java.util.ArrayList;

/**
 * Created by Spider on 30/04/15.
 */
public class AwardsFragment extends android.support.v4.app.ListFragment {
    private static final String TAG = AwardsFragment.class.getSimpleName();
    private ArrayList<Award> awards;
    private CustomListAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initAwards();

        // Set an Adapter to the ListView
        adapter = new CustomListAdapter(getActivity());
        this.setListAdapter(adapter);
    }

    public void initAwards(){
        awards = new ArrayList<Award>();
        awards.add(new Award("Beau gosse"));
        awards.add(new Award("Belle gosse"));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_awards, container, false);
    }

    class CustomListAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public CustomListAdapter(Activity activity) {

            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return awards.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Inflate the item layout and set the views
            View listItem = convertView;
            int pos = position;
            if (listItem == null) {
                listItem = layoutInflater.inflate(R.layout.list_awards, null);
            }

            // Initialize the views in the layout
            TextView tvName = (TextView) listItem.findViewById(R.id.name);

            tvName.setText(awards.get(pos).getName());

            return listItem;
        }
    }
}
