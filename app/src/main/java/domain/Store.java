package domain;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import dataFacade.DataFacade;

/**
 * Created by Hannes on 2017-04-27.
 */

public class Store {
    private String storeName;
    private DataFacade dataFacade;
    private ArrayList<String> products;
    private String address;
    private int pic;
    private LatLng storelatlng;
    public Store(String storeName, String address, int pic, LatLng storelatlng) {
        this.dataFacade = DataFacade.getInstance();
        this.storeName=storeName;
        products=new ArrayList<String>();
        this.address=address;
        this.pic=pic;
        this.storelatlng=storelatlng;
    }

    public ArrayList<String> getProductList(){

        return compareStoreObject();
    }

    public ArrayList<String> compareStoreObject(){

        products = dataFacade.load(storeName, "load");
        return products;
    }

    public String getStoreName() {
        return storeName;
    }
}
