package domain;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by albin_000 on 2017-05-02.
 */

public class Products {
    public void readProductList{
        try {
            FileReader file = new FileReader("productlist.txt");
        } catch(IOException e){
            e.getMessage();
        }
        while(file.hasNextLine()){

        }
    }
}
