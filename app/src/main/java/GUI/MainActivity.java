package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hannes.foodificialintelligence.R;

import MyAndroid.MyApplication;
import domainFacade.*;
import java.util.ArrayList;

import domain.MyList;

/**
 * Created by Hannes on 2017-04-27.
 */

public class MainActivity extends Activity {
    private String activeView;
    private DomainFacade domainFacade;
    private MyList mylist;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> tempList;

    public MainActivity() {
        if (activeView == null)
            activeView = "main";

        domainFacade = DomainFacade.getInstance();
        tempList = new ArrayList<>();

    }

    /**
     * onCreate håller reda på vilken vy som ska hanteras med variabeln activeView,
     * och skickar användaren vidare till respektive vy.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (activeView.equals("main")) {
            mainactivityview();
        }
        if (activeView.equals("mylists")) {
            myListview();
        }
        if (activeView.equals("settings")) {
            settingview();
        }
        if (activeView.equals("newlist")) {
            newListView();
        }
    };

    public void setActiveView(String activeView) {
        this.activeView = activeView;
    }

    public String getActiveView() {
        return activeView;
    }

    /**
     * Hanterar användarens samtliga listor. Dessa går att välja, ta bort eller
     * skapa en ny.
     */
    public void myListview() {
        setContentView(R.layout.activity_mylists);
        Button newList = (Button) findViewById(R.id.newList_Button);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveView("newlist");
                newListView();
            }
        });

        ListView listView = (ListView) findViewById(R.id.myList_ListView);

        MyListAdapter adapter = new MyListAdapter(domainFacade, domainFacade.getSavedStringLists(), MyApplication.getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    /**
     * Hanterar skapandet av en ny lista, och visar vyn activity_addproducts.
     */
    public void newListView(){
        setContentView(R.layout.activity_addproducts);

        //tempList = new ArrayList<>();
        tempList = domainFacade.getProductList();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tempList);

        ArrayList<String> templist = new ArrayList<>();
        AutoCompleteTextView productInput = (AutoCompleteTextView) findViewById(R.id.addProduct_actv);
        ListView productList = (ListView) findViewById(R.id.addedProducts_ListView);
        productInput.setThreshold(2);
        productInput.setAdapter(adapter);

        productInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                tempList.add(item.toString());
            }
        });
    }

    /**
     * Hanterar användarens personliga inställningar. Visar vyn activity_settings.
     */
    public void settingview() {
        setContentView(R.layout.activity_settings);

        //Textview för att ställa in bensinförbrukning
        EditText gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
        Double tempdouble=0.0;
        if(!gasComp.getText().toString().isEmpty()){
        tempdouble=Double.parseDouble(gasComp.getText().toString());
        }
        final Double gasConsumption = tempdouble;

        //ArrayAdapter för standardlistan
        final ArrayList<String> standardList = new ArrayList();
        AutoCompleteTextView addStandardItem = (AutoCompleteTextView) findViewById(R.id.addStandardProduct_actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, standardList);
        addStandardItem.setThreshold(2);
        addStandardItem.setAdapter(adapter);
        final String standardItem = addStandardItem.toString();
        standardList.add(standardItem);
        /*
         * Skicka in standardlistan och bensininställningar till User-objektet och
         * MyList-objektet och spara där.
         */
        Button save = (Button) findViewById(R.id.saveSettings_Button);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                    if(gasConsumption == null) {
                        domainFacade.setGasConsumption(0);
                    }
                    else if(gasConsumption != null){
                        domainFacade.setGasConsumption(gasConsumption);
                    }
                    if(standardList == null){

                    }
                    else if(standardList != null) {
                        domainFacade.setStandardList(standardList);
                    }
                setActiveView("main");
                mainactivityview();
            }
        });
    }

    /**
     * Hanterar navigeringsmenyn efter inlogg.
     */
    public void mainactivityview(){
        setContentView(R.layout.activity_mainactivity);

        Button openSettings = (Button) findViewById(R.id.goToSettings_Button);
                openSettings.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
            setActiveView("settings");
            settingview();
        }
        });
        Button allLists = (Button) findViewById(R.id.myLists_Button);
                allLists.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
            setActiveView("mylists");
            myListview();

        }
        });

    }
}
