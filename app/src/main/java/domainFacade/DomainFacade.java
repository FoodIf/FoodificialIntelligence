package domainFacade;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

import domain.*;
import interfaces.IdomainFacade;

/**
 * Created by Johan on 2017-05-02.
 */

public class DomainFacade implements IdomainFacade{
    private static final DomainFacade instance = new DomainFacade();
    private Main main;
    private User user;

    private DomainFacade(){
        this.main = new Main();
    }
    public static DomainFacade getInstance(){
        return instance;
    }
    @Override
    public boolean compareEmail(String email){
        return main.compareEmail(email);
    }
    @Override
    public boolean comparePassword(String password){
        return main.comparePassword(password);
    }
    @Override
    public boolean compareUser(String password, String email){
        Boolean compareuser=main.compareUser(password, email);
        if(compareuser){
            user=main.getUser();
        }
        return compareuser;
    }
    @Override
    public double compareDistance(LatLng latlnguser, LatLng latlngstore){
        return main.distance(latlnguser,latlngstore);
    }
    @Override
    public void setGasConsumption(double gasConsumption){
        if(user != null){
            user.setGasConsumption(gasConsumption);
        }
    }
    @Override
    public double getGasConsumption(){
        return user.getGasConsumption();
    }
    @Override
    public void setStandardList(ArrayList<String> standardList){
        if(user != null) {
            user.setStandardList(standardList);
        }
    }
    @Override
    public ArrayList <String> deleteproduct(int position){
        return user.deleteproduct(position);
    }
    @Override
    public ArrayList<MyList> getSavedLists(){
        return user.getSavedLists();
    }
    @Override
    public ArrayList<String> deleteList(int position){
        return user.deleteList(position);
    }
    @Override
    public ArrayList<String> getSavedStringLists(){
        return user.getSavedStringLists();
    }
    @Override
    public ArrayList<String> getProductList(){
        return main.getProductList();
    }
    @Override
    public void setCurrentList(int position){
        user.setCurrentList(position);
    }
    @Override
    public ArrayList<String> getCurrentStringList(){
        return user.getCurrentStringList();
    }
    @Override
    public void setNewCurrentList(MyList name){
        user.setNewCurrentList(name);
    }
    @Override
    public void addSavedLists(String name){
        user.addSavedLists(name);
    }
    @Override
    public MyList getCurrentList(){
        return user.getCurrentlist();
    }
    @Override
    public ArrayList<String> getStandardList(){
        return user.getStandardList();
    }
    @Override
    public String getListName(){
        return user.getListName();
    }
    @Override
    public void clearStandardList(ArrayList<String> standardList){
        user.clearStandardList(standardList);
    }
    @Override
    public ArrayList<String> storeBuilder(HashMap<String, ArrayList<String>> map){
        return main.storeBuilder(map);
    }
    @Override
    public ArrayList<String> addProduct(String product){
        return user.addProduct(product);
    }
    @Override
    public HashMap<String, ArrayList<String>> compareStores(){
        return main.compareStores();
    }

    @Override
    public String getProductListKey() {
        return user.getProductListKey();
    }

    @Override
    public void setProductListKey(String key) {
        user.setProductListKey(key);
    }
}
