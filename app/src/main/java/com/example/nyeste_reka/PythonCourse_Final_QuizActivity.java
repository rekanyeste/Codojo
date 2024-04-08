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

public class PythonCourse_Final_QuizActivity extends AppCompatActivity {

    TextView questionFinal;
    Button valasz1_Final, valasz2_Final, valasz3_Final, valasz4_Final, btnBack;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_course_final_quiz);

        btnBack = findViewById(R.id.backToPyListFinal);
        questionFinal = findViewById(R.id.questionVariablesFinalPy);
        valasz1_Final = findViewById(R.id.valasz01VariablesFinalPy);
        valasz2_Final = findViewById(R.id.valasz02VariablesFinalPy);
        valasz3_Final = findViewById(R.id.valasz03VariablesFinalPy);
        valasz4_Final = findViewById(R.id.valasz04VariablesFinalPy);
        kvizLista = new ArrayList<>();
        rnd = new Random();
        kerdestValaszt(kvizLista);
        pozicio = rnd.nextInt(kvizLista.size());
        dataToViews(pozicio);

        valasz1_Final.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1_Final.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz2_Final.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz2_Final.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz3_Final.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz3_Final.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });
        valasz4_Final.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz4_Final.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PythonCourse_Final_QuizActivity.this, PythonCourseListActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PythonCourse_Final_QuizActivity.this);
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
        questionFinal.setText("Próbálkozások száma: " + probalkozas + "/10");
        if (probalkozas == 10){
            pontszamAlul();
        } else{
            questionFinal.setText(kvizLista.get(pozicio).getKerdes());
            valasz1_Final.setText(kvizLista.get(pozicio).getValasz1());
            valasz2_Final.setText(kvizLista.get(pozicio).getValasz2());
            valasz3_Final.setText(kvizLista.get(pozicio).getValasz3());
            valasz4_Final.setText(kvizLista.get(pozicio).getValasz4());
        }
    }
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek) {
        kvizKerdesek.add(new Quizzes("Melyik az érvényes változónév ?", "my_variable_1", "1_my_variable", "my-variable", "my variable", "my_variable_1"));
        kvizKerdesek.add(new Quizzes("Melyik az érvényes módszer egy függvény definiálására?", "def my_function():", "function my_function():", "define my_function():", "function my_function", "def my_function():"));
        kvizKerdesek.add(new Quizzes("Melyik operátor használható hatványozásra a Pythonban?", "^", "**", "%", "//", "**"));
        kvizKerdesek.add(new Quizzes("Melyik az alábbi változó típusa: my_variable = \"Hello, World!\"?", "Integer", "Tuple", "Lista", "String", "String"));
        kvizKerdesek.add(new Quizzes("Melyik parancs importálja a math modult?", "import Math", "include math", "import math", "from math import *", "import math"));
        kvizKerdesek.add(new Quizzes("Mi a fő különbség a return és a print utasítás között egy függvényben?", "A print kiírja a kimenetet a konzolra, a return visszatérési értéket ad vissza.", "A return kiírja a kimenetet a konzolra, a print visszatérési értéket ad vissza.", "A print csak számokat nyomtat, a return pedig karakterláncokat.", "A print a kód hibáit írja ki, a return a függvény teljes tartalmát.", "A print kiírja a kimenetet a konzolra, a return visszatérési értéket ad vissza."));
        kvizKerdesek.add(new Quizzes("Melyik művelet hajtódik végre a my_list.append(4) kóddal?", "Törli a my_list elejét.", "Törli a 4-et a my_list végéről.", "Módosítja a my_list méretét.", "Hozzáadja a 4-et a my_list végéhez.", "Hozzáadja a 4-et a my_list végéhez."));
        kvizKerdesek.add(new Quizzes("Mit csinál a import random parancs?", "Véletlenszerű számokat generál.", "A függvényeket és modulokat teszi elérhetővé a véletlenszerű modulból.", "Véletlenszerűen választ egy modult a rendszerből.", "Randomizálja a fájlok sorrendjét egy mappában.", "A függvényeket és modulokat teszi elérhetővé a véletlenszerű modulból."));
        kvizKerdesek.add(new Quizzes("Melyik adatszerkezet tárol egyedi elemeket és rendezetlenül van?", "Lista", "Tuple", "Szótár", "Halmaz", "Halmaz"));
        kvizKerdesek.add(new Quizzes("Melyik művelet töröl egy elemet egy listából?", "delete()", "remove()", "discard()", "pop()", "remove()"));
        kvizKerdesek.add(new Quizzes("Mi a kimenete ennek a kódnak: szotar[\"eletkor\"] ha szotar = {\"nev\": \"Reka\", \"eletkor\": 25}?", "25", "Reka", "age", "Hibára fut.", "25"));
        kvizKerdesek.add(new Quizzes("Melyik operátor használható listák és tuple-ök konkatenációjára?", "%", "/", "+", "-", "+"));
        kvizKerdesek.add(new Quizzes("Melyik művelet ad hozzá egy új kulcs-érték párt egy szótárhoz?", "add()", "append()", "insert()", "update()", "update()"));
        kvizKerdesek.add(new Quizzes("Melyik függvényt használjuk a fájl olvasására egy file objektumon keresztül?", "readline()", "write()", "open()", "read()", "read()"));
        kvizKerdesek.add(new Quizzes("Melyik metódust használjuk a szöveg másolására egy új változóba?", "split()", "replace()", "copy()", "clone()", "copy()"));
        kvizKerdesek.add(new Quizzes("Melyik reguláris kifejezés illeszkedik a kisbetűs szavakra egy szövegben?", "\"[a-z]\"", "\"[a-z]+\"", "\"\\d{3}-\\d{2}-\\d{4}\"", "\"^\\w+\\s\\w+$\"", "\"[a-z]+\""));
        kvizKerdesek.add(new Quizzes("Melyik függvényt használjuk egy szöveg elején és végén lévő fehér karakterek eltávolítására?", "strip()", "trim()", "clean()", "remove()", "strip()"));
        kvizKerdesek.add(new Quizzes("Melyik függvényt használjuk a fájl megnyitására írás céljából?", "open(\"file.txt\", \"r\")", "open(\"file.txt\", \"w\")", "open(\"file.txt\", \"a\")", "open(\"file.txt\", \"x\")", "open(\"file.txt\", \"w\")"));
        kvizKerdesek.add(new Quizzes("Melyik művelet hajtódik végre a os.remove(\"file.txt\") kóddal?", "A file.txt fájl létrehozása.", "file.txt fájl átnevezése.", "file.txt fájl törlése.", "file.txt fájl bezárása.", "file.txt fájl törlése."));
        kvizKerdesek.add(new Quizzes("Melyik parancs hoz létre egy fájlt, ha nem létezik?", "create()", "touch()", "open(\"file.txt\", \"w\")", "new_file()", "touch()"));
        kvizKerdesek.add(new Quizzes("Melyik függvényt használjuk egy fájl átnevezésére?", "rename()", "change_name()", "move()", "modify()", "rename()"));
    }
}