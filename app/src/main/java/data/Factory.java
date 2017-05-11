package data;

import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import interfaces.Ifactory;

/**
 * Created by Johan on 2017-05-04.
 */

public class Factory implements Ifactory{
    private Broker[] brokerList;
    private Broker userBroker;
    private Broker storeBroker;
    private Broker productBroker;

    public Factory(){
        userBroker = new UserBroker();
        storeBroker = new StoreBroker();
        productBroker = new ProductBroker();
        brokerList = new Broker[]{userBroker, storeBroker, productBroker};
    }
    @Override
    public DataTransferObject control(DataTransferObject dto){

        if(dto.getOperation().equals("load")){
            for(Broker broker : brokerList){
                dto = broker.load(dto);
                if(dto.getState().equals("used")) {
                    return dto;
                }
            }
        }else if(dto.getOperation().equals("save")){
            for(Broker broker : brokerList){
                dto = broker.save(dto);
                if(dto.getState().equals("used")) {
                    return dto;
                }
            }
        }else if(dto.getOperation().equals("remove")){
            for(Broker broker : brokerList){
                dto = broker.remove(dto);
                if(dto.getState().equals("used")){
                    return dto;
                }
            }
        }
        return null;
    }
}
