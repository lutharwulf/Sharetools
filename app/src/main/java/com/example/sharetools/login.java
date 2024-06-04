package com.example.sharetools;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sharetools.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class login extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText emailLogin, passwordLogin;
    private Button loginButton, registerButton;
    ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            //Toast.makeText(login.this, "User not null", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        } else {
            emailLogin = findViewById(R.id.emailEditText);
            passwordLogin = findViewById(R.id.passwordEditText);
            loginButton = findViewById(R.id.loginButton);
            registerButton = findViewById(R.id.registerButton);

            //Interaction du bouton Login
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //On récupère email et mot de passe
                    String email = emailLogin.getText().toString();
                    String pass = passwordLogin.getText().toString();

                    //On vérifie que le champ email soit non-vide et qu'il sagit d'un email correct
                    if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        //On vérifie que le champ mot de passe ne soit pas vide
                        if (!pass.isEmpty()) {
                            //On initialise la connexion firebase
                            mAuth.signInWithEmailAndPassword(email, pass)
                                    //Si on réussi, on redirige vers la page d'accueil
                                    .addOnSuccessListener(authResult -> {
                                        Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login.this, MainActivity.class));
                                        finish();
                                    }).addOnFailureListener(e -> Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show());
                        } else {
                            passwordLogin.setError("Empty fields are not allowed");
                        }
                    } else if (email.isEmpty()) {
                        emailLogin.setError("Empty fields are not allowed");
                    } else {
                        emailLogin.setError("Please enter correct email");
                    }
                }
            });

            // Redirection vers la page d'inscription
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(login.this, Inscription.class));
                }
            });
        }

    }
}