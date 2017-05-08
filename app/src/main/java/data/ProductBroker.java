package data;

/**
 * Created by albin_000 on 2017-05-08.
 */

public class ProductBroker<E> extends Broker {

    private E dto;
    private String tag;
    private String file = "productList.txt";

    public ProductBroker(E dto, String tag){
        super(dto, tag);
        this.dto = dto;
        this.tag = tag;
        setFile(this.file);
        searchDatabase(this.dto, this.tag);
    }
}
