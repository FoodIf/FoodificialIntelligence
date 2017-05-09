package data;

/**
 * Created by albin_000 on 2017-05-08.
 */

public class ProductBroker extends Broker {

    private DataTransferObject dto;
    private String tag = "product";
    private String file = "productList.txt";

    public ProductBroker(){
        //searchDatabase(this.dto, this.tag);
    }
    @Override
    public DataTransferObject getAdress(DataTransferObject dto){
        if(dto.getTag().equals("product")){
            searchDatabase(dto, file);
        }
        return dto;
    }
}
