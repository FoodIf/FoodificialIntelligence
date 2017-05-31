package GUI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hannes.foodificialintelligence.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import MyAndroid.MyApplication;
import domainFacade.DomainFacade;

import static com.example.hannes.foodificialintelligence.R.layout.activity_check_list;

/**
 * Created by albin_000 on 2017-05-30.
 */

public class ChosenStoreActivity extends Activity {

    private DomainFacade domainFacade;
    private HashMap<String, ArrayList<String>> comparedLists;
    private ArrayList<String> storeProductList;
    private String key;


    public ChosenStoreActivity(){
        domainFacade = DomainFacade.getInstance();
        comparedLists = domainFacade.compareStores();
        key = domainFacade.getProductListKey();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_check_list);

        ListView listView = (ListView) findViewById(R.id.chosenStore_ListView);

        storeProductList = comparedLists.get(key);
        int size = storeProductList.size()-1;
        storeProductList.remove(size);

        MyComparedAdapter adapter = new MyComparedAdapter(domainFacade, storeProductList, MyApplication.getContext());
        listView.setAdapter(adapter);


        Button newList = (Button) findViewById(R.id.tostore);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(ChosenStoreActivity.this, StoreActivity.class);
                startActivityForResult(myIntent, 0);


            }
        });
    }

}
