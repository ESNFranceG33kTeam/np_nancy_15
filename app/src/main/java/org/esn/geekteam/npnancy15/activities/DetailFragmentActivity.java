package org.esn.geekteam.npnancy15.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.fragments.DetailFragment;

/**
 * Created by Spider on 08/05/15.
 */
public class DetailFragmentActivity extends FragmentActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransacton = fragmentManager.beginTransaction();

        DetailFragment detailFragment = new DetailFragment();

        Bundle b = new Bundle();
        b.putSerializable("tip", getIntent().getSerializableExtra("tip"));
        detailFragment.setArguments(b);

        fragmentTransacton.add(R.id.details_fragment_container, detailFragment);
        fragmentTransacton.commit();
    }
}
