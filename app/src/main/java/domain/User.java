package domain;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Johan on 2017-04-27.
 */

public class User implements Serializable {
    private String email;
    private String password;
    private double gasConsumption;
    private ArrayList<MyList> savedLists;
    private MyList standardList;
    private double lat;
    private double lng;
    private MyList currentlist;

    public User(String email){
        this.email = email;
        //this.password = password;
        this.lat=58.40197;
        this.lng=15.57681;
    }
    public void setStandardList(ArrayList<String> standardListSetting){
        this.standardList = new MyList("Standard", standardListSetting);
    }
    public MyList getStandardList(){
        return standardList;
    }
    public void setGasConsumption(double gasConsumption){
        this.gasConsumption = gasConsumption;
    }
    public double getGasConsumption(){
        return gasConsumption;
    }
    public LatLng getLatlnguser(){

        return new LatLng(lat,lng);
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
    public void getSelectedList(String name){
        for (MyList mylist: savedLists) {
            if(mylist.getName().equals(name)){
                currentlist= mylist;
            }
        }
    }


    public ArrayList<String> deleteproduct(int position) {
        currentlist.getProducts().remove(position);
        return currentlist.getProducts();
    }
}
