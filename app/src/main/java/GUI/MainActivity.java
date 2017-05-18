package GUI;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
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

    public MainActivity() {
        if (activeView == null)
            activeView = "main";

        domainFacade = DomainFacade.getInstance();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (activeView.equals("main")) {
            mainactivityview();
        }
        if (activeView.equals("mylists")) {
            myListview();
        }
        //SETTINGS MENY OCH INSTÄLLNINGAR
        if (activeView.equals("settings")) {
            settingview();
        }
        //MYLIST SPECIFIK LISTA
        //TODO MyList plocka in aktuell lita, påbörjad lista.
        if (activeView.equals("activelist")) {

        }
    };

    public void setActiveView(String activeView) {
        this.activeView = activeView;
    }

    public String getActiveView() {
        return activeView;
    }

    public void myListview() {
        setContentView(R.layout.activity_mylists);

        ArrayList<String> list = new ArrayList<>();
        String pony1 = "pony1|hsd";
        String pony2 = "pony2|afdhga";
        String pony3 = "pony3|sadg";
        String pony4 = "pony4|sdga";
        String pony5 = "pony5|sjhg";
        String pony6 = "pony6|jsf";
        String pony7 = "pony7|sgjd";
        String pony8 = "pony8|sgfjsf";
        String pony9 = "pony9|sgfjs";
        String pony11 = "pony11|sgfjsg";
        String pony12 = "pony12|sfgjd";
        String pony20 = "pony20|fgjsad";

        list.add(pony1);
        list.add(pony2);
        list.add(pony3);
        list.add(pony4);
        list.add(pony5);
        list.add(pony6);
        list.add(pony7);
        list.add(pony8);
        list.add(pony9);
        list.add(pony11);
        list.add(pony12);
        list.add(pony20);

        ListView listView = (ListView) findViewById(R.id.myList_ListView);

        MyCustomAdapter adapter = new MyCustomAdapter(domainFacade, list, MyApplication.getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

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
        /**
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
    final Button activeList = (Button) findViewById(R.id.activeList_Button);
            activeList.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        setActiveView("activelist");
        setContentView(R.layout.activity_check_list);
    }
    });
}
}
