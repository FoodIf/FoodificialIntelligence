package data;

/**
 * Created by albin_000 on 2017-05-08.
 */

public class ProductBroker extends Broker {

    private String file = "productList.txt";

    public ProductBroker(){
    }
    @Override
    public DataTransferObject getAdress(DataTransferObject dto){
        if(dto.getTag().equals("product")){
            dto = searchDatabase(dto, file);
        }
        return dto;
    }
    @Override
    public DataTransferObject saveAdress(DataTransferObject dto){
        writeToFile(dto, file);
        return dto;
    }
}
