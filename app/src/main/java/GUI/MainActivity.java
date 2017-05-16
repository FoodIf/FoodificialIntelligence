package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hannes.foodificialintelligence.R;
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

    public MainActivity(){
        activeView = "main";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(activeView.equals("main")) {
            setContentView(R.layout.activity_mainactivity);
            ArrayList<String> list = new ArrayList<>();
            String pony1 = "pony1";
            String pony2 = "pony2";
            String pony3 = "pony3";
            String pony4 = "pony4";
            String pony5 = "pony5";
            String pony6 = "pony6";
            String pony7 = "pony7";
            String pony8 = "pony8";
            String pony9 = "pony9";
            String pony11 = "pony11";
            String pony12 = "pony12";
            String pony20 = "pony20";

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

            ListView listView = (ListView) findViewById(R.id.MyList_ListView);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

            Button openSettings = (Button) findViewById(R.id.goToSettings_Button);
            openSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setActiveView("settings");
                    setContentView(R.layout.activity_settings);
                }
            });
        }
        if(activeView.equals("settings")){
            setContentView(R.layout.activity_settings);

            //Textview för att ställa in bensinförbrukning
            EditText gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
            final Double gasConsumption = Double.parseDouble(gasComp.toString());

            //ArrayAdapter för standardlistan
            final ArrayList<String> standardList = new ArrayList();
            AutoCompleteTextView addStandardItem = (AutoCompleteTextView)findViewById(R.id.addStandardProduct_actv);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, standardList);
            addStandardItem.setThreshold(2);
            addStandardItem.setAdapter(adapter);
            final String standardItem = addStandardItem.toString();
            standardList.add(standardItem);
            /**
             * Skicka in standardlistan och bensininställningar till User-objektet och
             * MyList-objektet och spara där.
             */
            Button save = (Button) findViewById(R.id.saveSettings_Button);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*if(gasConsumption == null) {
                        domainFacade.setGasConsumption(0);
                    }
                    else if(gasConsumption != null){
                        domainFacade.setGasConsumption(gasConsumption);
                    }
                    if(standardList == null){

                    }
                    else if(standardList != null) {
                        domainFacade.setStandardList(standardList);
                    }*/
                    setActiveView("main");
                    setContentView(R.layout.activity_mainactivity);
                }
            });
        }
    };
    public void setActiveView(String activeView){
        this.activeView = activeView;
    }
    public String getActiveView(){
        return activeView;
    }
}
