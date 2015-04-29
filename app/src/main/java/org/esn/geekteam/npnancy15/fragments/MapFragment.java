package org.esn.geekteam.npnancy15.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.esn.geekteam.npnancy15.R;
import org.esn.geekteam.npnancy15.models.Place;

import java.util.ArrayList;

/**
 * Created by Spider on 29/04/15.
 */
public class MapFragment extends Fragment{

    MapView mMapView;
    private GoogleMap googleMap;
    private ArrayList<Place> places;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.fragment_location_info, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();

        initPlaces();

        for(Place p: places){
            // create marker
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(p.getLatitude(), p.getLongitude())).title(p.getTitle());

            // Changing marker icon
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.esn_star));

            // adding marker
            googleMap.addMarker(marker);
        }

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(48.6886759, 6.1791018)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        // Perform any camera updates here
        return v;
    }

    public void initPlaces(){
        places = new ArrayList<Place>();
        places.add(new Place("Pleniere", "Placee Stanislas 54000 Nancy", "48.6886759", "6.1791018"));
        places.add(new Place("Parc Sainte-Marie", "Avenue Boffrand 54000 Nancy", "48.6986759", "6.1791018"));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
