package domain;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Johan on 2017-04-27.
 */

public class User {
    private String email;
    private String password;
    private double gasConsumption;
    private MyList standardList;
    private LatLng latlnguser;

    public User(String email, String password){
        this.email = email;
        this.password = password;
        this.latlnguser= new LatLng(58.40197,15.57681);
    }
    public User getUser(){
        return this;
    }
    public void setStandardList(){
        this.standardList = new MyList("name");
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
}
