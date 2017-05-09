package dataFacade;

import java.util.ArrayList;

import data.DataTransferObject;
import data.Factory;
import domain.Main;

/**
 * Created by Johan on 2017-05-02.
 */

public class DataFacade<E> {
    private static final DataFacade instance = new DataFacade();
    private Main main;
    private Factory factory;
    private DataTransferObject dto;

    private DataFacade(){
        factory = new Factory();
    }
    public static DataFacade getInstance(){
        return instance;
    }
    public ArrayList<E> load(String tag, String operation){
        dto = factory.control(new DataTransferObject(tag, operation));
        return factory.control(dto).getValues();
    }
    public ArrayList<E> save(String tag, String operation, ArrayList<E> values){
        dto = factory.control(new DataTransferObject(tag, operation));
        dto.setValues(values);
        return factory.control(dto).getValues();
    }
    public ArrayList<E> remove(String tag, String operation, ArrayList<E> values){
        dto = factory.control(new DataTransferObject(tag, operation));
        dto.setValues(values);
        return factory.control(dto).getValues();
    }

}
