package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JavaCourseListActivity extends AppCompatActivity {

    Button homePage, backToChoseCourse;
    TextView introduction, variables, variablesQuiz, operators, operatorsQuiz, loops, loopsQuiz, arrays, arraysQuiz, methods, methodsQuiz, classes;
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
        operatorsQuiz = findViewById(R.id.operatorQuizJava);
        loops = findViewById(R.id.controlsJava);
        loopsQuiz = findViewById(R.id.controlsQuizJava);
        arrays = findViewById(R.id.arraysJava);
        arraysQuiz = findViewById(R.id.arraysQuizJava);
        methods = findViewById(R.id.methodsJava);
        methodsQuiz = findViewById(R.id.methodsQuizJava);
        classes = findViewById(R.id.classesJava);

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
        operatorsQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_04_OperatorsQuizActivity.class);
            startActivity(intent);
            finish();
        });
        loops.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_05_LoopsActivity.class);
            startActivity(intent);
            finish();
        });
        loopsQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_06_LoopsQuizActivity.class);
            startActivity(intent);
            finish();
        });
        arrays.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_07_ArraysActivity.class);
            startActivity(intent);
            finish();
        });
        arraysQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_08_ArraysQuizActivity.class);
            startActivity(intent);
            finish();
        });
        methods.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_09_MethodsActivity.class);
            startActivity(intent);
            finish();
        });
        methodsQuiz.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_10_MethodsQuizActivity.class);
            startActivity(intent);
            finish();
        });
        classes.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourseListActivity.this, JavaCourse_11_ClassActivity.class);
            startActivity(intent);
            finish();
        });
    }
}