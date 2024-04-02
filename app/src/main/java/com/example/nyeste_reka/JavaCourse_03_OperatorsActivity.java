package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class JavaCourse_03_OperatorsActivity extends AppCompatActivity {

    Button btnBack, btnNextToQuizOperators;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course03_operators);

        btnBack = findViewById(R.id.btnBackJavaCourseList02);
        btnNextToQuizOperators = findViewById(R.id.btnNextCourseJava03);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_03_OperatorsActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextToQuizOperators.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_03_OperatorsActivity.this, JavaCourse_04_OperatorsQuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}