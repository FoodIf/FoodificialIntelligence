package domain;

import dataFacade.DataFacade;
import java.util.ArrayList;

/**
 * Created by albin_000 on 2017-05-02.
 */

public class Products {

    private ArrayList<String> productList;
    private DataFacade dataFacade;

    public Products(){

    }

    public ArrayList<String> setProductList(ArrayList<String> productList){
        this.productList = new ArrayList<>();

        String tag = "product";
        String operation = "load";
        dataFacade.load(tag, operation);

        this.productList = productList;
        return this.productList;
    }
    public ArrayList<String> getProductList(){
        /*if (productList == null) {
            setProductList(productList);
            return productList;
        }
        else {
            return productList;
        }*/


    }
}
