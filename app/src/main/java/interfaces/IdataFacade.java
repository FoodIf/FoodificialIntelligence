package interfaces;

import java.util.ArrayList;

/**
 * Created by Johan on 2017-05-09.
 */

public interface IdataFacade<E> {
    public ArrayList<E> load(String tag, String operation);
    public ArrayList<E> save(String tag, String operation, ArrayList<E> values);
    public ArrayList<E> remove(String tag, String operation, ArrayList<E> values);
}
