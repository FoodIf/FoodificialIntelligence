package GUI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;
import java.util.Arrays;

import MyAndroid.MyApplication;
import domain.MyList;
import domainFacade.DomainFacade;

/**
 * Created by Hannes on 2017-05-24.
 */

public class MyListsActivity extends Activity{

    /**
     * Created by Hannes on 2017-04-27.
     */

        private DomainFacade domainFacade;
        private MyList mylist;
        public MyListsActivity() {
            domainFacade = DomainFacade.getInstance();
        }

        /**
         * onCreate håller reda på vilken vy som ska hanteras med variabeln activeView,
         * och skickar användaren vidare till respektive vy.
         *
         * @param savedInstanceState
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


            /**
             * Hanterar användarens samtliga listor. Dessa går att välja, ta bort eller
             * skapa en ny.
             */

            setContentView(R.layout.activity_mylists);


            ListView listView = (ListView) findViewById(R.id.myList_ListView);

            MyListAdapter adapter = new MyListAdapter(domainFacade, domainFacade.getSavedStringLists(), MyApplication.getContext());
            listView.setAdapter(adapter);

/*
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    //TODO sätt rätt lista som custom. Lättare att göra när vi vet att vi kan se listorna. - Hannes


                }
            });*/
            Button newList = (Button) findViewById(R.id.newList_Button);
            newList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context cont = MyListsActivity.this;
                    AlertDialog.Builder builder = new AlertDialog.Builder(cont);
                    builder.setTitle("Namn på lista");
                    final EditText input = new EditText(cont);
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            domainFacade.addSavedLists(input.getText().toString());
                            Intent myIntent = new Intent(MyListsActivity.this, NewListsActivity.class);
                            startActivityForResult(myIntent, 0);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            dialog.cancel();
                        }
                    });
                    builder.show();

                }
            });
        }






}
