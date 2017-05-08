package domain;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Alexander Nilsson on 2017-04-27.
 */

public class Chain {
    private String chainName;
    private ArrayList <Store> stores;

    public Chain(String chainName) {
        this.chainName=chainName;
        stores=new ArrayList<Store>();
    }
    public void newStore(String storeName, String address, int pic, LatLng storelatlng){
        stores.add(new Store(storeName, address, pic, storelatlng));
    }
}
