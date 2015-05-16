package org.esn.geekteam.npnancy15.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.activities.DetailFragmentActivity;
import org.esn.geekteam.npnancy15.models.Tips;

import java.util.ArrayList;

/**
 * Created by Spider on 29/04/15.
 */
public class TipsFragment extends android.support.v4.app.ListFragment {
    private static final String TAG = AwardsFragment.class.getSimpleName();
    private ArrayList<Tips> tips;
    private CustomListAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initTips();

        // Set an Adapter to the ListView
        adapter = new CustomListAdapter(getActivity());
        this.setListAdapter(adapter);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);

        if (tips.get(pos).getTitle().equalsIgnoreCase("HashTag")){
            Intent intent = new Intent(getActivity(), DetailFragmentActivity.class);

            Bundle b = new Bundle();
            b.putSerializable("tip", tips.get(pos));
            intent.putExtras(b);

            startActivity(intent);
        }

    }

    public void initTips(){
        tips = new ArrayList<Tips>();
        tips.add(new Tips("HashTag", "#NPNancy2015, #ESNfrenchtouch"));
        tips.add(new Tips("Taxi", "Lorem Ipsum Dolor"));
        tips.add(new Tips("Bus", "Lorem Ipsum Dolor"));
        tips.add(new Tips("Police Station", "Lorem Ipsum Dolor"));
    }

    class CustomListAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public CustomListAdapter(Activity activity) {

            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return tips.size();
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
                listItem = layoutInflater.inflate(R.layout.list_tips, null);
            }

            // Initialize the views in the layout
            TextView tvTitle = (TextView) listItem.findViewById(R.id.title);
            TextView tvDescription = (TextView) listItem.findViewById(R.id.description);

            tvTitle.setText(tips.get(pos).getTitle());
            tvDescription.setText(tips.get(pos).getDescription());

            return listItem;
        }
    }
}
