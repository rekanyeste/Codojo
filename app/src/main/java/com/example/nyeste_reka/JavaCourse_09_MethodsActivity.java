package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class JavaCourse_09_MethodsActivity extends AppCompatActivity {

    Button btnBack, btnMethodQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course09_methods);

        btnBack = findViewById(R.id.btnBackJavaCourseList09);
        btnMethodQuiz= findViewById(R.id.btnNextCourseJava09);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_09_MethodsActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnMethodQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_09_MethodsActivity.this, JavaCourse_10_MethodsQuizActivity.class);
            startActivity(intent);
            finish();
        });
    }

}