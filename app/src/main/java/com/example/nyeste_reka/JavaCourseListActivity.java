package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaCourseListActivity extends AppCompatActivity {

    Button homePage, backToChoseCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course_list);

        homePage = findViewById(R.id.backToHome);
        backToChoseCourse = findViewById(R.id.backToCourses);

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JavaCourseListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        backToChoseCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JavaCourseListActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}