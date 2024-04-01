package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaCourse_00_IntroductionActivity extends AppCompatActivity {

    Button btnBack, btnNextVariables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course00_introduction);

        btnBack = findViewById(R.id.btnBackJavaCourseList);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JavaCourse_00_IntroductionActivity.this, JavaCourseListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnNextVariables = findViewById(R.id.btnNextCourseJava01);
        btnNextVariables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JavaCourse_00_IntroductionActivity.this, JavaCourse_01_VariablesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}