package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PythonCourse_00_IntroductionActivity extends AppCompatActivity {
    Button btnBack, btnNextCoursePy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course00_introduction);

        btnBack = findViewById(R.id.backPythonCourseList);
        btnNextCoursePy = findViewById(R.id.nextCoursePython00);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_00_IntroductionActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextCoursePy.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_00_IntroductionActivity.this, PythonCourse_01_SynthaxActivity.class);
            startActivity(intent);
            finish();
        });
    }
}