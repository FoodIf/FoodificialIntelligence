package domain;


import java.util.ArrayList;

/**
 * Created by Alexander Nilsson on 2017-04-27.
 */

public class MyList {
    private ArrayList <String> products;
    public MyList(ArrayList<String> products) {
        this.products = products;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }
}

