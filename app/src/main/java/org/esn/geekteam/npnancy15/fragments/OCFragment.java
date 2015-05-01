package org.esn.geekteam.npnancy15.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.models.OCMember;

import java.util.ArrayList;

/**
 * Created by Spider on 06/01/15.
 */
public class OCFragment extends android.support.v4.app.ListFragment {
    private static final String TAG = OCFragment.class.getSimpleName();
    private CustomListAdapter adapter;
    private Activity currentActivity;
    private ArrayList<OCMember> OCMembers;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOCMembers();

        // Set an Adapter to the ListView
        adapter = new CustomListAdapter(currentActivity);
        this.setListAdapter(adapter);
    }

    public void initOCMembers(){
        this.OCMembers = new ArrayList<OCMember>();
        this.OCMembers.add(new OCMember("Bertrand", "Kaufmann", "0771045525", "Head of OC"));
        this.OCMembers.add(new OCMember("Alexandra", "Tistea", "0615812506", "Vice head"));
        this.OCMembers.add(new OCMember("Carole", "Eber", "0624010227", "Responsable des paiements"));
        this.OCMembers.add(new OCMember("Rudy", "Hoarau", "0621182218", "Responsable Chair"));
        this.OCMembers.add(new OCMember("Mylene", "Fohrer", "0683441546", "Responsable hébergement"));
        this.OCMembers.add(new OCMember("Marion", "Rusterholtz", "0673441739", "Responsable nourriture"));
        this.OCMembers.add(new OCMember("Marion", "Geille", " 0750930624", "Responsable soirée"));
        this.OCMembers.add(new OCMember("Florent", "Lenoir", "0607895144", "Chair"));
        this.OCMembers.add(new OCMember("Laura", "Mazi", "0613303219", "Vice-Chair"));
    }

    public void onResume(){
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        currentActivity = activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        if (OCMembers.get(pos).getFirstName().equalsIgnoreCase("Florent")
                && OCMembers.get(pos).getLastName().equalsIgnoreCase("Lenoir")){
            final MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.elephant);
            mp.start();
        }
    }


    class CustomListAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public CustomListAdapter(Activity activity) {

            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return OCMembers.size();
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
                listItem = layoutInflater.inflate(R.layout.list_oc, null);
            }

            // Initialize the views in the layout
            ImageView iv = (ImageView) listItem.findViewById(R.id.thumb);
            TextView tvName = (TextView) listItem.findViewById(R.id.name);
            TextView tvPost= (TextView) listItem.findViewById(R.id.post);
            TextView tvTel = (TextView) listItem.findViewById(R.id.tel);

            // Set the views in the layout
            String name = OCMembers.get(pos).getFirstName() + " " + OCMembers.get(pos).getLastName();

            String uri = "@drawable/" + (OCMembers.get(pos).getFirstName() + "_" + OCMembers.get(pos).getLastName()).toLowerCase();
            Log.d(TAG,uri);
            int imgRessource = currentActivity.getResources().getIdentifier(uri, null, currentActivity.getPackageName());
            Drawable res = getResources().getDrawable(imgRessource);
            iv.setImageDrawable(res);

            tvName.setText(name);
            tvPost.setText(OCMembers.get(pos).getPost());
            tvTel.setText(OCMembers.get(pos).getTel());

            return listItem;
        }
    }

}
