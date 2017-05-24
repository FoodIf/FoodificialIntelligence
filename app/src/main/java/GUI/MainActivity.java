package GUI;

import android.app.Activity;
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

import com.example.hannes.foodificialintelligence.R;

import MyAndroid.MyApplication;
import domainFacade.*;
import java.util.ArrayList;
import java.util.Arrays;

import domain.MyList;

/**
 * Created by Hannes on 2017-04-27.
 */

public class MainActivity extends Activity {
    private DomainFacade domainFacade;
    public MainActivity() {
        domainFacade = DomainFacade.getInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    /**
     * Hanterar navigeringsmenyn efter inlogg.
     */

        setContentView(R.layout.activity_mainactivity);

        Button openSettings = (Button) findViewById(R.id.goToSettings_Button);
                openSettings.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(v.getContext(), SettingsActivity.class);
                startActivityForResult(myIntent, 0);
        }
        });
        Button allLists = (Button) findViewById(R.id.myLists_Button);
                allLists.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent myIntent = new Intent(v.getContext(), MyListsActivity.class);
                startActivityForResult(myIntent, 0);
        }
        });

    }
}
