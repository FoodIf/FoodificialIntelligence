package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;
import java.util.Arrays;

import MyAndroid.MyApplication;
import domain.MyList;
import domainFacade.DomainFacade;

/**
 * Created by Hannes on 2017-05-24.
 */

public class NewListsActivity extends Activity {


    /**
     * Created by Hannes on 2017-04-27.
     */

        private DomainFacade domainFacade;
        private ArrayAdapter<String> adapter;
        private ArrayList<String> productAutoFill;

        public NewListsActivity() {
            domainFacade = DomainFacade.getInstance();
            productAutoFill = new ArrayList<>();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        /**
         * Hanterar skapandet av en ny lista, och visar vyn activity_addproducts.
         */

            setContentView(R.layout.activity_addproduct);

            TextView listName = (TextView) findViewById(R.id.listName);
            listName.setText(domainFacade.getListName());

            //productAutoFill = new ArrayList<>();
            productAutoFill = domainFacade.getProductList();

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productAutoFill);

            ArrayList<String> templist = new ArrayList<>();
            final AutoCompleteTextView productInput = (AutoCompleteTextView) findViewById(R.id.addProductNew_actv);
            ListView productList = (ListView) findViewById(R.id.addedProducts_ListView);
            productInput.setThreshold(2);
            productInput.setAdapter(adapter);
            productInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem = (String) parent.getItemAtPosition(position);
                    int pos = Arrays.asList(productAutoFill).indexOf(selectedItem);
                    domainFacade.addProduct(selectedItem);
                    productInput.setText("");
                }
            });
            String product = "";
            if(!productInput.getText().toString().isEmpty()) {
                product = productInput.getText().toString();
                templist.add(product);
            }

            ListView listView = (ListView) findViewById(R.id.myList_ListView);

            MyCustomAdapter adapter = new MyCustomAdapter(domainFacade, domainFacade.getCurrentStringList(), MyApplication.getContext());
            listView.setAdapter(adapter);

            Button compareList = (Button) findViewById(R.id.compareList_Button);

        /*
        Button compareList = (Button) findViewById(R.id.compareList_Button);
        compareList.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                comparedList = templist;
                setActiveView("compared");
                compared(templist);
            }
        });
    }

    public void compared(ArrayList<String> comparedList){

        /*productInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                productAutoFill.add(item.toString());
            }
        });*/
        }

}
