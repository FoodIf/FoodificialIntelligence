package GUI;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.hannes.foodificialintelligence.R;

import java.text.DecimalFormat;

import domainFacade.DomainFacade;

/**
 * Created by Hannes on 2017-05-02.
 */

public class StoreActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private DomainFacade domainFacade;
    private int storePicture;
    private String storeName;
    private String storeAddress;
    private LatLng storelatlng;
    private LatLng userlatlng;

    public StoreActivity(){}
     public StoreActivity(DomainFacade domainFacade, int storePicture, String storeName, String storeAddress, LatLng storelatlng, LatLng userlatlng) {
         this.domainFacade=domainFacade;
         this.storePicture = storePicture;
         this.storeName=storeName;
         this.storeAddress=storeAddress;
         this.storelatlng=storelatlng;
         this.userlatlng=userlatlng;
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        TextView nameView = (TextView) findViewById(R.id.store_name);
        nameView.setText(storeName);
        TextView addressView = (TextView) findViewById(R.id.store_address);
        addressView.setText(storeAddress);

        double valueResult = domainFacade.compareDistance(storelatlng,userlatlng);
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        //Inte 100 på vad denna gör, men testa utskriften nedan istället för denna, sparar bara denna ifall att.
        Log.i("Distance", "" + valueResult + " km " + kmInDec
                + " Meter " + meterInDec+ ".");
        //
        TextView distanceView = (TextView) findViewById(R.id.store_distance);
        distanceView.setText(valueResult + " km " + kmInDec
                + " Meter " + meterInDec+ "                 .");


        ImageView storebild = (ImageView) findViewById(R.id.storepicture);
        storebild.setImageResource(storePicture);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(storelatlng).title(storeName));

    }



}
