package interfaces;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import domainFacade.DomainFacade;
import domain.MyList;

/**
 * Created by Johan on 2017-05-09.
 */

public interface IdomainFacade {
    public boolean compareEmail(String email);
    public boolean comparePassword(String password);
    public boolean compareUser(String password, String email);
    public double compareDistance(LatLng latlnguser, LatLng latlngstore);
    public void setGasConsumption(double gasConsumption);
    public double getGasConsumption();
    public void setStandardList(ArrayList<String> standardList);
    public ArrayList<MyList> getSavedLists();
    public ArrayList <String> deleteproduct(int s);
    public ArrayList<String> deleteList(int position);
    public ArrayList<String> getProductList();
}
