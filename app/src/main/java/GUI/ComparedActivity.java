package GUI;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;
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


                //TODO sätt rätt lista som custom. Lättare att göra när vi vet att vi kan se listorna. - Hannes


            }
        });
    }
}
