package com.example.sharetools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Réaction au bouton suivi
        Button boutonSuivi = view.findViewById(R.id.Button_Home_suivi);
        boutonSuivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new SuiviFragment()); // Remplacer "SuiviFragment" par le nom de votre fragment de destination
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        //Bouton Favoris
        Button boutonFavoris = view.findViewById(R.id.Button_Home_favoris);
        boutonFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new FavorisFragment()); // Remplacer "SuiviFragment" par le nom de votre fragment de destination
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        //Bouton MyTools
        Button boutonMyTools = view.findViewById(R.id.Button_Home_MyTools);
        boutonMyTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new MyToolsFragment()); // Remplacer "SuiviFragment" par le nom de votre fragment de destination
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        //Bouton projects
        Button boutonprojects = view.findViewById(R.id.Button_Home_projects);
        boutonprojects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new ProjectFragment()); // Remplacer "SuiviFragment" par le nom de votre fragment de destination
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
    /*
    Button loginButton = findViewById(R.id.button_login);
    Button registerButton = findViewById(R.id.button_register);
    Button testdb_Button = findViewById(R.id.button_testDB);

    // Redirection vers la page de login
        loginButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, login.class)));

    // Redirection vers la page d'inscription
        registerButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Inscription.class)));

    // Redirection vers la page TestDB
        testdb_Button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, testdb.class)));*/
}