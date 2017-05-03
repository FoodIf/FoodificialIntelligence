package domain;

import java.util.ArrayList;

/**
 * Created by Hannes on 2017-04-27.
 */

public class Store {
    private String storeName;
    private ArrayList<String> products;
    private String address;
    private String bild;
    public Store(String storeName, String address, String bild) {
        this.storeName=storeName;
        products=new ArrayList<String>();
        this.address=address;
        this.bild=bild;
    }
    public ArrayList<String> getProductList(){
        return products;
    }

    public String getStoreName() {
        return storeName;
    }
}
