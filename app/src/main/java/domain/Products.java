package domain;

import GUI.MyCustomAdapter;
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

    public ArrayList<String> readProductList(){
        if(productList == null) {
            productList = new ArrayList();
            setProductList(productList);
            return productList;
        }
        else{
            getProductList();
            return productList;
        }
    }

    public void setProductList(ArrayList<String> productList){
        String tag = "product";
        String operation = "load";
        dataFacade.load(tag, operation);
        this.productList = productList;
    }
    public ArrayList<String> getProductList(){
        return productList;
    }
    public ArrayList<String> clearProductList(ArrayList<String> productList){
        productList.clear();
        return productList;
    }
}
