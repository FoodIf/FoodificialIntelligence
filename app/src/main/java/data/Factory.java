package data;

import android.provider.ContactsContract;

/**
 * Created by Johan on 2017-05-04.
 */

public class Factory<E> {
    private DataTransferObject<E> dto;

    public Factory(DataTransferObject<E> dto){
        this.dto = dto;
    }
    public E control(){

    }
}
