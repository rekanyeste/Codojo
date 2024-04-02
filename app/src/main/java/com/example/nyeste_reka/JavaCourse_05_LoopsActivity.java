package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class JavaCourse_05_LoopsActivity extends AppCompatActivity {

    Button btnBack, btnNextToLoopQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course05_loops);

        btnBack = findViewById(R.id.btnBackJavaCourseList03);
        btnNextToLoopQuiz = findViewById(R.id.btnNextCourseJava05);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_05_LoopsActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextToLoopQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_05_LoopsActivity.this, JavaCourse_06_LoopsQuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}