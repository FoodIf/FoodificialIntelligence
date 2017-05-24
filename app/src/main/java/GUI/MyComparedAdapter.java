package GUI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;

import domainFacade.DomainFacade;

/**
 * Created by Johan on 2017-05-22.
 */

public class MyComparedAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> productlist = new ArrayList<String>();
    private ArrayList<String> costlist = new ArrayList<String>();
    private Context context;
    private DomainFacade domainFacade;

    public MyComparedAdapter(DomainFacade domainFacade, ArrayList<String> list, Context context) {
        this.productlist=new ArrayList<String>();
        this.costlist=new ArrayList<String>();
        splitList(list);
        this.domainFacade=domainFacade;
        this.context = context;
    }

    public void splitList(ArrayList<String> list){
        for (int i =0;i<list.size();i++){
            String[] splitarray = list.get(i).split("\\|");
            productlist.add(splitarray[0]);
            costlist.add(splitarray[1]);
        }
    }

    @Override
    public int getCount() {
        return productlist.size();
    }

    @Override
    public Object getItem(int pos) {
        return productlist.get(pos);
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
            view = inflater.inflate(R.layout.customadapter, null);
        }

        TextView listItemText = (TextView)view.findViewById(R.id.productname);
        listItemText.setText(productlist.get(position));

        /*TextView listCostText = (TextView)view.findViewById(R.id.productcost);
        listCostText.setText(costlist.get(position));
*/
        return view;
    }
}
