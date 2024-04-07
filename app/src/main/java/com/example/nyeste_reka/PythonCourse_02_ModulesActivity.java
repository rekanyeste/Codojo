package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PythonCourse_02_ModulesActivity extends AppCompatActivity {

    Button btnBack, btnNextStructures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course02_modules);

        btnBack = findViewById(R.id.backPythonCourseList02);
        btnNextStructures = findViewById(R.id.nextCoursePython02);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_02_ModulesActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextStructures.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_02_ModulesActivity.this, PythonCourse_03_StructuresActivity.class);
            startActivity(intent);
            finish();
        });
    }
}