package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_mainactivity);
        Button openSettings = (Button) findViewById(R.id.goToSettings_Button);
        openSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveView("settings");
                setContentView(R.layout.activity_settings);
            }
        });
        if(activeView.equals("settings")){
            setContentView(R.layout.activity_settings);

            View v;
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
                    setContentView(R.layout.activity_mainactivity);
                }
            });
        }
        else if(activeView.equals("main")){
            ArrayList<MyList> myLists = new ArrayList();
            domainFacade.getSavedLists(myLists);

            ListView listView = (ListView) findViewById(R.id.setStandardList_listView);
            ArrayAdapter adapter = new ArrayAdapter<MyList>(this,android.R.layout.simple_list_item_1, myLists);
            listView.setAdapter(adapter);
        }
    };
    public void setActiveView(String activeView){
        this.activeView = activeView;
    }
    public String getActiveView(){
        return activeView;
    }
}
