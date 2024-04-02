package com.example.nyeste_reka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class JavaCourse_02_VariablesQuizActivity extends AppCompatActivity {

    TextView question;
    Button valasz1, valasz2, valasz3, valasz4;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course02_variables_quiz);

        question = findViewById(R.id.questionVariables);
        valasz1 = findViewById(R.id.valasz01Variables);
        valasz2 = findViewById(R.id.valasz02Variables);
        valasz3 = findViewById(R.id.valasz03Variables);
        valasz4 = findViewById(R.id.valasz04Variables);
        kvizLista = new ArrayList<>();
        rnd = new Random();
        kerdestValaszt(kvizLista);
        pozicio = rnd.nextInt(kvizLista.size());
        dataToViews(pozicio);

        valasz1.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz2.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz2.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz3.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz3.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz4.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz4.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });

    }

    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JavaCourse_02_VariablesQuizActivity.this);
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
        question.setText("Próbálkozások száma: " + probalkozas + "/10");
        if (probalkozas == 10){
            pontszamAlul();
        } else{
            question.setText(kvizLista.get(pozicio).getKerdes());
            valasz1.setText(kvizLista.get(pozicio).getValasz1());
            valasz2.setText(kvizLista.get(pozicio).getValasz2());
            valasz3.setText(kvizLista.get(pozicio).getValasz3());
            valasz4.setText(kvizLista.get(pozicio).getValasz4());
        }
    }
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek){
        kvizKerdesek.add(new Quizzes("Melyik nem egy változó típusa?","int", "char", "String", "static", "static"));
        kvizKerdesek.add(new Quizzes("Melyik deklaráció a helyes?","int 25;", "boolean true;", "char c;", "double 3.14;", "char c;"));
        kvizKerdesek.add(new Quizzes("Melyik típus tárol lebegőpontos számokat?","int", "double", "String", "Object", "double"));
        kvizKerdesek.add(new Quizzes("Melyik deklarálás és inicializálás a helytelen?","boolean = true;", "int életkor = 25;", "char c = 'B'", "double szám = 5.98;", "boolean = true;"));
    }
}