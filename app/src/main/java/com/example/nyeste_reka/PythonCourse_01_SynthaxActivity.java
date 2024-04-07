package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PythonCourse_01_SynthaxActivity extends AppCompatActivity {

    Button btnBack, btnNextModules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course01_synthax);

        btnBack = findViewById(R.id.backPythonCourseList01);
        btnNextModules = findViewById(R.id.nextCoursePython01);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_01_SynthaxActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextModules.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_01_SynthaxActivity.this, PythonCourse_02_ModulesActivity.class);
            startActivity(intent);
            finish();
        });
    }
}