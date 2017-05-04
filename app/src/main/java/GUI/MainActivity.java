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

import java.util.ArrayList;

/**
 * Created by Hannes on 2017-04-27.
 */

public class MainActivity extends Activity {
    private String activeView;

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
            AutoCompleteTextView homeAdress = (AutoCompleteTextView) findViewById(R.id.setHomeAdress_actv);
            String adress = homeAdress.toString();

            EditText gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
            Double gasComsumption = Double.parseDouble(gasComp.toString());

            ArrayList<String> standardList = new ArrayList();

            Button save = (Button) findViewById(R.id.saveSettings_Button);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    spara uppgifter till user-klassen?
                     */
                    setActiveView("main");
                    setContentView(R.layout.activity_mainactivity);
                }
            });

        }
        else if(activeView.equals("main")){
            ArrayList<String> listList = new ArrayList();
            String list1 = "Lördagen den femte";
            String list2 = "Söndag och skit i det";
            String list3 = "Måndag hela veckan";

            listList.add(list1);
            listList.add(list2);
            listList.add(list3);

            ListView listView = (ListView) findViewById(R.id.setStandardList_listView);

            for(int i = 0; i < listList.size(); i++){
                //Kanske behövs parsa ArrayList till vanlig array.
                //listView.setAdapter(new ArrayAdapter<String>(Start.this, android.R.layout.simple_list_item_1, lv_arr)));
            }
        }
    };
    public void setActiveView(String activeView){
        this.activeView = activeView;
    }
    public String getActiveView(){
        return activeView;
    }
}
