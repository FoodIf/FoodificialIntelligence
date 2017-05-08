package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alexander Nilsson on 2017-05-08.
 */

public class Cashe {
    private HashMap<String,ArrayList<String>> cashMap;

    public Cashe() {
        cashMap = new HashMap<String,ArrayList<String>>();
    }
    public boolean updateCash(ArrayList<String> list, String tag){
        cashMap.put(tag, list);
        return true;
    }
    public ArrayList<String> checkCashe(String tag){
        if(cashMap.containsKey(tag)) {
            return cashMap.get(tag);
        }
    return null;
    }
}
