package domain;


import java.util.ArrayList;

/**
 * Created by Alexander Nilsson on 2017-04-27.
 */

public class MyList {
    private ArrayList <String> products;
    public MyList() {
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }
    public void addProducts(String selected) {
        this.products.add(selected);
    }
}

