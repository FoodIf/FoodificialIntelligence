package GUI;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.hannes.foodificialintelligence.R;

import domain.Store;

/**
 * Created by Hannes on 2017-05-02.
 */

public class StoreActivity extends FragmentActivity implements OnMapReadyCallback {
    private Store store;
    private GoogleMap mMap;
   /* public StoreActivity(Store store) {
        this.store=store;
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        /*TextView nameView = (TextView) findViewById(R.id.store_name);
        nameView.setText("Implementeramedfacadestore.getname()");
        TextView addressView = (TextView) findViewById(R.id.store_name);
        addressView.setText("Implementeramedfacadestore.getaddress()");
        */
        //TODO ImplementeraAvstånd
        //TODO ImplementeraKarta
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
