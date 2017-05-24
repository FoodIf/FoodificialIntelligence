package GUI;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.hannes.foodificialintelligence.R;

import java.util.ArrayList;

import domain.MyList;
import domainFacade.DomainFacade;

    /**
     * Created by Hannes on 2017-05-19.
     */

    public class MyListAdapter extends BaseAdapter implements ListAdapter {

        private ArrayList<String> listName = new ArrayList<String>();

        private Context context;
        private DomainFacade domainFacade;

        public MyListAdapter(DomainFacade domainFacade, ArrayList<String> list, Context context) {
            this.listName=list;
            this.domainFacade=domainFacade;
            this.context = context;
        }


        @Override
        public int getCount() {
            return listName.size();
        }

        @Override
        public Object getItem(int pos) {
            return listName.get(pos);
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

            TextView listItemText = (TextView)view.findViewById(R.id.listName);
            listItemText.setText(listName.get(position));

            listItemText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    domainFacade.setCurrentList(position);
                    Intent i = new Intent(v.getContext(), NewListsActivity.class);
                    context.startActivity(i);
                }
            });

            Button deleteBtn = (Button)view.findViewById(R.id.delete_btn);

            deleteBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listName = domainFacade.deleteList(position);
                    notifyDataSetChanged();
                }
            });

            return view;
        }


    }
