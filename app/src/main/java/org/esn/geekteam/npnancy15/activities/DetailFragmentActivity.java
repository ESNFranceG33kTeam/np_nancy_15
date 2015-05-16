package org.esn.geekteam.npnancy15.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.models.Tips;

/**
 * Created by Spider on 08/05/15.
 */
public class DetailFragmentActivity extends FragmentActivity{

    private Tips tip;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        tip = (Tips) b.getSerializable("tip");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, null);

        TextView title = (TextView) view.findViewById(R.id.detail_title);
        TextView desc = (TextView) view.findViewById(R.id.detail_description);

        title.setText(tip.getTitle());
        desc.setText(tip.getDescription());

        return view;
    }
}
