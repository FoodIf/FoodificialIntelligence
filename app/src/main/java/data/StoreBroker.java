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
        String store1 = "productsIcaMaxi.txt";
        String store2 = "productsCityGross.txt";
        String store3 = "productsCoop.txt";
        String tag1 = "ica";
        String tag2 = "citygross";
        String tag3 = "coop";
        addToStoresList(store1, tag1);
        addToStoresList(store2, tag2);
        addToStoresList(store3, tag3);

        getFile(this.tag);
        //searchDatabase(this.dto, this.tag);
    }
    public String getFile(String tag){
        for(int i = 0; i < storesList.size(); i++){
            if(tag.contains(storesList.get(i))){
                this.file = storesList.get(i);
                return file;
            }
            else{
                return null;
            }
        }
        return null;
    }
    public void addToStoresList(String store, String tag){
        for(int i = 0; i < storesList.size(); i++){
            if(storesList.get(i).equals(store)){
                System.out.print("The store already exists.");
            }
            else { }
        }
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
