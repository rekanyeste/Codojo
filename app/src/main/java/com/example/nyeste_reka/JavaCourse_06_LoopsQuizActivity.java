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

public class JavaCourse_06_LoopsQuizActivity extends AppCompatActivity {


    TextView question03;
    Button valasz1_03, valasz2_03, valasz3_03, valasz4_03, btnBack, btnNextArrays;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course06_loops_quiz);

        btnBack = findViewById(R.id.backToJavaList05);
        btnNextArrays = findViewById(R.id.nextToArrays);
        question03 = findViewById(R.id.questionVariables03);
        valasz1_03 = findViewById(R.id.valasz01Variables03);
        valasz2_03 = findViewById(R.id.valasz02Variables03);
        valasz3_03 = findViewById(R.id.valasz03Variables03);
        valasz4_03 = findViewById(R.id.valasz04Variables03);
        kvizLista = new ArrayList<>();
        rnd = new Random();
        kerdestValaszt(kvizLista);
        pozicio = rnd.nextInt(kvizLista.size());
        dataToViews(pozicio);

        valasz1_03.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1_03.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz2_03.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz2_03.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz3_03.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz3_03.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz4_03.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz4_03.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        btnNextArrays.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_06_LoopsQuizActivity.this, JavaCourse_05_LoopsActivity.class);
            startActivity(intent);
            finish();
        });
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_06_LoopsQuizActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JavaCourse_06_LoopsQuizActivity.this);
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
        question03.setText("Próbálkozások száma: " + probalkozas + "/10");
        if (probalkozas == 10){
            pontszamAlul();
        } else{
            question03.setText(kvizLista.get(pozicio).getKerdes());
            valasz1_03.setText(kvizLista.get(pozicio).getValasz1());
            valasz2_03.setText(kvizLista.get(pozicio).getValasz2());
            valasz3_03.setText(kvizLista.get(pozicio).getValasz3());
            valasz4_03.setText(kvizLista.get(pozicio).getValasz4());
        }
    }
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek){
        kvizKerdesek.add(new Quizzes("Melyik nem elágazás?","if-else", "switch-case", "Mindkettő az.", "Egyik sem az.", "Mindkettő az."));
        kvizKerdesek.add(new Quizzes("Melyik ciklus hátul tesztelő?","For", "While", "Foreach", "Do-while", "Do-while"));
        kvizKerdesek.add(new Quizzes("Melyik ciklusba szoktunk deklarálni számlálót?","While", "For", "Switch-case", "Do-while", "For"));
        kvizKerdesek.add(new Quizzes("Hányszor ismétel a for ciklus?","Egyszer", "Kétszer", "Amennyit beállítunk neki.", "Bármennyiszer.", "Amennyit beállítunk neki."));
    }
}