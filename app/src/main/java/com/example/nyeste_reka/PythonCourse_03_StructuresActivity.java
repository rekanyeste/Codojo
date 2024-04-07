package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PythonCourse_03_StructuresActivity extends AppCompatActivity {
    Button btnBack, btnNextRegex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course03_structures);

        btnBack = findViewById(R.id.backPythonCourseList03);
        btnNextRegex = findViewById(R.id.nextCoursePython03);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_03_StructuresActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextRegex.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_03_StructuresActivity.this, PythonCourse_04_RegExActivity.class);
            startActivity(intent);
            finish();
        });
    }
}