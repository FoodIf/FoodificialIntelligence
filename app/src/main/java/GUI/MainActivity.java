package GUI;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
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



            Button save = (Button) findViewById(R.id.saveSettings_Button);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
                    Double gasConsumption = Double.parseDouble(gasComp.toString());
                    domainFacade.setGasConsumption(gasConsumption);

                    ArrayList<String> standardList = new ArrayList();

                    setActiveView("main");
                    setContentView(R.layout.activity_mainactivity);
                }
            });

        }
        else if(activeView.equals("main")){
            ArrayList<String> listList = new ArrayList();
            String list1 = "Ett";
            String list2 = "Två";
            String list3 = "Tre";

            listList.add(list1);
            listList.add(list2);
            listList.add(list3);

            ListView listView = (ListView) findViewById(R.id.setStandardList_listView);
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listList);
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
