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

public class JavaCourse_04_OperatorsQuizActivity extends AppCompatActivity {

    TextView question02;
    Button valasz1_02, valasz2_02, valasz3_02, valasz4_02, btnBack, btnNextOp;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course04_operators_quiz);

        question02 = findViewById(R.id.questionVariables02);
        valasz1_02 = findViewById(R.id.valasz01Variables02);
        valasz2_02 = findViewById(R.id.valasz02Variables02);
        valasz3_02 = findViewById(R.id.valasz03Variables02);
        valasz4_02 = findViewById(R.id.valasz04Variables02);
        kvizLista = new ArrayList<>();
        rnd = new Random();
        kerdestValaszt(kvizLista);
        pozicio = rnd.nextInt(kvizLista.size());
        dataToViews(pozicio);

        valasz1_02.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1_02.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz2_02.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz2_02.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz3_02.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz3_02.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz4_02.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz4_02.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
    }
    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JavaCourse_04_OperatorsQuizActivity.this);
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
        question02.setText("Próbálkozások száma: " + probalkozas + "/10");
        if (probalkozas == 10){
            pontszamAlul();
        } else{
            question02.setText(kvizLista.get(pozicio).getKerdes());
            valasz1_02.setText(kvizLista.get(pozicio).getValasz1());
            valasz2_02.setText(kvizLista.get(pozicio).getValasz2());
            valasz3_02.setText(kvizLista.get(pozicio).getValasz3());
            valasz4_02.setText(kvizLista.get(pozicio).getValasz4());
        }
    }
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek){
        kvizKerdesek.add(new Quizzes("Melyik nem aritmetikai operátor?","+", "*", "==", "-", "=="));
        kvizKerdesek.add(new Quizzes("Mit csinál a += operátor?","Összeadás és értékadás a bal oldalon.", "Összeadás és értékadás a jobb oldalon.", "Egyiket sem.", "Mindkét oldalt összeadja.", "Összeadás és értékadás a bal oldalon."));
        kvizKerdesek.add(new Quizzes("Melyik az eltolás operátora?","&&", "|", "*", ">>", ">>"));
        kvizKerdesek.add(new Quizzes("Mennyi operandus lehetséges?","Egy", "Kettő", "Húsz", "Bármennyi", "Bármennyi"));
        kvizKerdesek.add(new Quizzes("Melyik nem bitenkénti operátor?","&", "|", ">>", "&&", "&&"));
    }
}