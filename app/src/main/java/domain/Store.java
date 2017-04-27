package domain;

import java.util.ArrayList;

/**
 * Created by Hannes on 2017-04-27.
 */

public class Store {
    private String storeName;
    private ArrayList<String> products;
    private String address;
    public Store(String storeName, String address) {
        this.storeName=storeName;
        products=new ArrayList<String>();
        this.address=address;
    }
    public ArrayList<String> getProductList(){
        return products;
    }
}
