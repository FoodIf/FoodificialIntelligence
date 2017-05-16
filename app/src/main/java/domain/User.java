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
    private ArrayList<String> standardListSetting;
    private LatLng latlnguser;

    public User(String email, String password){
        this.email = email;
        this.password = password;
        this.latlnguser= new LatLng(58.40197,15.57681);
    }
    public User getUser(){
        return this;
    }
    public void setStandardList(ArrayList<String> standardListSetting){
        //this.standardList = new MyList("name");
        this.standardListSetting = standardListSetting;
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
        return latlnguser;
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
}
