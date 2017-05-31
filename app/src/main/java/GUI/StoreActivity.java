package GUI;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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

    public StoreActivity(){
        domainFacade = DomainFacade.getInstance();
        storeName=domainFacade.getStoreName(domainFacade.getProductListKey()).getStoreName();
        storeAddress=domainFacade.getStoreName(domainFacade.getProductListKey()).getAddress();
        storelatlng=domainFacade.getStoreName(domainFacade.getProductListKey()).getStorelatlng();
        storePicture=domainFacade.getStoreName(domainFacade.getProductListKey()).getPic();
        userlatlng=domainFacade.getUserLocation();
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
        DecimalFormat newFormat = new DecimalFormat("############");
        int kmInDec = Integer.valueOf(newFormat.format(km));

        TextView distanceView = (TextView) findViewById(R.id.store_distance);
        distanceView.setText("Avstånd till butiken: "+kmInDec +" km.");


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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userlatlng, 11));
        mMap.addMarker(new MarkerOptions()
                .position(userlatlng)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("Your location"));

    }



}
