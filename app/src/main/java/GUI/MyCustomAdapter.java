package GUI;

/**
 * Created by Hannes on 2017-05-15.
 */

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

public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> productlist = new ArrayList<String>();
    private Context context;
    private DomainFacade domainFacade;

    public MyCustomAdapter(DomainFacade domainFacade, ArrayList<String> list, Context context) {
        this.productlist=list;
        this.domainFacade=domainFacade;
        this.context = context;
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

        Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                productlist = domainFacade.deleteproduct(position);//ta bort produkt från listan
                notifyDataSetChanged();
            }
        });

        return view;
    }
}