package domain;


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
    public void newStore(String storeName, String address){
        stores.add(new Store(storeName, address,"bild"));
    }
}
