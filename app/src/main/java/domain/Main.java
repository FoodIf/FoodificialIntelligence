package domain;


import com.example.hannes.foodificialintelligence.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

import dataFacade.DataFacade;

/**
 * Created by olle_ on 2017-04-27.
 */


public class Main {
    private DataFacade dataFacade;
    private User user;
    private ArrayList<Store> storeList;
    private ArrayList<Chain> chainList;
    private ArrayList<String> productList;

    public Main() {
        this.dataFacade = DataFacade.getInstance();
        this.storeList = new ArrayList<>();
        this.chainList = new ArrayList<>();

        chainList.add(new Chain("ica"));
        chainList.get(chainList.size()-1).newStore("ica", "Raholmsvägen 13, 865 31 Alnö", R.drawable.icabild,new LatLng(62.4288926,17.4171566));
        chainList.add(new Chain("coop"));
        chainList.get(chainList.size()-1).newStore("coop", "Tornby 7, 582 31 Linköping", R.drawable.coopbild,new LatLng(58.432222,15.590758));
        chainList.add(new Chain("citygross"));
        chainList.get(chainList.size()-1).newStore("citygross", "Djurgården 58, 581 28 Linköping", R.drawable.citygrossbild,new LatLng(58.386855,15.588012));
    }

    public static void main(String[] args){
        new Main();
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
    public User compareUserObject(String[] userarray){
        ArrayList<User> userObjectArray = dataFacade.load("userClass", "load");
        for(User user : userObjectArray){
            if(user.getEmail().equals(userarray[0])){
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
                    comparedList.add(storeProduct + " kr");
                    intSum += Double.parseDouble(storeProduct.substring(storeProduct.indexOf("|") +1));
                }
            }
        }
        stringSum = String.valueOf(intSum);
        comparedList.add(stringSum + " kr");
        return comparedList;
    }
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
        ArrayList<String> storePrice = new ArrayList<String>();
        storePrice.add("ica|" + map.get("ica").get(map.get("ica").size() - 1));
        storePrice.add("coop|" + map.get("coop").get(map.get("coop").size() - 1));
        storePrice.add("citygross|" + map.get("citygross").get(map.get("citygross").size() - 1));
        return storePrice;
    }

    public Store getStoreName(String productListKey) {

        for(Chain chain:chainList){
            if(chain.getChainName().equals(productListKey)){
                return chain.getStoreName(productListKey);
            }
        }

        return null;
    }
    public void saveUser(){
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        dataFacade.save("userClass", "save", userList);
    }
}
