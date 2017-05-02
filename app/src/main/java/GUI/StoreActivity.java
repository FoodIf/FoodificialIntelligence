package GUI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hannes.foodificialintelligence.R;

import org.w3c.dom.Text;

import domain.Store;

/**
 * Created by Hannes on 2017-05-02.
 */

public class StoreActivity extends Activity {
    private Store store;

    public StoreActivity(Store store) {
        this.store=store;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView nameView = (TextView) findViewById(R.id.store_name);
        nameView.setText("Implementeramedfacadestore.getname()");
        TextView addressView = (TextView) findViewById(R.id.store_name);
        addressView.setText("Implementeramedfacadestore.getaddress()");
        //TODO ImplementeraAvstånd
        //TODO ImplementeraKarta
        setContentView(R.layout.activity_store);


    };

}
