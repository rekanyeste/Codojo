package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PythonCourseListActivity extends AppCompatActivity {

    Button btnBack, btnHome;
    TextView bevezetes, szintaxis, metodusok, adatszerkezetek, regularis, fajlkezeles, pythonQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course_list);

        btnBack = findViewById(R.id.backToCourses);
        btnHome = findViewById(R.id.backToHome);
        bevezetes = findViewById(R.id.introPython);
        szintaxis = findViewById(R.id.synPython);
        metodusok = findViewById(R.id.methodsPython);
        adatszerkezetek = findViewById(R.id.structuresPython);
        regularis = findViewById(R.id.regularPython);
        fajlkezeles = findViewById(R.id.filePython);
        pythonQuiz = findViewById(R.id.finalQuizPython);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });
        bevezetes.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_00_IntroductionActivity.class);
            startActivity(intent);
            finish();
        });
        szintaxis.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_01_SynthaxActivity.class);
            startActivity(intent);
            finish();
        });
        metodusok.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_02_ModulesActivity.class);
            startActivity(intent);
            finish();
        });
        adatszerkezetek.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_03_StructuresActivity.class);
            startActivity(intent);
            finish();
        });
        regularis.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_04_RegExActivity.class);
            startActivity(intent);
            finish();
        });
        fajlkezeles.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_05_FileHandlingActivity.class);
            startActivity(intent);
            finish();
        });
        pythonQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, PythonCourse_Final_QuizActivity.class);
            startActivity(intent);
            finish();
        });
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourseListActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}