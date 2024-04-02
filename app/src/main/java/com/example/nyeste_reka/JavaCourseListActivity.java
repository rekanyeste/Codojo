package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JavaCourseListActivity extends AppCompatActivity {

    Button homePage, backToChoseCourse;
    TextView introduction, variables, variablesQuiz, operators;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course_list);

        introduction = findViewById(R.id.introJava);
        homePage = findViewById(R.id.backToHome);
        backToChoseCourse = findViewById(R.id.backToCourses);
        variables = findViewById(R.id.variablesJava);
        variablesQuiz = findViewById(R.id.varQuizJava);
        operators = findViewById(R.id.operatorsJava);

        homePage.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        backToChoseCourse.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });
        introduction.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_00_IntroductionActivity.class);
            startActivity(intent);
            finish();
        });
        variables.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_01_VariablesActivity.class);
            startActivity(intent);
            finish();
        });
        variablesQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_02_VariablesQuizActivity.class);
            startActivity(intent);
            finish();
        });
        operators.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_03_OperatorsActivity.class);
            startActivity(intent);
            finish();
        });
    }
}