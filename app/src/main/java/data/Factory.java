package data;

import android.provider.ContactsContract;

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
        }
        return null;
    }
}
