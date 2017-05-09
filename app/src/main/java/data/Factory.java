package data;

import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by Johan on 2017-05-04.
 */

public class Factory {
    private Broker[] brokerList;
    private Broker userBroker;

    public Factory(){
        userBroker = new UserBroker();
        brokerList = new Broker[]{userBroker};
    }
    public DataTransferObject control(DataTransferObject dto){
        if(dto.getOperation().equals("load")){
            for(Broker broker : brokerList){
                return broker.load(dto);
            }
        }else if(dto.getOperation().equals("save")){
            for(Broker broker : brokerList){
                return broker.save(dto);
            }
        }else if(dto.getOperation().equals("remove")){
            for(Broker broker : brokerList){
                return broker.remove(dto);
            }
        }else{
            return null;
        }
    }
}
