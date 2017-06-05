package domain;

import com.google.android.gms.maps.model.LatLng;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Johan on 2017-04-27.
 */

public class User implements Serializable {
    private String email;
    private String password;
    private double gasConsumption;
    private ArrayList<MyList> savedLists;
    private ArrayList<String> standardList;
    private double lat;
    private double lng;
    private MyList currentlist;
    private ArrayList<Store> nerByStore;
    private String productListKey;

    public User(String email) {
        this.email = email;
        savedLists = new ArrayList<MyList>();
        this.lat = 58.40197;
        this.lng = 15.57681;
        standardList = new ArrayList<>();
    }

    public void setNerbyStore(Store store) {
        nerByStore.add(store);
    }

    public ArrayList<Store> getNerByStore() {
        return nerByStore;
    }

    public void setStandardList(ArrayList<String> standardList) {
        this.standardList = standardList;
    }

    public ArrayList<String> getStandardList() {
        return standardList;
    }

    public void clearStandardList(ArrayList<String> standardList) {
        this.standardList = standardList;
        this.standardList.clear();
    }

    public void setGasConsumption(double gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public double getGasConsumption() {
        return gasConsumption;
    }

    public LatLng getLatlnguser() {

        return new LatLng(lat, lng);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<MyList> getSavedLists() {
        return savedLists;
    }

    public void setSavedLists(ArrayList<MyList> savedLists) {
        this.savedLists = savedLists;
    }

    public ArrayList<String> getSavedStringLists() {
        return convertList(savedLists);
    }

    public void getSelectedList(String name) {
        for (MyList mylist : savedLists) {
            if (mylist.getName().equals(name)) {
                currentlist = mylist;
            }
        }
    }


    public ArrayList<String> deleteproduct(int position) {
        currentlist.getProducts().remove(position);
        return currentlist.getProducts();
    }

    public ArrayList<String> convertList(ArrayList<MyList> mylist) {
        ArrayList<String> stringList = new ArrayList<String>();
        if (mylist != null) {
            for (int i = 0; i < mylist.size(); i++) {
                stringList.add(mylist.get(i).getName());
            }
        }
        return stringList;
    }

    public ArrayList<MyList> deleteList(int position) {
        savedLists.remove(position);
        return savedLists;
    }

    public void setCurrentList(int position) {
        currentlist = savedLists.get(position);
    }

    public void setNewCurrentList(MyList list) {
        currentlist = list;
    }

    public MyList getCurrentlist() {
        return currentlist;
    }

    public ArrayList<String> getCurrentStringList() {
        return convertcurrentlist();
    }

    private ArrayList<String> convertcurrentlist() {
        return currentlist.getProducts();
    }

    public void addSavedLists(String name) {
        MyList newlist = new MyList(name);
        newlist.setProducts(new ArrayList<String>(standardList));

        savedLists.add(newlist);
        setCurrentList(savedLists.size() - 1);
    }

    public String getListName() {
        return currentlist.getName();
    }

    public ArrayList<String> addProduct(String product) {
        currentlist.addProducts(product);
        return convertcurrentlist();
    }
    public void setProductListKey(String key){
        productListKey = key;
    }
    public String getProductListKey(){
        return productListKey;
    }

}
