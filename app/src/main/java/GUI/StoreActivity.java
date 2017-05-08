package GUI;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.hannes.foodificialintelligence.R;

import domain.Store;
import domainFacade.DomainFacade;

/**
 * Created by Hannes on 2017-05-02.
 */

public class StoreActivity extends FragmentActivity implements OnMapReadyCallback {
    private Store store;
    private GoogleMap mMap;
    private DomainFacade domainFacade;

    /* public StoreActivity(Store store, DomainFacade domainFacade) {
         this.store=store;
         this.domainFacade=domainFacade
     }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        TextView nameView = (TextView) findViewById(R.id.store_name);
        nameView.setText("Implementeramedfacadestore.getname()");
        TextView addressView = (TextView) findViewById(R.id.store_address);
        addressView.setText("Implementeramedfacadestore.getaddress()");

        /*double valueResult = domainfacade.distance("implementeragetlnglat");
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
        LatLng storelat = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(storelat).title("Implementeranågongetstorelat"));

    }



}
