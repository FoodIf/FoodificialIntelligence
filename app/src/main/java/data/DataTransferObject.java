package data;


import java.util.ArrayList;

/**
 * Created by Johan on 2017-05-04.
 */

/**
 * Dto-mönster. En klass som håller i och transportera olika data vilka ska laddas och sparas.
 * @param <E>
 */
public class DataTransferObject<E> {
    private String tag;
    private String operation;
    private String state;
    private ArrayList<E> values;

    public DataTransferObject(String tag, String operation){
        this.tag = tag;
        this.operation = operation;
        values = new ArrayList<E>();
        state = "unused";
    }
    public String getOperation(){
        return operation;
    }
    public String getTag(){
        return tag;
    }
    public String getState(){
        return state;
    }
    public void setValues(ArrayList<E> values){
        this.values = values;
    }
    public void setState(String state){
        this.state = state;
    }
    public void addValue(E value){
        values.add(value);
    }
    public ArrayList<E> getValues(){
        return values;
    }
}
