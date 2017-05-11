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
    private HashMap<String,DataTransferObject> cacheMap;

    public Broker(){}
    /**
     * Sök i databasen efter input värde och skicka tillbaka en Arraylist över detalagret.
     * @param dto, tag
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
    public DataTransferObject save(DataTransferObject dto){
        checkTag(dto.getTag());

        return dto;
    }
    public DataTransferObject load(DataTransferObject dto){
        for(int i = 0; i < cacheMap.size(); i++){
            if(cacheMap.get(i).equals(dto)){
                return dto;
            }
            else{
                dto = getAdress(dto);
            }
        }
        return dto;
    }
    public DataTransferObject remove(DataTransferObject dto){
        checkTag(dto.getTag());
        return dto;
    }
    public boolean checkTag(String tag){
        if(tag.equals(getTag())){
            return true;
        }
        else{
            return false;
        }
    }
    public DataTransferObject getAdress(DataTransferObject dto){
        return dto;
    }
    public void setTag(String tag){
        this.tag = tag;
    }
    public String getTag(){
        return tag;
    }
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
