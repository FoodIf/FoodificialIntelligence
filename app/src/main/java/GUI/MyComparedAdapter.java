package GUI;

import android.content.Context;
import android.util.Log;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;

import domainFacade.DomainFacade;

/**
 * Created by Johan on 2017-05-22.
 */

/**
 * Decorator-mönstret. Adapter-klassen bygger ut grundklassen med fler dekorativa funktionaliteter.
 * I vårt fall finns funktionalitet för en vanlig lista i standardklassen adaptern medför fler
 * kolumner och knappar till listan.
 */
public class MyComparedAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> nameList;
    private ArrayList<String> priceList;
    private Context context;
    private DomainFacade domainFacade;
    private String[] storeList;

    public MyComparedAdapter(DomainFacade domainFacade, ArrayList<String> list, Context context) {
        this.nameList =new ArrayList<String>();
        Log.v("ARRAYSIZE: ", list.size() + "STRL");

        this.priceList =new ArrayList<String>();
        Log.v("ARRAYSIZE: ", list + "CONTENT");

        splitList(list);
        this.domainFacade=domainFacade;
        this.context = context;
    }
    public void splitList(ArrayList<String> list){
        for (int i =0;i<list.size();i++){
            String[] splitarray = list.get(i).split("\\|");
            nameList.add(splitarray[0]);
            priceList.add(splitarray[1]);
        }
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int pos) {
        return nameList.get(pos);
    }

    @Override
    public long getItemId(int position) {
        return 0;  //oklart vad som ska va med här.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.mycomparedadapter, null);
        }

        TextView listItemText = (TextView)view.findViewById(R.id.productname);
        listItemText.setText(nameList.get(position));

        TextView listCostText = (TextView)view.findViewById(R.id.price);
        listCostText.setText(priceList.get(position));
    /*    listItemText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), ChosenStoreActivity.class);
                // TODO skapa getComparedList i domainfacade för att få tag i listan

              //  i.putExtra("lista",); //domainFacade.getComparedList(nameList.get(position)));
                context.startActivity(i);
            }
        });*/

        return view;
    }
}
