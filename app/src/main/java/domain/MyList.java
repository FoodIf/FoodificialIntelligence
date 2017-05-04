package domain;

import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Created by Alexander Nilsson on 2017-04-27.
 */

public class MyList {
    private String name;
    private String date;
    private ArrayList <String> products;
    AutoCompleteTextView addProduct;



    public MyList(String name) {
        this.name = name;
        this.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    }
    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }
    public void addProducts(String selected) {
        this.products.add(selected);
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

}

