package data;

/**
 * Created by albin_000 on 2017-05-04.
 */

public class UserBroker<E> extends Broker {

    private E dto;
    private String tag;

    public UserBroker(E dto, String tag){
        super(dto, tag);
        this.dto = dto;
        this.tag = tag;
    }
    @Override
    public String searchDatabase(E dto){
        String data = dto.toString();

        return data;
    }
}
