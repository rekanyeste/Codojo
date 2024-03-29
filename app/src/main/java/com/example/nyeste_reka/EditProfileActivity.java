package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {

    EditText editFName, editUName, editPwd, editEmailAdd;
    Button saveBtn, backBtn;
    String fullnameE, usernameE, passwordE, emailE;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        editFName = findViewById(R.id.editFullName);
        editUName = findViewById(R.id.editUsername);
        editPwd = findViewById(R.id.editPassword);
        editEmailAdd = findViewById(R.id.editEmail);
        saveBtn = findViewById(R.id.nextToSave);
        backBtn = findViewById(R.id.backToMain);

        DataChange();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ChangeFullname() || ChangeEmail() || ChangePassword()){
                    Toast.makeText(EditProfileActivity.this, "Elmentve", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfileActivity.this, "Hiba", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean ChangeFullname(){
        if (!fullnameE.equals(editFName.getText().toString())){
            databaseReference.child(usernameE).child("fullname").setValue(editFName.getText().toString());
            fullnameE = editFName.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean ChangeEmail(){
        if (!emailE.equals(editEmailAdd.getText().toString())){
            databaseReference.child(usernameE).child("email").setValue(editEmailAdd.getText().toString());
            emailE = editEmailAdd.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean ChangePassword(){
        if (!passwordE.equals(editPwd.getText().toString())){
            databaseReference.child(usernameE).child("password").setValue(editPwd.getText().toString());
            passwordE = editPwd.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    public void DataChange(){
        Intent intent = getIntent();
        fullnameE = intent.getStringExtra("fullname");
        usernameE = intent.getStringExtra("username");
        passwordE = intent.getStringExtra("password");
        emailE = intent.getStringExtra("email");

        editFName.setText(fullnameE);
        editUName.setText(usernameE);
        editPwd.setText(passwordE);
        editEmailAdd.setText(emailE);
    }
}