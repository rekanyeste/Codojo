package com.example.nyeste_reka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText username, password, confirmPassword;
    private Button registerButton;
    private FirebaseAuth auth;
    private TextView alreadyLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.idEditUsername);
        password = findViewById(R.id.idEditPassword);
        confirmPassword = findViewById(R.id.idEditPwAgain);
        registerButton = findViewById(R.id.idRegisterButton);
        alreadyLogin = findViewById(R.id.idAlLogin);
        auth = FirebaseAuth.getInstance();

        //bejelentkező szöveg alul hivatkozás
        alreadyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //regisztrációs gomb
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userN = username.getText().toString();
                String passW = password.getText().toString();
                String pwdAg = confirmPassword.getText().toString();
                if (!passW.equals(pwdAg)){
                    Toast.makeText(RegisterActivity.this, "Jelszavak nem egyeznek!", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(userN) && TextUtils.isEmpty(passW) && TextUtils.isEmpty(pwdAg)){
                    Toast.makeText(RegisterActivity.this, "A mezők üresek!", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(userN, passW).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else{
                                Toast.makeText(RegisterActivity.this, "Sikertelen regisztráció!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}