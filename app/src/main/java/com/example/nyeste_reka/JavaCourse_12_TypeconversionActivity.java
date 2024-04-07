package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class JavaCourse_12_TypeconversionActivity extends AppCompatActivity {

    Button btnBack, btnNextJavaFinalQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course12_typeconversion);

        btnBack = findViewById(R.id.btnBackJavaCourseList12);
        btnNextJavaFinalQuiz = findViewById(R.id.btnNextFinalQuiz);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_12_TypeconversionActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextJavaFinalQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_12_TypeconversionActivity.this, JavaCourse_Final_QuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}