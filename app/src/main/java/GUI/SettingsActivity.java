package GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;
import java.util.Arrays;

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

    public SettingsActivity() {
        domainFacade = DomainFacade.getInstance();
        productAutoFill = new ArrayList<>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    /**
     * Hanterar användarens personliga inställningar. Visar vyn activity_settings.
     */

        setContentView(R.layout.activity_settings);
        if (productAutoFill != null) {
            domainFacade.getProductList();
        }

        //Textview för att ställa in bensinförbrukning
        EditText gasComp = (EditText) findViewById(R.id.gasConsumption_EditText);
        Double tempdouble = 0.0;
        if (!gasComp.getText().toString().isEmpty()) {
            tempdouble = Double.parseDouble(gasComp.getText().toString());
        }
        final Double gasConsumption = tempdouble;

        //ArrayAdapter för standardlistan
        final ArrayList<String> standardList = new ArrayList();
        AutoCompleteTextView addStandardItem = (AutoCompleteTextView) findViewById(R.id.addStandardProduct_actv);
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
                standardList.add(productAutoFill.get(pos));
            }
        });
        final String standardItem = addStandardItem.toString();
        standardList.add(standardItem);
        /*
         * Skicka in standardlistan och bensininställningar till User-objektet och
         * MyList-objektet och spara där.
         */
        Button save = (Button) findViewById(R.id.saveSettings_Button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gasConsumption == null) {
                    domainFacade.setGasConsumption(0);
                } else if (gasConsumption != null) {
                    domainFacade.setGasConsumption(gasConsumption);
                }
                if (standardList == null) {

                } else if (standardList != null) {
                    domainFacade.setStandardList(standardList);
                }
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
