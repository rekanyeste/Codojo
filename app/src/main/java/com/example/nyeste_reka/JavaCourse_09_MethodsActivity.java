package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class JavaCourse_09_MethodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course09_methods);

        int szam = osszeAd(3, 5); // 8
        kiiratas(); // "Hello!"
        udvozol("Réka"); // "Hello, Réka!"

    }

    public int osszeAd(int a, int b) {
        return a + b;
        //Függvény, ezért kötelező bele a return
    }
    public double osszeAd(double a, double b) {
        return a + b;
    }

    public void kiiratas() {
        System.out.println("Hello!");
        //Eljárás, ezért nincs benne return utasítás
    }
    public void udvozol(String name) {
        System.out.println("Hello, " + name + "!");
    }

}