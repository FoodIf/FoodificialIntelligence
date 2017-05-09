package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import domain.Store;

/**
 * Created by albin_000 on 2017-05-04.
 */

public abstract class Broker {

    private String tag;
    private DataTransferObject dto;
    private String file;
    private HashMap<DataTransferObject, String> cacheMap;

    public Broker(){}
    public void setFile(String file){
        this.file = file;
    }
    /**
     * Sök i databasen efter input värde och skicka tillbaka aktuell rad.
     * @param dto, tag
     */
    /*public String searchDatabase(DataTransferObject dto, String tag){
        String input = dto.toString();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String dataRow;
            while((dataRow = reader.readLine()) != null){
                if(dataRow.contains(input)){
                    updateCache(dto, tag);
                    return dataRow;
                }
                else{
                    return null;
                }
            }
        } catch (IOException e){
            e.getMessage();
        }
        return null;
    }*/
    public DataTransferObject save(DataTransferObject dto){

    }
    public DataTransferObject load(DataTransferObject dto){

        for(int i = 0; i < cacheMap.size(); i++){

        }
    }
    public DataTransferObject remove(DataTransferObject dto){

    }
    public boolean updateCache(DataTransferObject dto, String tag){
        this.dto = dto;
        this.tag = tag;
        this.cacheMap.put(dto, tag);
        return true;
    }
    public DataTransferObject checkCache(String tag){
        if(cacheMap.containsKey(tag)) {
            return cacheMap.get(tag);
        }
        return null;
    }
}
