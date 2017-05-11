package data;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class UserBroker extends Broker {

    private String file = "userList.txt";

    public UserBroker(){

    }
    @Override
    public DataTransferObject getAdress(DataTransferObject dto){
        if(dto.getTag().equals("product")){
            searchDatabase(dto, file);
        }
        return dto;
    }
    @Override
    public DataTransferObject saveAdress(DataTransferObject dto){
        writeToFile(dto, file);
        return dto;
    }
}
