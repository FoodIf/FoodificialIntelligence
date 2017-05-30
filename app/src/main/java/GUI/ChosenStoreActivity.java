package GUI;

import android.app.Activity;
import android.os.Bundle;
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
    private ArrayList<String> storeList;

    public ChosenStoreActivity(){

    }
    public ChosenStoreActivity(ArrayList<String> storeList) {
        domainFacade = DomainFacade.getInstance();
        comparedLists = domainFacade.compareStores();
        this.storeList = storeList;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_check_list);

        ListView listView = (ListView) findViewById(R.id.chosenStore_ListView);

        MyComparedAdapter adapter = new MyComparedAdapter(domainFacade, storeList, MyApplication.getContext());
        listView.setAdapter(adapter);
    }

}
