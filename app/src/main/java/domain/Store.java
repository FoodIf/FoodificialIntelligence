package domain;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Hannes on 2017-04-27.
 */

public class Store {
    private String storeName;
    private ArrayList<String> products;
    private String address;
    private int pic;
    private LatLng storelatlng;
    public Store(String storeName, String address, int pic, LatLng storelatlng) {
        this.storeName=storeName;
        products=new ArrayList<String>();
        this.address=address;
        this.pic=pic;
        this.storelatlng=storelatlng;
    }
    public ArrayList<String> getProductList(){
        return products;
    }

    public String getStoreName() {
        return storeName;
    }
}
