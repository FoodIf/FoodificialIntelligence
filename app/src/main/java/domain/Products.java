package domain;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by albin_000 on 2017-05-02.
 */

public class Products {

    private ArrayList<String> productList;

    public Products(){

    }

    public void readProductList(){
        if(productList == null) {
            productList = new ArrayList();
            setProductList(productList);
        }
        else{
            clearProductList(productList);
        }
    }

    public void setProductList(ArrayList<String> productList){
        try {
            BufferedReader in = new BufferedReader(new FileReader("productList.txt"));
            String productRow;
            while ((productRow = in.readLine()) != null) {
                productList.add(productRow);
                for (int i = 0; i < productList.size(); i++) {
                    System.out.print(productList.get(i));
                }
            }
            in.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public ArrayList<String> getProductList(){
        return productList;
    }
    public ArrayList<String> clearProductList(ArrayList<String> productList){
        productList.clear();
        return productList;
    }
}
