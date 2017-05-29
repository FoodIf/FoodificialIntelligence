package domain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hannes.foodificialintelligence.R;
import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import GUI.LoginActivity;
import GUI.MainActivity;
import MyAndroid.MyApplication;
import dataFacade.DataFacade;
import domainFacade.DomainFacade;

/**
 * Created by olle_ on 2017-04-27.
 */

public class Main {
    private DataFacade dataFacade;
    private User user;
    private ArrayList<Store> storeList;
    private ArrayList<Chain> chainList;
    private ArrayList<String> productList;
    private String activeView;

    public Main() {
        this.dataFacade = DataFacade.getInstance();
        //this.user = new User();
        this.storeList = new ArrayList<>();
        this.chainList = new ArrayList<>();

        // storeList.add(new Store("Rogers Livs", "Pillesnoppvägen 1",R.drawable.bildaddress,new LatLng(double,double)));

        chainList.add(new Chain("ica"));
        chainList.get(chainList.size()-1).newStore("ica", "Raholmsvägen 13, 865 31 Alnö", R.drawable.icabild,new LatLng(62.4288926,17.4171566));
        chainList.add(new Chain("coop"));
        chainList.get(chainList.size()-1).newStore("coop", "Tornby 7, 582 31 Linköping", R.drawable.coopbild,new LatLng(58.432222,15.590758));
        chainList.add(new Chain("citygross"));
        chainList.get(chainList.size()-1).newStore("citygross", "Djurgården 58, 581 28 Linköping", R.drawable.citygrossbild,new LatLng(58.386855,15.588012));


        //TODO SPARA ANVÄNDAREN OCH DESS LISTOR VID FÖRÄNDRING I LISTOR

        //Temp, ska bort senare. Sparar objekt #GrowAfro.
        /*ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("test@test.se"));
        dataFacade.save("userClass", "save", userList);*/


      //Temp, ska bort senare. Hämtar objekt. #GrowAfro.
        /*ArrayList<User> test = dataFacade.load("userClass", "load");
        User user = (User)test.get(0);*/
    }

    public static void main(String[] args){
        new Main();

    
    }
    public boolean compareEmail(String email){
        //dataFacade.load("login", "load");
        return true;
    }
    public boolean comparePassword(String password){

        return true;
    }
    public boolean compareUser(String password, String email){
        ArrayList<String> compare=dataFacade.load("user", "load");
        for(int i=0;i<compare.size();i++) {
            String[] userarray = compare.get(i).split("\\|");
            if (userarray[0].equals(email) && userarray[1].equals(password)) {
                user = compareUserObject(userarray);
                return true;
            }
        }
        return false;
    }
    public User getUser(){
        return user;
    }

    /**
     * Jämför userObjectets email med den inloggade emailen.
     * @param userarray
     * @return Ger tillbaka rätt user.
     */
    public User compareUserObject(String[] userarray){
        ArrayList<User> userObjectArray = dataFacade.load("userClass", "load");
        for(User user : userObjectArray){
            if(user.getEmail().equals(userarray[0])){
                Log.v(user.getEmail(), "ladda user");
                return user;
            }
        }
        return null;
    }
    /**
     *
     * @return HashMap<String, ArrayList<String>>
     */
    public HashMap<String, ArrayList<String>> compareStores(){
        MyList userList = user.getCurrentlist();
        HashMap<String, ArrayList<String>> comparedLists = new HashMap<>();
        ArrayList<String> comparedList = new ArrayList<>();

        for(Chain chain : chainList){
            for(Store store : chain.getStoreList()){
                comparedList = compareStoreList(userList, store.getProductList());
                comparedLists.put(chain.getChainName(), comparedList);
            }
        }
        return comparedLists;
    }
    private ArrayList<String> compareStoreList(MyList userList, ArrayList<String> productList){
        ArrayList<String> comparedList = new ArrayList<>();
        int intSum = 0;
        String stringSum = "";

        for(String userProduct : userList.getProducts()){
            for(String storeProduct : productList){
                if(storeProduct.contains(userProduct)){
                    comparedList.add(storeProduct);
                    intSum += Double.parseDouble(storeProduct.substring(storeProduct.indexOf("|")));
                }
            }
        }
        stringSum = String.valueOf(intSum);
        comparedList.add(stringSum);
        return comparedList;
    }

    /**
     *
     * @param //usedList
     * @param //nearBy
     * @return Ger tillbaka en hashmap med Store name som key och en "Arraylist<String>" där summan av alla varoar är utskrivan på sista raden i Arrayn.
     */
    /*public static HashMap<String, ArrayList<String>> storesToComp(MyList usedList, ArrayList<Store> nearBy){
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
    }*/
    public double distance(LatLng latlnguser, LatLng latlngstore) {
        int sizeofearth = 6371;
        double lat1 = latlnguser.latitude;
        double lat2 = latlngstore.latitude;
        double lon1 = latlnguser.longitude;
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
    public ArrayList<String> setProductList(ArrayList<String> productList){

        String tag = "product";
        String operation = "load";
        productList = dataFacade.load(tag, operation);
        this.productList = productList;
        return this.productList;
    }
    public ArrayList<String> getProductList(){
        if (productList == null) {
            productList = setProductList(productList);
            return productList;
        }
        else {
            return productList;
        }
    }
    public ArrayList<String> storeBuilder(HashMap<String, ArrayList<String>> map) {
        ArrayList<String> storenPrice = new ArrayList<String>();
        storenPrice.add("Ica|" + map.get("Ica").get(map.get("Ica").size() - 1));
        storenPrice.add("Coop|" + map.get("Coop").get(map.get("Coop").size() - 1));
        storenPrice.add("Citygross|" + map.get("Citygross").get(map.get("Citygross").size() - 1));
        return storenPrice;
    }
}
