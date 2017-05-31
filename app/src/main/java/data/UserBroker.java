package data;

import android.util.Log;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class UserBroker extends Broker {

    private String file = "userList.txt";

    public UserBroker(){

    }
    @Override
    public DataTransferObject getAdress(DataTransferObject dto){
        switch(dto.getTag()) {
            case "user":
                dto = searchDatabase(dto, "userList.txt");
                break;
            case "userClass":
                dto = searchDatabaseObject(dto, "userClasses.dat");
                break;
        }
        return dto;
    }
    @Override
    public DataTransferObject saveAdress(DataTransferObject dto){
        switch(dto.getTag()){
            case "userClass":
                writeObjectToFile(dto, "userClasses.dat");
        }
        return dto;
    }
}
