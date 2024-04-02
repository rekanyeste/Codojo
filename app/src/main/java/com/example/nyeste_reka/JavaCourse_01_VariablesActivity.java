package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaCourse_01_VariablesActivity extends AppCompatActivity {

    Button btnBack, btnNextToQuizVariables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course01_variables);

        btnBack = findViewById(R.id.btnBackJavaCourseList01);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_01_VariablesActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextToQuizVariables = findViewById(R.id.btnNextCourseJava01);
        btnNextToQuizVariables.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_01_VariablesActivity.this, JavaCourse_02_VariablesQuizActivity.class);
            startActivity(intent);
        });
    }
}