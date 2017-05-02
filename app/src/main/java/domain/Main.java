package domain;

import java.util.ArrayList;

/**
 * Created by olle_ on 2017-04-27.
 */

public class Main {
    private User user;
    private ArrayList<Store> storeList;

    public Main() {
        Store rogerLivs = new Store("Rogers Livs", "Pillesnoppvägen 1");
        storeList.add(rogerLivs);
    }
    public static void main(String[] args){
        new Main();

    }
}
