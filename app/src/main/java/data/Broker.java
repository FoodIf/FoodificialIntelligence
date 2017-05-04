package data;

import java.util.HashMap;

import domain.Store;

/**
 * Created by albin_000 on 2017-05-04.
 */

public abstract class Broker<E> {

    private String tag;
    private E dto;

    public Broker(E dto, String tag) {
        this.dto = dto;
        this.tag = tag;

        HashMap<E, String> hashMap = new HashMap();
        hashMap.put(dto, tag);

        findClass(tag, dto);
    }

    public void findClass(String tag, E dto){
        if(tag.equals("store")){

            new StoreBroker(dto, tag);
        }
        else if(tag.equals("user")){

            new UserBroker(dto, tag);
        }
    }
    public String searchDatabase(E dto){
        String data = "";
        return data;
    }
}
