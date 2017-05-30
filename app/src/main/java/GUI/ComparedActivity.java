package GUI;
import android.app.Activity;
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

    public ComparedActivity() {
        domainFacade = DomainFacade.getInstance();
        comparedLists = domainFacade.compareStores();
        Log.v("DOMFACADE COMPSTORE", "SIZE: " + domainFacade.compareStores().size());

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_compared);

        ListView listView = (ListView) findViewById(R.id.compareList_ListView);

        //MyComparedAdapter adapter = new MyComparedAdapter(domainFacade, domainFacade.storeBuilder(comparedLists), MyApplication.getContext());
        //listView.setAdapter(adapter);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, domainFacade.storeBuilder(comparedLists)));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = (String) parent.getItemAtPosition(position);
                int pos = Arrays.asList(domainFacade.storeBuilder(comparedLists)).indexOf(selectedItem);

            }
        });
    }
}
