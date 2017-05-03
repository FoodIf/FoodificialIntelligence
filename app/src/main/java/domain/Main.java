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
        //this.user = new User();
        this.storeList = new ArrayList<>();
        this.chainList = new ArrayList<>();
        this.products = new Products();

        storeList.add(new Store("Rogers Livs", "Pillesnoppvägen 1"));

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
    public static void storesToComp(){
      /*  for (Store nearbyStore:) {
            
        }*/
    }
    public static MyList cheapestList(MyList mylist, ArrayList<MyList> compWith){
      /*  for (int i = 0; i < compWith.size(); i++){
        MyList tempComp = compWith.get(i);
            int listsize = mylist.getProducts().size();
            for (int j =0; j < listsize; j++){
                String product = mylist.getProducts().get(j);
                for (int k =0; k < k;)
            }

        }*/
        return null; //cheapestList;
    }
    public static double compare(double price){

        return price;
    }
}
