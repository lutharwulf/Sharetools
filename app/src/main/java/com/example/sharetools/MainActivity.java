package com.example.sharetools;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import com.example.sharetools.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    boolean nightmode;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user!=null){
                    //Contenu affichage
                    binding = ActivityMainBinding.inflate(getLayoutInflater());
                    setContentView(binding.getRoot());

                    replaceFragment(new HomeFragment());
                    binding.bottomNavigationView.setBackground(null);
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

                        return true;
                    });
                }
                else{
                    startActivity(new Intent(MainActivity.this, login.class));
                }
            }
        };

        //Gestion du mode Light/Dark
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isNightModeEnabled = sharedPreferences.getBoolean("nightmode", false);

        // Appliquer le thème en fonction du choix
        if (isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}