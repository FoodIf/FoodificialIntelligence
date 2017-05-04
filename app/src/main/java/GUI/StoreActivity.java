package GUI;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.hannes.foodificialintelligence.R;

import java.text.DecimalFormat;

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
        TextView nameView = (TextView) findViewById(R.id.store_name);
        nameView.setText("Implementeramedfacadestore.getname()");
        TextView addressView = (TextView) findViewById(R.id.store_address);
        addressView.setText("Implementeramedfacadestore.getaddress()");

        /*double valueResult = distance("implementeragetlnglat");
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Distance", "" + valueResult + " km " + kmInDec
                + " Meter " + meterInDec+ ".");
        TextView distanceView = (TextView) findViewById(R.id.store_distance);
        distanceView.setText("någontextsomvisaravstånd");*/


        ImageView storebild = (ImageView) findViewById(R.id.storepicture);
        storebild.setImageResource(R.drawable.icabild);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

    }
    public double distance(LatLng latlngyou, LatLng latlngstore) {
        int sizeofearth = 6371;
        double lat1 = latlngyou.latitude;
        double lat2 = latlngstore.latitude;
        double lon1 = latlngyou.longitude;
        double lon2 = latlngstore.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));


        return sizeofearth * c;
    }


}
