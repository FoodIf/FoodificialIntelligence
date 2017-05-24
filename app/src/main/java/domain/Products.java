package domain;

import android.util.Log;

import dataFacade.DataFacade;
import java.util.ArrayList;

/**
 * Created by albin_000 on 2017-05-02.
 */

public class Products {

    private ArrayList<String> productList;
    private DataFacade dataFacade;

    public Products(){
        productList = new ArrayList<>();
    }

    public ArrayList<String> setProductList(ArrayList<String> productList){
        Log.v("på plats", "i Products.setProductLsit, Fyll lista");

        String tag = "product";
        String operation = "load";
        dataFacade.load(tag, operation);

        this.productList = productList;
        return this.productList;
    }
    public ArrayList<String> getProductList(){
        if (productList == null) {
            setProductList(productList);
            Log.v("på plats", "i Products.getProductLsit, if product = null, do....");
            return productList;
        }
        else {
            return productList;
        }


    }
}
