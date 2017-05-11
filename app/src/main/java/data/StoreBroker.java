package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class StoreBroker extends Broker {
    private String tag;
    private String file;
    private HashMap<String, String> storesList = new HashMap<>();


    public StoreBroker() {

    }
    @Override
    public DataTransferObject getAdress(DataTransferObject dto){
        String tag = "";
        switch(dto.getTag()){
            case "ica": searchDatabase(dto, "productsIcaMaxi.txt");
                break;
            case "coop": searchDatabase(dto, "productsCoop.txt");
                break;
            case "citygross": searchDatabase(dto, "productsCityGross.txt");
            }
            this.tag = tag;
        return dto;
    }
    @Override
    public DataTransferObject saveAdress(DataTransferObject dto){
        switch(dto.getTag()){
            case "ica": writeToFile(dto, "productsIcaMaxi.txt");
                break;
            case "coop": writeToFile(dto, "productsCoop.txt");
                break;
            case "citygross": writeToFile(dto, "productsCityGross.txt");
        }
        return dto;
    }
}
