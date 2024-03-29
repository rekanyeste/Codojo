package com.example.nyeste_reka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView profFullname, profUsername, profPassword, profEmail;
    TextView logFullname, logUsername;
    Button editBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profFullname = findViewById(R.id.fullnameChanged);
        profUsername = findViewById(R.id.usernameChanged);
        profPassword = findViewById(R.id.passwordChanged);
        profEmail = findViewById(R.id.emailChanged);
        logFullname = findViewById(R.id.loggedFullName);
        logUsername = findViewById(R.id.loggedUsername);
        editBtn = findViewById(R.id.editButton);

        Data();

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Data(){
        SharedPreferences sharedPref = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String fullnameUser = sharedPref.getString("fullname", null);
        String usernameUser = sharedPref.getString("username", null);
        String passwordUser = sharedPref.getString("password", null);
        String emailUser = sharedPref.getString("email", null);

        String userName = profUsername.getText().toString().trim();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
        Query check = databaseReference.orderByChild("username").equalTo(userName);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        logFullname.setText(fullnameUser);
        logUsername.setText(usernameUser);
        profFullname.setText(fullnameUser);
        profUsername.setText(usernameUser);
        profPassword.setText(passwordUser);
        profEmail.setText(emailUser);


    }
    public void Check(){
        String userName = profUsername.getText().toString().trim();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
        Query check = databaseReference.orderByChild("username").equalTo(userName);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String fullnameDB = snapshot.child(userName).child("fullname").getValue(String.class);
                    String usernameDB = snapshot.child(userName).child("username").getValue(String.class);
                    String pwdDB = snapshot.child(userName).child("password").getValue(String.class);
                    String emailDB = snapshot.child(userName).child("email").getValue(String.class);

                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);

                    intent.putExtra("fullname", fullnameDB);
                    intent.putExtra("username", usernameDB);
                    intent.putExtra("password", pwdDB);
                    intent.putExtra("email", emailDB);

                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}