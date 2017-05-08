package data;

import java.util.ArrayList;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class StoreBroker<E> extends Broker {
    private E dto;
    private String tag;
    private String file;
    private ArrayList<String> storesList = new ArrayList<>();


    public StoreBroker(E dto, String tag) {
        super(dto, tag);
        this.dto = dto;
        this.tag = tag;


        String store1 = "productsIcaMaxi.txt";
        String store2 = "productsCityGross.txt";
        String store3 = "productsCoop.txt";
        addToStoresList(store1);
        addToStoresList(store2);
        addToStoresList(store3);

        getFile(this.tag);
        setFile(this.file);
        searchDatabase(this.dto, this.tag);
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
    /*public ArrayList<String> getStoresList(){
        return storesList;
    }
    public void setStoresList(ArrayList<String> storesList){
        this.storesList = storesList;
    }*/
    public ArrayList<String> addToStoresList(String store){
        for(int i = 0; i < storesList.size(); i++){
            if(storesList.get(i).equals(store)){
                System.out.print("The store already exists.");
            }
            else {
                storesList.add(store);
            }
        }
        return storesList;
    }
}
