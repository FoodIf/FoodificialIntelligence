package GUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.MyList;
import domainFacade.DomainFacade;

/**
 * Created by Hannes on 2017-05-24.
 */

public class SettingsActivity extends Activity {


    /**
     * Created by Hannes on 2017-04-27.
     */

    private DomainFacade domainFacade;
    private ArrayList<String> productAutoFill;
    private ArrayList<String> standardList = new ArrayList<>();
    private double gasConsumption;

    public SettingsActivity() {
        domainFacade = DomainFacade.getInstance();
        productAutoFill = new ArrayList<>();
        standardList = domainFacade.getStandardList();
        gasConsumption = domainFacade.getGasConsumption();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        productAutoFill = domainFacade.getProductList();

        //Textview för att ställa in bensinförbrukning
        EditText gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
        Double tempdouble = 0.0;
        if (!gasComp.getText().toString().isEmpty()) {
            gasComp.setText(tempdouble.toString());
            tempdouble = Double.parseDouble(gasComp.getText().toString());
        }
        gasConsumption = tempdouble;

        ListView standardListView = (ListView) findViewById(R.id.setStandardList_listView);
        standardListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, standardList));
        //ArrayAdapter för standardlistan
        final AutoCompleteTextView addStandardItem = (AutoCompleteTextView) findViewById(R.id.addStandardProduct_actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, productAutoFill);
        addStandardItem.setThreshold(2);
        addStandardItem.setAdapter(adapter);
        /**
         * OnItemClick på förslagen tagna från productList.txt
         */
        addStandardItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                int pos = Arrays.asList(productAutoFill).indexOf(selectedItem);
                standardList.add(selectedItem);
                Context context = getApplicationContext();
                CharSequence text = selectedItem + " tillagd!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                addStandardItem.setText("");
                Log.v("ITEMCLICK SIZE ARRAY: " + standardList.size(), "HOLA SENOR");
            }
        });
        /*
         * Skicka in standardlistan och bensininställningar till User-objektet och
         * MyList-objektet och spara där.
         */
        Button save = (Button) findViewById(R.id.saveSettings_Button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gasConsumption <= 0) {
                    domainFacade.setGasConsumption(0);
                } else if (gasConsumption > 0) {
                    Log.v("SET GAS CONSUMPTION = " + gasConsumption, "TROLLOLOLOLOLOL");
                    domainFacade.setGasConsumption(gasConsumption);
                }
                if (standardList == null) {
                    domainFacade.setStandardList(null);
                } else if (standardList != null) {
                    Log.v("SET STANDARD SIZE = " + standardList.size(), "TROLLOLOLOLOLOL");
                    domainFacade.setStandardList(standardList);
                }
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
