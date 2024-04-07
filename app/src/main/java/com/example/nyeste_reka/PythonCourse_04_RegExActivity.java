package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PythonCourse_04_RegExActivity extends AppCompatActivity {

    Button btnBack, btnNextFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course04_reg_ex);

        btnBack = findViewById(R.id.backPythonCourseList03);
        btnNextFile = findViewById(R.id.nextCoursePython03);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_04_RegExActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextFile.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_04_RegExActivity.this, PythonCourse_05_FileHandlingActivity.class);
            startActivity(intent);
            finish();
        });
    }
}