package com.example.sharetools;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class testdb extends AppCompatActivity {
    //private FirebaseAuth auth;
    private EditText Valuetoedit, valuetopast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testdb);

        Valuetoedit = findViewById(R.id.Valuetoedit);
        valuetopast = findViewById(R.id.valuetopast);
        Button sendbutton = findViewById(R.id.sendbutton);
        Button mainActivityButton = findViewById(R.id.MainActivityButton);

        //Interaction du bouton Login
        sendbutton.setOnClickListener(v -> {
            //On récupère email et mot de passe

            FirebaseDatabase database = FirebaseDatabase.getInstance("https://ussi26-dev-mobile-default-rtdb.europe-west1.firebasedatabase.app/");
            DatabaseReference myRef = database.getReference(String.valueOf(Valuetoedit));

            myRef.setValue(valuetopast);

        });


        // Redirection vers la page d'accueil
        mainActivityButton.setOnClickListener(view -> startActivity(new Intent(testdb.this, MainActivity.class)));
    }
}
