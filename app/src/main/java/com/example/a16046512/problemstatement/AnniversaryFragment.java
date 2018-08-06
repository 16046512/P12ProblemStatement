package com.example.a16046512.problemstatement;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnniversaryFragment extends Fragment {
    private Button btnedit;
    private TextView display1;
    private LinearLayout ll2;
    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anniversary, container, false);
        btnedit = (Button)view.findViewById(R.id.btnedit3);
        display1 = (TextView)view.findViewById(R.id.display3);
        ll2 = (LinearLayout)view.findViewById(R.id.ll2);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String txt1 = prefs.getString("txt3","");
        display1.setText(txt1);

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.showdialog, null);
                final EditText etDialog1 = (EditText) ll.findViewById(R.id.etDialog1);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(ll)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                display1.setText(etDialog1.getText().toString());
                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("txt3", etDialog1.getText().toString());
                                editor.commit();
                            }
                        });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
