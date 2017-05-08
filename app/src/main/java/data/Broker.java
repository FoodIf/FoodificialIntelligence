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

public abstract class Broker<E> {

    private String tag;
    private E dto;
    private String file;

    public Broker(E dto, String tag) {
        this.dto = dto;
        this.tag = tag;

        /*HashMap<E, String> hashMap = new HashMap();
        hashMap.put(dto, tag);*/
    }
    public void setFile(String file){
        this.file = file;
    }
    /**
     * Sök i databasen efter input värde och skicka tillbaka aktuell rad.
     * @param dto, tag
     */
    public String searchDatabase(E dto, String tag){
        String input = dto.toString();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String dataRow;
            while((dataRow = reader.readLine()) != null){
                if(dataRow.contains(input)){
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
    }
}
