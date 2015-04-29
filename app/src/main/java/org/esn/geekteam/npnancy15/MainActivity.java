package org.esn.geekteam.npnancy15;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.esn.geekteam.npnancy15.fragments.MyFragmentPagerAdapter;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
    private static final String TAG = ActionBarActivity.class.getSimpleName();
    private ViewPager myPager;
    public static MyFragmentPagerAdapter myAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragmentPagerAdapter fpa = new MyFragmentPagerAdapter(getSupportFragmentManager());

        //Init ActionBar
        try {
            getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }catch(Exception e){
            Log.d(TAG, "Exception: " + e);
        }

        //Init Pager
        myPager = (ViewPager) findViewById(R.id.pager);
        myPager.setAdapter(fpa);
        myPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getActionBar().setSelectedNavigationItem(position);
            }
        });

        //Add tabs
        initTabs();

    }

    private void initTabs(){
        ActionBar.Tab tabOc = getActionBar().newTab();
        tabOc.setText(getResources().getString(R.string.tab_oc));
        tabOc.setTabListener(this);
        getActionBar().addTab(tabOc);

        ActionBar.Tab tabSchedule = getActionBar().newTab();
        tabSchedule.setText(getResources().getString(R.string.tab_schedule));
        tabSchedule.setTabListener(this);
        getActionBar().addTab(tabSchedule);

        ActionBar.Tab tabTips = getActionBar().newTab();
        tabTips.setText(getResources().getString(R.string.tab_tips));
        tabTips.setTabListener(this);
        getActionBar().addTab(tabTips);

        ActionBar.Tab tabMap = getActionBar().newTab();
        tabMap.setText(getResources().getString(R.string.tab_map));
        tabMap.setTabListener(this);
        getActionBar().addTab(tabMap);

        ActionBar.Tab tabAbout = getActionBar().newTab();
        tabAbout.setText(getResources().getString(R.string.tab_about));
        tabAbout.setTabListener(this);
        getActionBar().addTab(tabAbout);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("viewpagerid" , myPager.getId() );
    }

    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft){
        myPager.setCurrentItem(tab.getPosition());
    }

    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft){
        // TODO Auto-generated method stub
    }

    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft){
        // TODO Auto-generated method stub
    }
}
