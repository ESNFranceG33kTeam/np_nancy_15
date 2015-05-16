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
        schedules.add("Vendredi 05 Juin");
        schedules.add(new Schedule("Vendredi 05 Juin", "14:30", "City Tour", "Grand Place","",getResources().getColor(R.color.esngreen)));


        schedules.add("Samedi 06 Juin");
        schedules.add(new Schedule("Samedi 06 Juin", "08:00", "Réunion de CA", "CA", "", getResources().getColor(R.color.esnpurple)));
        schedules.add(new Schedule("Samedi 06 Juin", "10:00", "Ouverture", "Présentation", "Sarah", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "10:05", "Présentation et élections des chairs (quorum)", "Présentation", "Orianne", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "10:10", "Présentation et vote de l'Agenda", "Présentation", "Florent", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "10:13", "Règles en NP (plénières)", "Présentation", "Florent, Laura", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "10:15", "Présentation OC", "Présentation", "Bertrand", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "10:20", "Plan d'action du bureau ", "Présentation", "Bureau", getResources().getColor(R.color.esngreen)));

        schedules.add(new Schedule("Samedi 06 Juin", "11:00", "Pause Café", "Pause", "", getResources().getColor(R.color.esnorange)));

        schedules.add(new Schedule("Samedi 06 Juin", "11:15", "Small Session", "SS", "", getResources().getColor(R.color.esnblue)));
        schedules.add(new Schedule("Samedi 06 Juin", "11:45", "Small Session", "SS", "", getResources().getColor(R.color.esnblue)));
        schedules.add(new Schedule("Samedi 06 Juin", "12:15", "Small Session", "SS", "", getResources().getColor(R.color.esnblue)));
        schedules.add(new Schedule("Samedi 06 Juin", "12:45", "Small Session", "SS", "", getResources().getColor(R.color.esnblue)));

        schedules.add(new Schedule("Samedi 06 Juin", "13:15", "Repas", "Repas", "", getResources().getColor(R.color.esnorange)));

        schedules.add(new Schedule("Samedi 06 Juin", "14:00", "Meet your colleagues", "Meet your colleagues", "Bureau", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "14:45", "Candidature NP octobre", "Présentation", "", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "14:55", "Candidature NP février", "Présentation", "", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:05", "Candidature entrée réseau", "Présentation", "eROUENsmus", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:15", "Candidature entrée réseau", "Présentation", "Bordeaux", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:25", "Présentation association invitée", "Présentation", "Belfort-Montbeliard (ISBM)", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:33", "Updates internationales", "Présentation", "Coco", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:43", "FGSM", "Présentation", "Marie", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:48", "ESN Team", "Présentation", "Thibault", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "15:53", "Updates partenaires", "Présentation", "Rémi", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "16:03", "Présentation partenaire", "Présentation", "", getResources().getColor(R.color.esngreen)));

        schedules.add(new Schedule("Samedi 06 Juin", "16:13", "Pause Café", "Pause", "", getResources().getColor(R.color.esnorange)));

        schedules.add(new Schedule("Samedi 06 Juin", "16:28", "Workshops", "WS", "", getResources().getColor(R.color.esnblue)));

        schedules.add(new Schedule("Samedi 06 Juin", "18:28", "Projets", "Présentation", "", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Samedi 06 Juin", "19:08", "Description suite soirée", "Présentation", "OC", getResources().getColor(R.color.esngreen)));


        schedules.add("Dimanche 07 Juin");
        schedules.add(new Schedule("Dimanche 07 Juin", "08:00", "Réunion CA", "CA", "", getResources().getColor(R.color.esnpurple)));
        schedules.add(new Schedule("Dimanche 07 Juin", "09:00", "Focus Comités", "Presentation", "Comités", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "09:30", "ESN Finland", "Presentation", "Matleena", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "09:40", "ESN Germany", "Presentation", "Marie, Benni", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "09:50", "ESN Luxembourg", "Presentation", "Kris", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "10:00", "ESN Portugal", "Presentation", "Inês, Tiago", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "10:10", "Update comm'", "Presentation", "Yoan", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "10:20", "Pause café", "Pause", "", getResources().getColor(R.color.esnorange)));
        schedules.add(new Schedule("Dimanche 07 Juin", "10:35", "Workshops", "WS", "", getResources().getColor(R.color.esnblue)));
        schedules.add(new Schedule("Dimanche 07 Juin", "12:35", "Rouen + Bordeaux + NPs", "Presentation", "", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "12:35", "Awards", "Presentation", "Chairing team", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "12:50", "Mot de la présidente", "Presentation", "Sarah", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "12:55", "Mot de l'OC", "Presentation", "OC", getResources().getColor(R.color.esngreen)));
        schedules.add(new Schedule("Dimanche 07 Juin", "13:00", "Repas", "Repas", "", getResources().getColor(R.color.esnorange)));
        schedules.add(new Schedule("Dimanche 07 Juin", "14:00", "Réunion CA", "CA", "", getResources().getColor(R.color.esnpurple)));

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

            if (schedules.get(position) instanceof String)
            {
                listItem = layoutInflater.inflate(R.layout.list_header, null);
                previousDate = schedules.get(position).toString();
                TextView header = (TextView) listItem.findViewById(R.id.header);
                header.setText(schedules.get(position).toString());
            }
            else if (schedules.get(position) instanceof Schedule)
            {
                listItem = layoutInflater.inflate(R.layout.list_schedule, null);

                Schedule schedule = (Schedule)schedules.get(position);

                TextView tvDescription= (TextView) listItem.findViewById(R.id.description);
                TextView tvSpeaker= (TextView) listItem.findViewById(R.id.speaker);
                TextView tvHour = (TextView) listItem.findViewById(R.id.hour);

                if (schedule.getType().equalsIgnoreCase("SS") ||
                        schedule.getType().equalsIgnoreCase("Repas") ||
                        schedule.getType().equalsIgnoreCase("WS") ||
                        schedule.getType().equalsIgnoreCase("CA") ||
                        schedule.getType().equalsIgnoreCase("Pause") ){
                    listItem.setBackgroundColor(schedule.getBackgroundColor());

                    tvDescription.setTextColor(getResources().getColor(R.color.white));
                }

                tvHour.setText(schedule.getHour());
                tvHour.setBackgroundColor(schedule.getBackgroundColor());
                tvDescription.setText(schedule.getDescription());
                tvSpeaker.setText(schedule.getSpeaker());
            }

            return listItem;
        }
    }

}
