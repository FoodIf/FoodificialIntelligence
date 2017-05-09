package data;

/**
 * Created by albin_000 on 2017-05-08.
 */

public class ProductBroker extends Broker {

    //private DataTransferObject dto;
    private String tag = "product";
    private String file = "productList.txt";

    public ProductBroker(){
        setFile(this.file);
        //searchDatabase(this.dto, this.tag);
    }
}
