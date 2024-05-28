package com.example.sharetools;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AddTools extends Fragment {
    // creating variables for
    // EditText and buttons.
    private EditText nom_outils, descr_outils, Date_ajout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crea_tool, container, false);
        // Inflate the layout for this fragment

        Button buttonCreate = view.findViewById(R.id.buttonCreate);

        // initializing our edittext and button
        nom_outils = view.findViewById(R.id.editTextGroupName);
        descr_outils = view.findViewById(R.id.editTextDescription);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = nom_outils.getText().toString();
                String descr = descr_outils.getText().toString();
                //Date date = Date_ajout.getText().toDate();

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(descr)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(getContext(), "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    DatabaseManager.addDatatoFirebase(name, descr);
                    //Toast.makeText(getContext(), name+" "+descr, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
