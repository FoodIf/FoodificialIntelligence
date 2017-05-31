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

/**
 * Facade-mönstret. Hanterar all kommunikation mellan datalagret och domänlagret, vilket gör det
 * enkelt att byta ut exempelvis datalagret.
 *
 * Mediator-mönstret. De olika klasserna i domänlagret och datalagret kommunicerar med varandra via facade-klassen,
 * vilket gör att den fungerar som en mediator. klasserna som pratar med varandra känner endast till fasaden.
 *
 * Singleton-mönstret. Klassen kan inte initialiseras mer än en gång och initialiseringen sker när applikationen startas.
 * @param <E>
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
    public ArrayList<E> save(String tag, String operation, ArrayList<User> values){
        dto = new DataTransferObject(tag, operation);

        dto.setValues(values);
        dto = factory.control(dto);
        return null;
    }
    @Override
    public ArrayList<E> remove(String tag, String operation, ArrayList<E> values){
        dto = factory.control(new DataTransferObject(tag, operation));
        dto.setValues(values);
        return dto.getValues();
    }
}
