package com.example.nyeste_reka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText fullname, username, password, email;
    private Button registerButton;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private TextView alreadyLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.idEditName);
        username = findViewById(R.id.idEditUsername);
        password = findViewById(R.id.idEditPassword);
        email = findViewById(R.id.idEditEmailReg);
        registerButton = findViewById(R.id.idRegisterButton);
        alreadyLogin = findViewById(R.id.idAlLogin);

        registerButton.setOnClickListener(view -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");

            String fname = fullname.getText().toString();
            String uname = username.getText().toString();
            String pwd = password.getText().toString();
            String emailAdd = email.getText().toString();

            Users users = new Users(fname, uname, pwd, emailAdd);
            reference.child(uname).setValue(users);

            Toast.makeText(RegisterActivity.this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });

        alreadyLogin.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

    }
}