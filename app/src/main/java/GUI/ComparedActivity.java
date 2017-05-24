package GUI;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.hannes.foodificialintelligence.R;

import java.util.HashMap;

import MyAndroid.MyApplication;
import domain.MyList;
import domainFacade.DomainFacade;

import static com.example.hannes.foodificialintelligence.R.layout.activity_compared;

/**
 * Created by Hannes on 2017-05-24.
 */

public class ComparedActivity extends Activity{

    private String activeView;
    private DomainFacade domainFacade;
    private HashMap<String, MyList> comparedLists;

    public ComparedActivity(HashMap<String, MyList> comparedLists) {
        domainFacade = DomainFacade.getInstance();
        this.comparedLists = comparedLists;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_compared);

        ListView listView = (ListView) findViewById(R.id.myList_ListView);

        MyComparedAdapter adapter = new MyComparedAdapter(domainFacade, domainFacade.getSavedStringLists(), MyApplication.getContext());
        listView.setAdapter(adapter);
    }
}
