package com.example.nyeste_reka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText loginUsername, loginPassword;
    private Button loginButton;
    private TextView registerUserTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.loginIdEditUsername);
        loginPassword = findViewById(R.id.idLoginEditPassword);
        registerUserTextView = findViewById(R.id.idNewUser);
        loginButton = findViewById(R.id.idLoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkUsername() | !checkPassword()){

                } else{
                    checkUser();
                }
            }
        });
        registerUserTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean checkUsername(){
        String value = loginUsername.getText().toString();
        if (value.isEmpty()){
            loginUsername.setError("A felhasználónév kötelező!");
            return false;
        } else{
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean checkPassword(){
        String value = loginPassword.getText().toString();
        if (value.isEmpty()){
            loginPassword.setError("A jelszó kötelező!");
            return false;
        } else{
            loginPassword.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String user = loginUsername.getText().toString().trim();
        String passw = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(user);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwFromDB = snapshot.child(user).child("password").getValue(String.class);

                    if (passwFromDB.equals(passw)){
                        loginUsername.setError(null);

                        String fullnameFromDB = snapshot.child(user).child("fullname").getValue(String.class);
                        String emailFromDB = snapshot.child(user).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(user).child("username").getValue(String.class);

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        intent.putExtra("fullname", fullnameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwFromDB);
                        intent.putExtra("email", emailFromDB);

                        startActivity(intent);
                    } else{
                        loginPassword.setError("Helytelen adatok!");
                        loginPassword.requestFocus();
                    }
                } else{
                    loginUsername.setError("Kérlek regisztrálj először!");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}