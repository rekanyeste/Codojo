package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {

    Button buttonJava, buttonCSharp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        buttonJava = findViewById(R.id.btnCourseJava);
        buttonJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, JavaCourseActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonCSharp = findViewById(R.id.btnCourseCSharp);
        buttonCSharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, CSharpCourseActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}