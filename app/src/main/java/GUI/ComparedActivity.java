package GUI;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import MyAndroid.MyApplication;
import domain.MyList;
import domainFacade.DomainFacade;

import static com.example.hannes.foodificialintelligence.R.layout.activity_compared;

/**
 * Created by Hannes on 2017-05-24.
 */

public class ComparedActivity extends Activity{

    private String activeView;
    private DomainFacade domainFacade;
    private HashMap<String, ArrayList<String>> comparedLists;
    private ChosenStoreActivity chosenStore;

    public ComparedActivity() {
        domainFacade = DomainFacade.getInstance();
        comparedLists = domainFacade.compareStores();
        chosenStore = new ChosenStoreActivity();

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_compared);

        ListView listView = (ListView) findViewById(R.id.compareList_ListView);

        MyComparedAdapter adapter = new MyComparedAdapter(domainFacade, domainFacade.storeBuilder(comparedLists), MyApplication.getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = (String) parent.getItemAtPosition(position);
                int pos = Arrays.asList(domainFacade.storeBuilder(comparedLists)).indexOf(selectedItem);
                Log.v("PRINTER: ", "VÄRDE " + comparedLists.get(selectedItem));
                Log.v("SIZE: ", "" + comparedLists.size());
                Log.v("SELECTED ITEM: ", "VÄRDE: " + selectedItem);

                chosenStore = new ChosenStoreActivity(comparedLists.get(selectedItem));
                Intent myIntent = new Intent(view.getContext(), ComparedActivity.class);
                startActivityForResult(myIntent, 0);


            }
        });
    }
}
