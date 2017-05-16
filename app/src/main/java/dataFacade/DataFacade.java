package dataFacade;

import java.util.ArrayList;

import data.DataTransferObject;
import data.Factory;
import domain.Main;
import domain.User;
import interfaces.IdataFacade;

/**
 * Created by Johan on 2017-05-02.
 */

public class DataFacade<E> implements IdataFacade<E>{
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
    @Override
    public ArrayList<E> load(String tag, String operation){
        dto = new DataTransferObject(tag, operation);
        dto = factory.control(dto);
        return dto.getValues();
    }
    @Override
    public ArrayList<E> save(String tag, String operation, ArrayList<E> values){
        dto = new DataTransferObject(tag, operation);
        dto.setValues(values);
        dto = factory.control(dto);
        return dto.getValues();
    }
    @Override
    public ArrayList<E> remove(String tag, String operation, ArrayList<E> values){
        dto = factory.control(new DataTransferObject(tag, operation));
        dto.setValues(values);
        return dto.getValues();
    }
}
