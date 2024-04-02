package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {

    Button buttonJava, buttonPython;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        buttonJava = findViewById(R.id.btnCourseJava);
        buttonJava.setOnClickListener(view -> {
            Intent intent = new Intent(QuizActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        buttonPython = findViewById(R.id.btnCoursePython);
        buttonPython.setOnClickListener(view -> {
            Intent intent = new Intent(QuizActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
    }
}