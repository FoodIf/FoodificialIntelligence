package domain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hannes.foodificialintelligence.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

import GUI.LoginActivity;
import GUI.MainActivity;
import domainFacade.DomainFacade;

import static com.example.hannes.foodificialintelligence.R.id.goToSettings_Button;

/**
 * Created by olle_ on 2017-04-27.
 */

public class Main {
    private User user;
    private ArrayList<Store> storeList;
    private ArrayList<Chain> chainList;
    private Products products;
    private String activeView;

    public Main() {
        //this.user = new User();
        this.storeList = new ArrayList<>();
        this.chainList = new ArrayList<>();
        this.products = new Products();

        // storeList.add(new Store("Rogers Livs", "Pillesnoppvägen 1"));

        chainList.add(new Chain("Ica"));
        chainList.add(new Chain("Coop"));
        chainList.add(new Chain("Citygross"));

    }

    public static void main(String[] args){
        new Main();
    
    }
    public boolean compareEmail(String email){
        return true;
    }
    public boolean comparePassword(String password){
        return true;
    }

    /**
     *
     * @param usedList
     * @param nearBy
     * @return Ger tillbaka en hashmap med Store name som key och en "Arraylist<String>" där summan av alla varoar är utskrivan på sista raden i Arrayn.
     */
    public static HashMap storesToComp(MyList usedList, ArrayList<Store> nearBy){
        ArrayList<String> newList;
        HashMap<String, ArrayList<String>> sortedStores = new HashMap<String, ArrayList<String>>();
        for (Store list:nearBy){
            newList=cheapestList(usedList,list.getProductList());
            int size = newList.size();
            double sum = Double.parseDouble(newList.get(size-1));
            sortedStores.put(list.getStoreName(),newList);
        }
        return sortedStores;
    }
    private static ArrayList<String> cheapestList(MyList myList, ArrayList<String> compWith){
        String[] combo;
        double sum=0;
        ArrayList <String> productNsum = new ArrayList<>();
        for (String product: myList.getProducts()) {
            combo= compare(product, compWith);
            sum =+ Double.parseDouble(combo[1]);
            productNsum.add(combo[0]);
        }
        productNsum.add(String.valueOf(sum));
        return productNsum;
    }

    private static String[] compare(String product, ArrayList<String> storeList) {
        double price = 0;
        String[] combo = new String[2];
        for (String store : storeList) {
            if (store.equals(product)) {
                combo[1] = store.substring(store.indexOf("|"));
            }
            combo[0] = store;
        }
        return combo;
    }
    public double distance(LatLng latlngyou, LatLng latlngstore) {
        //TODO ska denna in i domän kanske? enkelt att fixa isf
        int sizeofearth = 6371;
        double lat1 = latlngyou.latitude;
        double lat2 = latlngstore.latitude;
        double lon1 = latlngyou.longitude;
        double lon2 = latlngstore.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));


        return sizeofearth * c;
    }

}
