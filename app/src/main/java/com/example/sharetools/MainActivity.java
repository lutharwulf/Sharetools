package com.example.sharetools;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import com.example.sharetools.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    boolean nightmode;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Contenu affichage
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        //Gestion du mode Light/Dark
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isNightModeEnabled = sharedPreferences.getBoolean("nightmode", false);

        // Appliquer le thème en fonction du choix
        if (isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        //On bind les boutons du menu de l'appli à un fragment.
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            //On compart le résultat obtenu lors de la selection du bouton pour retourner le bon fragment
            //Deux options sont possible des if / else_if et switch case. J'ai du utiliser les if car le switch nécessite des constantes pour effectuer la comparaison.
            if(item.getItemId() == R.id.homebotton_bottommenu){
                replaceFragment(new HomeFragment());
            }else if (item.getItemId() == R.id.searchbotton_bottommenu) {
                replaceFragment(new SearchFragment());
            }else if (item.getItemId() == R.id.addbotton_bottommenu) {
                replaceFragment(new AddTools());
                //startActivity(new Intent(MainActivity.this, SelectPictureFromGallery.class));
            }else if (item.getItemId() == R.id.groupsbotton_bottommenu) {
                replaceFragment(new GroupsFragment());
            }else if (item.getItemId() == R.id.chatbotton_bottommenu) {
                replaceFragment(new SettingsFragment());
            }
            /*
            //Si on réussi à faire en sorte d'obtenir des constantes pour les valeurs R.id.X, alors on pourra utiliser le switch.
            switch (item.getItemId()) {
                case R.id.homebotton_bottommenu:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.searchbotton_bottommenu:
                    replaceFragment(new SearchFragment());
                    break;
                case R.id.addbotton_bottommenu:
                    replaceFragment(new AddFragment());
                    break;
                case R.id.groupsbotton_bottommenu:
                    replaceFragment(new GroupsFragment());
                    break;
                case R.id.chatbotton_bottommenu:
                    replaceFragment(new ChatFragment());
                    break;
            }*/
            return true;
        });

        //ancien menu principale de l'application.
        /* Configuration statique des bouton login / inscription / testdb
        Button loginButton = findViewById(R.id.button_login);
        Button registerButton = findViewById(R.id.button_register);
        Button testdb_Button = findViewById(R.id.button_testDB);

        // Redirection vers la page de login
        loginButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, login.class)));

        // Redirection vers la page d'inscription
        registerButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Inscription.class)));

        // Redirection vers la page TestDB
        testdb_Button.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, testdb.class))); */
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}