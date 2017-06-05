package domainFacade;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

import domain.*;
import interfaces.IdomainFacade;

/**
 * Created by Johan on 2017-05-02.
 */

/**
 * Facade-mönstret. Hanterar all kommunikation mellan guilagret och domänlagret. Det gör att det
 * blir relativt enkelt att byta ut exempelvis guilagret.
 *
 * Mediator-mönstret. De olika klasserna i domänlagret och guilagret kommunicerar med varandra via facade-klassen,
 * vilket gör att den fungerar som en mediator. klasserna som pratar med varandra känner endast till fasaden.
 *
 * Singleton-mönstret. Klassen kan inte initialiseras mer än en gång och initialiseringen sker när applikationen startas.
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
    public ArrayList<MyList> deleteList(int position){
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
    @Override
    public Store getStoreName(String productListKey){
        return main.getStoreName(productListKey);
    }
    @Override
    public LatLng getUserLocation(){
        return user.getLatlnguser();
    }
    @Override
    public void saveUser(){
        main.saveUser();
    }
    @Override
    public User getUser() {
        return user;
    }
}
