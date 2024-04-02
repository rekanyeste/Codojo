package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class JavaCourse_08_ArraysQuizActivity extends AppCompatActivity {
    TextView question04;
    Button valasz1_04, valasz2_04, valasz3_04, valasz4_04, btnBack, btnNextMethods;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course08_arrays_quiz);

        btnBack = findViewById(R.id.backToJavaList08);
        btnNextMethods = findViewById(R.id.nextToMethods);
        question04 = findViewById(R.id.questionVariables04);
        valasz1_04 = findViewById(R.id.valasz01Variables04);
        valasz2_04 = findViewById(R.id.valasz02Variables04);
        valasz3_04 = findViewById(R.id.valasz03Variables04);
        valasz4_04 = findViewById(R.id.valasz04Variables04);
        kvizLista = new ArrayList<>();
        rnd = new Random();
        kerdestValaszt(kvizLista);
        pozicio = rnd.nextInt(kvizLista.size());
        dataToViews(pozicio);

        valasz1_04.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1_04.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz2_04.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz2_04.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz3_04.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz3_04.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz4_04.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz4_04.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        btnNextMethods.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_08_ArraysQuizActivity.this, JavaCourse_09_MethodsActivity.class);
            startActivity(intent);
            finish();
        });
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_08_ArraysQuizActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JavaCourse_08_ArraysQuizActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_sheet, (LinearLayout)findViewById(R.id.LinearScore));
        TextView score = bottomSheetView.findViewById(R.id.pontszamValtozok);
        Button ujraKviz = bottomSheetView.findViewById(R.id.restartQuiz);
        score.setText("Jelenlegi pontszámod: \n" + pontszam + "/10");
        ujraKviz.setOnClickListener(view -> {
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
            probalkozas = 1;
            pontszam  = 0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void dataToViews(int pozicio){
        question04.setText("Próbálkozások száma: " + probalkozas + "/10");
        if (probalkozas == 10){
            pontszamAlul();
        } else{
            question04.setText(kvizLista.get(pozicio).getKerdes());
            valasz1_04.setText(kvizLista.get(pozicio).getValasz1());
            valasz2_04.setText(kvizLista.get(pozicio).getValasz2());
            valasz3_04.setText(kvizLista.get(pozicio).getValasz3());
            valasz4_04.setText(kvizLista.get(pozicio).getValasz4());
        }
    }
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek){
        kvizKerdesek.add(new Quizzes("Melyik fajta adatszerkezet mérete fix?","Lista", "Tömb", "Verem", "Térkép", "Tömb"));
        kvizKerdesek.add(new Quizzes("Melyik a kakukktojás?","Térkép", "Halmaz", "Vár", "Fésű", "Fésű"));
        kvizKerdesek.add(new Quizzes("Melyik deklaráció helyes?","int[] érdemjegyek = {1, 2, 3, 4, 5};", "Map<String> utcaNevek = new HashMap<>();", "Queue<String> recept = new List<>();", "List<String> tanulóNevek = new Array<>();", "int[] érdemjegyek = {1, 2, 3, 4, 5};"));
        kvizKerdesek.add(new Quizzes("Mit jelent a LIFO?","A legutolsó elemet veszik ki.", "A legutoljára hozzáadott elemet veszik ki először.", "A legelső elemet veszik ki.", "A legelőször hozzáadott elemet veszik ki legutoljára.", "A legutoljára hozzáadott elemet veszik ki először."));
    }
}