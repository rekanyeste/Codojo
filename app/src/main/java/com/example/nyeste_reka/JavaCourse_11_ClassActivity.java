package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class JavaCourse_11_ClassActivity extends AppCompatActivity {

    Button btnBack, btnNextTypeConversions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course11_class);

        btnBack = findViewById(R.id.btnBackJavaCourseList11);
        btnNextTypeConversions = findViewById(R.id.btnNextType);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_11_ClassActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
        btnNextTypeConversions.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_11_ClassActivity.this, JavaCourse_12_TypeconversionActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

