package data;

import android.provider.ContactsContract;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import domain.Store;

/**
 * Created by albin_000 on 2017-05-04.
 */

public abstract class Broker {

    private String tag;
    private HashMap<String,DataTransferObject> cacheMap;

    public Broker(){}
    /**
     * Sök i databasen efter input värde och skicka tillbaka en Arraylist över detalagret.
     * @param dto, file
     */
    public DataTransferObject searchDatabase(DataTransferObject dto, String file){
        ArrayList<String> databaseList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String dataRow;
            while((dataRow = reader.readLine()) != null) {
                databaseList.add(dataRow);
            }
            dto.setValues(databaseList);
            return dto;
        } catch (IOException e){
            e.getMessage();
        }
        return null;
    }
    public DataTransferObject writeToFile(DataTransferObject dto, String file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(dto.toString() + "\n");
        } catch (IOException e){
            e.getMessage();
        }
            return dto;
    }
    public DataTransferObject save(DataTransferObject dto){
        updateCache(dto);
        saveAdress(dto);
        return dto;
    }
    public DataTransferObject load(DataTransferObject dto){
        if(cacheMap != null){
            for(int i = 0; i < cacheMap.size(); i++) {
                if (cacheMap.get(i).equals(dto)) {
                    return dto;
                }
            }
        }
        else{
            updateCache(dto);
            dto = getAdress(dto);
        }
        return dto;
    }
    public DataTransferObject remove(DataTransferObject dto){
        if(cacheMap != null){
            for(int i = 0; i < cacheMap.size(); i++){
                if(cacheMap.get(i).equals(dto)){
                    cacheMap.values().remove(dto);
                }
            }
        }
        return dto;
    }
    public DataTransferObject getAdress(DataTransferObject dto){
        return dto;
    }
    public DataTransferObject saveAdress(DataTransferObject dto) { return dto; }
    public boolean updateCache(DataTransferObject dto){
        this.cacheMap.put(dto.getTag(), dto);
        return true;
    }
    public DataTransferObject checkCache(String tag){
        if(cacheMap.containsKey(tag)) {
            return cacheMap.get(tag);
        }
        return null;
    }
}
