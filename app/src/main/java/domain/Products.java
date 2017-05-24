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

    public ArrayList<String> setProductList(ArrayList<String> productList, DataFacade dataFacade){
        Log.v("på plats", "i Products.setProductList, Fyll lista");

        String tag = "product";
        String operation = "load";
        productList = dataFacade.load(tag, operation);
        this.productList = productList;
        return this.productList;
    }
    public ArrayList<String> getProductList(ArrayList<String> productList, DataFacade dataFacade){
        if (productList == null) {
            productList = setProductList(productList, dataFacade);
            Log.v("på plats", "i Products.getProductList, if product = null, do....");
            return productList;
        }
        else {
            return productList;
        }
    }
}
