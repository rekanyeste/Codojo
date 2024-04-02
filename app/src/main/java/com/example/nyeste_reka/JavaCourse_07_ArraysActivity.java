package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class JavaCourse_07_ArraysActivity extends AppCompatActivity {

    Button btnBack, btnNextToArrayQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course07_arrays);

        btnBack = findViewById(R.id.btnBackJavaCourseList07);
        btnNextToArrayQuiz = findViewById(R.id.btnNextCourseJava07);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_07_ArraysActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextToArrayQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_07_ArraysActivity.this, JavaCourse_08_ArraysQuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}