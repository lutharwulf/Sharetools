package com.example.sharetools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inscription extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText emailRegister, passwordRegister;
    private Button loginButton, registerButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();

        emailRegister = findViewById(R.id.emailRegister);
        passwordRegister = findViewById(R.id.passwordRegister);
        registerButton = findViewById(R.id.registerButton);

        //Interaction du bouton S'inscrire
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //On récupère email et mot de passe
                String user = emailRegister.getText().toString().trim();
                String pass = passwordRegister.getText().toString().trim();

                //On vérifie que le champ email soit non-vide
                if (user.isEmpty()){
                    emailRegister.setError("Email cannot be empty");
                }
                //On test si le champ mot de passe est vide, sinon on enregistre l'utilisateur
                if (pass.isEmpty()){
                    passwordRegister.setError("Password cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Inscription.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Inscription.this, login.class));
                            } else {
                                Toast.makeText(Inscription.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
