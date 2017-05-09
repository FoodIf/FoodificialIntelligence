package domainFacade;
import com.google.android.gms.maps.model.LatLng;

import domain.*;

/**
 * Created by Johan on 2017-05-02.
 */

public class DomainFacade {
    private static final DomainFacade instance = new DomainFacade();
    private Main main;

    private DomainFacade(){
        this.main = new Main();
    }
    public static DomainFacade getInstance(){
        return instance;
    }
    public boolean compareEmail(String email){
        return main.compareEmail(email);
    }
    public boolean comparePassword(String password){
        return main.comparePassword(password);
    }
    public boolean compareUser(String password, String email){
        return main.compareUser(password, email);
    }
    public double compareDistance(LatLng latlnguser, LatLng latlngstore){
        return main.distance(latlnguser,latlngstore);
    }
}
