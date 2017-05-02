package domain;

import java.util.ArrayList;

/**
 * Created by Johan on 2017-04-27.
 */

public class User {
    private String email;
    private String password;
    private String userAddress;
    private double gasConsumption;
    private MyList standardList;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public void setUserAddress(String userAddress){
        this.userAddress = userAddress;
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
}
