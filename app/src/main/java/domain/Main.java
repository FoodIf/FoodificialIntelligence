package domain;

import java.util.ArrayList;
import java.util.HashMap;

import domainFacade.DomainFacade;

/**
 * Created by olle_ on 2017-04-27.
 */

public class Main {
    private User user;
    private ArrayList<Store> storeList;
    private ArrayList<Chain> chainList;
    private Products products;

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

    private static String[] compare(String product, ArrayList<String> storeList){
        double price=0;
        String[] combo = new String[2];
        for (String store:storeList) {
            if (store.equals(product)){
            combo[1]=store.substring(store.indexOf("|"));
        }
            combo[0]= store;
        }
        return combo;
    }
}
