package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PythonCourse_05_FileHandlingActivity extends AppCompatActivity {

    Button btnBack, btnNextQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course05_file_handling);

        btnBack = findViewById(R.id.backPythonCourseList05);
        btnNextQuiz = findViewById(R.id.nextFinalQuizPython05);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_05_FileHandlingActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_05_FileHandlingActivity.this, PythonCourse_Final_QuizActivity.class);
            startActivity(intent);
            finish();
        });
    }
}