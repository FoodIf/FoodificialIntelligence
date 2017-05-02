package domain;

import java.util.ArrayList;

/**
 * Created by olle_ on 2017-04-27.
 */

public class Main {
    private User user;
    private ArrayList<Store> storeList;
    private ArrayList<Chain> chainList;

    public Main() {
        //this.user = new User();
        this.storeList = new ArrayList<>();
        this.chainList = new ArrayList<>();

        storeList.add(new Store("Rogers Livs", "Pillesnoppvägen 1"));

        chainList.add(new Chain("Ica"));
        chainList.add(new Chain("Coop"));
        chainList.add(new Chain("Hemkop"));
    }

    public static void main(String[] args){
        new Main();

    }
}
