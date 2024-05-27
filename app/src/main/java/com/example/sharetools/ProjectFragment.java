package com.example.sharetools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProjectFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projet, container, false);

        //Réaction au bouton add tools
        Button buttonAddTool = view.findViewById(R.id.buttonAddproject);
        buttonAddTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new AddProjectFragment()); // Remplacer "SuiviFragment" par le nom de votre fragment de destination
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}