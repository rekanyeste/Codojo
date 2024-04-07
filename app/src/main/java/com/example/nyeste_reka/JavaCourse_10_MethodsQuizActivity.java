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

public class JavaCourse_10_MethodsQuizActivity extends AppCompatActivity {
    TextView question05;
    Button valasz1_05, valasz2_05, valasz3_05, valasz4_05, btnBack, btnNextClasses;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course10_methods_quiz);

        btnBack = findViewById(R.id.backToJavaList09);
        btnNextClasses = findViewById(R.id.nextToClass);
        question05 = findViewById(R.id.questionVariables05);
        valasz1_05 = findViewById(R.id.valasz01Variables05);
        valasz2_05 = findViewById(R.id.valasz02Variables05);
        valasz3_05 = findViewById(R.id.valasz03Variables05);
        valasz4_05 = findViewById(R.id.valasz04Variables05);
        kvizLista = new ArrayList<>();
        rnd = new Random();
        kerdestValaszt(kvizLista);
        pozicio = rnd.nextInt(kvizLista.size());
        dataToViews(pozicio);

        valasz1_05.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1_05.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz2_05.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz2_05.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz3_05.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz3_05.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz4_05.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz4_05.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });

        btnNextClasses.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_10_MethodsQuizActivity.this, JavaCourses_11_ClassActivity.class);
            startActivity(intent);
            finish();
        });
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(JavaCourse_10_MethodsQuizActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JavaCourse_10_MethodsQuizActivity.this);
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
        question05.setText("Próbálkozások száma: " + probalkozas + "/10");
        if (probalkozas == 10){
            pontszamAlul();
        } else{
            question05.setText(kvizLista.get(pozicio).getKerdes());
            valasz1_05.setText(kvizLista.get(pozicio).getValasz1());
            valasz2_05.setText(kvizLista.get(pozicio).getValasz2());
            valasz3_05.setText(kvizLista.get(pozicio).getValasz3());
            valasz4_05.setText(kvizLista.get(pozicio).getValasz4());
        }
    }
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek){
        kvizKerdesek.add(new Quizzes("Melyik állítás igaz a függvényekre?","A függvények csak a main függvényből hívhatóak meg.", "Nem minden függvénynek kötelező visszatérési értékkel rendelkeznie.", "A függvényeket tilos túlterhelni.", "A függvények bármennyiszer használhatóak egy programban.", "A függvények csak a main függvényből hívhatóak meg."));
        kvizKerdesek.add(new Quizzes("Melyik állítás hamis a függvényekkel kapcsolatban?","A függvények segítenek strukturálni a kódot.", "Minden függvénynek van visszatérési értéke.", "A függvények nem fogadhatnak paramétereket.", "A függvények csak egyszer használhatóak egy programban.", "A függvények nem fogadhatnak paramétereket."));
        kvizKerdesek.add(new Quizzes("Melyik állítás igaz az eljárások túlterhelésére?","Egy eljárást csak egyszer lehet definiálni egy osztályban.", "Ugyanazt az eljárásnevet többször is definiálhatjuk, de különböző paraméterlistákkal.", "Egy eljárásnak mindig van visszatérési értéke.", "Csak akkor lehetséges, ha az összes paramétert ugyanolyan típusúra állítjuk be.", "Ugyanazt az eljárásnevet többször is definiálhatjuk, de különböző paraméterlistákkal."));
        kvizKerdesek.add(new Quizzes("Miért hasznos a metódus túlterhelése?","Csökkenti a kód olvashatóságát.", "Nem hasznos, csak felesleges szintaktikai kényelmetlenséget okoz.", "Lehetővé teszi ugyanazon metódusnév újrafelhasználását különböző paraméterekkel.", "Megnehezíti a kód hibakeresését és karbantartását.", "Lehetővé teszi ugyanazon metódusnév újrafelhasználását különböző paraméterekkel."));
        kvizKerdesek.add(new Quizzes("Mit jelent a metódus túlterhelése?","Egy metódusnak több visszatérési értéke van.", "Egy metódusnak csak egyszerű visszatérési értéke lehet.", "A metódusok nem fogadhatnak el paramétereket.", "Ugyanazt a metódusnevet többször is definiálhatjuk, de különböző paraméterlistákkal.", "Ugyanazt a metódusnevet többször is definiálhatjuk, de különböző paraméterlistákkal."));
    }
}