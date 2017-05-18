package domainFacade;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

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
}
