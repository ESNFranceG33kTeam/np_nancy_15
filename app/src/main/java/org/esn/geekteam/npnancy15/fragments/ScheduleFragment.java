package org.esn.geekteam.npnancy15.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.models.Schedule;

import java.util.ArrayList;

/**
 * Created by Spider on 06/01/15.
 */
public class ScheduleFragment extends android.support.v4.app.ListFragment {
    private static final String TAG = ScheduleFragment.class.getSimpleName();
    private CustomListAdapter adapter;
    private ListFragment listFragment;
    private Activity currentActivity;
    private ArrayList schedules;
    private String previousDate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listFragment = this;
        previousDate = "";
        schedules = new ArrayList();
        initSchedule();

        // Set an Adapter to the ListView
        adapter = new CustomListAdapter(currentActivity);
        this.setListAdapter(adapter);
    }

    public void initSchedule(){
        //schedules.add("Vendredi 05 Juin");
        schedules.add(new Schedule("Vendredi 05 Juin", "14:30", "City Tour", "Grand Place"));
        schedules.add(new Schedule("Vendredi 05 Juin", "15:30", "City Tour", "Grand Place"));
        schedules.add(new Schedule("Vendredi 05 Juin", "16:30", "City Tour", "Grand Place"));
        schedules.add(new Schedule("Vendredi 05 Juin", "17:30", "City Tour", "Grand Place"));
        //schedules.add("Samedi 06 Juin");
        schedules.add(new Schedule("Samedi 06 Juin", "17:30", "City Tour", "Grand Place"));
        //schedules.add("Dimanche 07 Juin");
        schedules.add(new Schedule("Dimanche 07 Juin", "17:30", "City Tour", "Grand Place"));
        schedules.add(new Schedule("Dimanche 07 Juin", "17:30", "City Tour", "Grand Place"));
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

    class CustomListAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public CustomListAdapter(Activity activity) {

            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return schedules.size();
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

            View listItem = convertView;

            if (schedules.get(position) instanceof String) {
                listItem = layoutInflater.inflate(R.layout.list_header, null);
                previousDate = schedules.get(position).toString();
                TextView header = new TextView(getActivity());
                header.setText(schedules.get(position).toString());
            }else if (schedules.get(position) instanceof Schedule){
                listItem = layoutInflater.inflate(R.layout.list_schedule, null);
                TextView tvHour = (TextView) listItem.findViewById(R.id.hour);
                TextView tvTitle= (TextView) listItem.findViewById(R.id.title);
                TextView tvAddress = (TextView) listItem.findViewById(R.id.address);

                tvHour.setText(((Schedule)schedules.get(position)).getHour());
                tvTitle.setText(((Schedule)schedules.get(position)).getTitle());
                tvAddress.setText(((Schedule)schedules.get(position)).getAddress());
            }
            return listItem;
        }
    }

}
