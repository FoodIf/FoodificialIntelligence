package data;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import MyAndroid.MyApplication;


/**
 * Created by albin_000 on 2017-05-04.
 */

public abstract class Broker {

    //TODO skapa hashmapen nedan sen när problem med scannern är löst
    private HashMap<String,DataTransferObject> cacheMap = null;//new HashMap<>();

    public Broker(){
    }
    /**
     * Sök i databasen efter input värde och skicka tillbaka en DTO med Arraylist över detalagret.
     * @param dto, file
     */
    public DataTransferObject searchDatabase(DataTransferObject dto, String file){
        ArrayList<String> databaseList = new ArrayList<>();
        MyApplication myapplication;
        try {
            myapplication=MyApplication.getInstance();
            Context context= myapplication.getContext();
            Scanner reader = new Scanner(context.getAssets().open(file));

            String dataRow;
            while(reader.hasNextLine()){
                databaseList.add(reader.nextLine());
            }
            reader.close();
            dto.setValues(databaseList);
            dto.setState("used");
            return dto;

        } catch(IOException e){
            e.getMessage();
        }
        return null;
    }
    public DataTransferObject writeToFile(DataTransferObject dto, String file){
        try {
            FileWriter writer = new FileWriter(new File(file), true);
            writer.write(dto.toString() + "\n");
            writer.close();
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
            //updateCache(dto);
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
    public abstract DataTransferObject getAdress(DataTransferObject dto);

    public DataTransferObject saveAdress(DataTransferObject dto) { return dto; }
    public boolean updateCache(DataTransferObject dto){
        this.cacheMap.put(dto.getTag(), dto);
        return true;
    }
    public DataTransferObject checkCache(String tag){
        if (cacheMap != null) {
            if (cacheMap.containsKey(tag)) {
                return cacheMap.get(tag);
            }
        }
        return null;
    }
}
