package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;

import MyAndroid.MyApplication;
import domainFacade.DomainFacade;

import static com.example.hannes.foodificialintelligence.R.layout.activity_compared;

/**
 * Created by Alexander Nilsson on 2017-05-29.
 */

public class ComparedProductsActvity extends Activity{
    private DomainFacade domainFacade;
    private ArrayList<String> current;
    public ComparedProductsActvity() {
        domainFacade = DomainFacade.getInstance();
        current = domainFacade.getCurrentStringList();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_compared);

        ListView listView = (ListView) findViewById(R.id.myList_ListView);

        MyComparedAdapter adapter = new MyComparedAdapter(domainFacade, domainFacade.getSavedStringLists(), MyApplication.getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //TODO sätt rätt lista som custom. Lättare att göra när vi vet att vi kan se listorna. - Hannes


            }
        });
}}
