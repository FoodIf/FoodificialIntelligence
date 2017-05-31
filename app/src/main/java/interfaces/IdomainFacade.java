package interfaces;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

import domain.Store;
import domainFacade.DomainFacade;
import domain.MyList;

/**
 * Created by Johan on 2017-05-09.
 */

public interface IdomainFacade {
    public boolean compareUser(String password, String email);
    public double compareDistance(LatLng latlnguser, LatLng latlngstore);
    public void setGasConsumption(double gasConsumption);
    public double getGasConsumption();
    public void setStandardList(ArrayList<String> standardList);
    public ArrayList<MyList> getSavedLists();
    public ArrayList <String> deleteproduct(int s);
    public ArrayList<String> deleteList(int position);
    public ArrayList<String> getSavedStringLists();
    public ArrayList<String> getProductList();
    public ArrayList<String> getCurrentStringList();
    public void setCurrentList(int position);
    public void setNewCurrentList(MyList list);
    public void addSavedLists(String name);
    public MyList getCurrentList();
    public ArrayList<String> getStandardList();
    public String getListName();
    public void clearStandardList(ArrayList<String> standardList);
    public ArrayList<String> storeBuilder(HashMap<String, ArrayList<String>> map);
    public ArrayList<String> addProduct(String product);
    public HashMap<String, ArrayList<String>> compareStores();
    public String getProductListKey();
    public void setProductListKey(String key);
    public Store getStoreName(String productListKey);
    public LatLng getUserLocation();
    public void saveUser();
}
