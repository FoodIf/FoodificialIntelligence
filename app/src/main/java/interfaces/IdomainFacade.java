package interfaces;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import domainFacade.DomainFacade;

/**
 * Created by Johan on 2017-05-09.
 */

public interface IdomainFacade {
    public boolean compareEmail(String email);
    public boolean comparePassword(String password);
    public boolean compareUser(String password, String email);
    public double compareDistance(LatLng latlnguser, LatLng latlngstore);
    public ArrayList <String> deleteproduct(int s);
}
