package domain;

import java.util.ArrayList;

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
        this.storeList = new ArrayList<>();
        this.chainList = new ArrayList<>();
        this.products = new Products();

        storeList.add(new Store("Rogers Livs", "Pillesnoppvägen 1", "bild"));

        chainList.add(new Chain("Ica"));
        chainList.add(new Chain("Coop"));
        chainList.add(new Chain("Citygross"));
    }
    public boolean compareEmail(String email){
        return true;
    }
    public boolean comparePassword(String password){
        return true;
    }
    public static void main(String[] args){
        new Main();
    }
    public static void storesToComp(MyList usedList, ArrayList<Store> nearBy){
        for (Store list:nearBy){
            cheapestList(usedList,list.getProductList());
        } 
    }
    public static double cheapestList(MyList myList, ArrayList<String> compWith){
        double sum=0;
        for (String product: myList.getProducts()) {

        ArrayList<Double> buildList = new ArrayList<>();
            sum =+ compare(product, compWith);

        }
        return sum;
        }


    public static double compare(String product, ArrayList<String> storeList){
        double price=0;
        for (String store:storeList) {
            if (store.equals(product)){
            price= Double.parseDouble(store.substring(store.indexOf("|")));
        }
        else price =+0;
        }
        return price;
    }
}
