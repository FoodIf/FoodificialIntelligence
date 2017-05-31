package GUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
    EditText gasComp;

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
        gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
        gasComp.setText(Double.toString(domainFacade.getGasConsumption()));

        //Listview för StandardLista med tillhöra adapter för autocomplete
        final ListView standardListView = (ListView) findViewById(R.id.setStandardList_listView);
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

                addStandardItem.setText("");
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

                String temp = gasComp.getText().toString();
                gasConsumption = Double.parseDouble(temp);
                domainFacade.setGasConsumption(gasConsumption);

                if (standardList == null) {
                    domainFacade.setStandardList(null);
                } else if (standardList != null) {
                    domainFacade.setStandardList(standardList);
                }
                Context context = getApplicationContext();
                CharSequence text = "Inställningar sparade!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        Button clearButton = (Button) findViewById(R.id.clearStandardList_Button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                domainFacade.setGasConsumption(0);
                domainFacade.clearStandardList(standardList);

                Context context = getApplicationContext();
                CharSequence text = "Inställningar borttagna!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
