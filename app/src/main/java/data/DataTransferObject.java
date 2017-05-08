package data;

import android.view.GestureDetector;

import java.util.ArrayList;

/**
 * Created by Johan on 2017-05-04.
 */

public class DataTransferObject<E> {
    private String tag;
    private String operation;
    private ArrayList<E> values; //HashMap istället.

     public DataTransferObject(String tag, String operation){
         this.tag = tag;
         this.operation = operation;
         values = new ArrayList<E>();
     }
     public void setValue(ArrayList<E> values){
         this.values = values;
     }
     public void addValue(E value){
         values.add(value);
     }
     public ArrayList<E> getValue(){
         return values;
     }
}
