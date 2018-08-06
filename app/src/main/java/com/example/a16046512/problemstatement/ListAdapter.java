package com.example.a16046512.problemstatement;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<List>{
    private ArrayList<List> module;
    private Context context;
    private ImageView iv;
    private TextView tv;

    public ListAdapter(Context context,int resource,ArrayList<List>object){
        super(context,resource,object);
        module = object;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv = (TextView) rowView.findViewById(R.id.tv);
        // Get the ImageView object
        iv = (ImageView) rowView.findViewById(R.id.iv);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        List currentModule = module.get(position);
        // Set the TextView to show the food

        tv.setText(currentModule.getTv());
        // Set the image to star or nostar accordingly
        Log.i("ttt",currentModule.getTv()+"");
        if (currentModule.getTv().toString().equals("Bio")) {
            iv.setImageResource(R.drawable.i);
        } else if(currentModule.getTv().toString().equals("Vaccination")) {
            iv.setImageResource(R.drawable.v);
        }else if(currentModule.getTv().toString().equals("Anniversary")) {
            iv.setImageResource(R.drawable.a);
        }else{
            iv.setImageResource(R.drawable.star);
        }


        // Return the nicely done up View to the ListView
        return rowView;
    }
}
