package dataFacade;

import data.DataTransferObject;
import data.Factory;
import domain.Main;

/**
 * Created by Johan on 2017-05-02.
 */

public class DataFacade<E> {
    private static final DataFacade instance = new DataFacade();
    private Main main;
    private DataTransferObject dto;

    private DataFacade(){
    }
    public static DataFacade getInstance(){
        return instance;
    }
    public E preformOperation(String tag, String operation){
        dto = new DataTransferObject(tag, operation);
        Factory<E> factory = new Factory<E>(dto);
        return factory.control();
    }
}
