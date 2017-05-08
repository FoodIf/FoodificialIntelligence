package data;

import java.util.HashMap;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class StoreBroker<E> extends Broker {
    private E dto;
    private String tag;


    public StoreBroker(E dto, String tag) {
        super(dto, tag);
        this.dto = dto;
        this.tag = tag;
        //setFile(this.file);
        searchDatabase(this.dto, this.tag);
    }
}
