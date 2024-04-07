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

public class JavaCourse_Final_QuizActivity extends AppCompatActivity {
    TextView questionFinal;
    Button valasz1_Final, valasz2_Final, valasz3_Final, valasz4_Final, btnBack;
    ArrayList<Quizzes> kvizLista;
    Random rnd;
    int pontszam, probalkozas, pozicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course_final_quiz);

        btnBack = findViewById(R.id.backToJavaListFinal);
        questionFinal = findViewById(R.id.questionVariablesFinal);
        valasz1_Final = findViewById(R.id.valasz01VariablesFinal);
        valasz2_Final = findViewById(R.id.valasz02VariablesFinal);
        valasz3_Final = findViewById(R.id.valasz03VariablesFinal);
        valasz4_Final = findViewById(R.id.valasz04VariablesFinal);
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
            Intent intent = new Intent(JavaCourse_Final_QuizActivity.this, JavaCourseListActivity.class);
            startActivity(intent);
            finish();
        });
    }
    private void pontszamAlul(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JavaCourse_Final_QuizActivity.this);
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
    private void kerdestValaszt(ArrayList<Quizzes> kvizKerdesek){
        kvizKerdesek.add(new Quizzes("Melyik állítás igaz a függvényekre?","A függvények csak a main függvényből hívhatóak meg.", "Nem minden függvénynek kötelező visszatérési értékkel rendelkeznie.", "A függvényeket tilos túlterhelni.", "A függvények bármennyiszer használhatóak egy programban.", "A függvények csak a main függvényből hívhatóak meg."));
        kvizKerdesek.add(new Quizzes("Melyik állítás hamis a függvényekkel kapcsolatban?","A függvények segítenek strukturálni a kódot.", "Minden függvénynek van visszatérési értéke.", "A függvények nem fogadhatnak paramétereket.", "A függvények csak egyszer használhatóak egy programban.", "A függvények nem fogadhatnak paramétereket."));
        kvizKerdesek.add(new Quizzes("Melyik állítás igaz az eljárások túlterhelésére?","Egy eljárást csak egyszer lehet definiálni egy osztályban.", "Ugyanazt az eljárásnevet többször is definiálhatjuk, de különböző paraméterlistákkal.", "Egy eljárásnak mindig van visszatérési értéke.", "Csak akkor lehetséges, ha az összes paramétert ugyanolyan típusúra állítjuk be.", "Ugyanazt az eljárásnevet többször is definiálhatjuk, de különböző paraméterlistákkal."));
        kvizKerdesek.add(new Quizzes("Miért hasznos a metódus túlterhelése?","Csökkenti a kód olvashatóságát.", "Nem hasznos, csak felesleges szintaktikai kényelmetlenséget okoz.", "Lehetővé teszi ugyanazon metódusnév újrafelhasználását különböző paraméterekkel.", "Megnehezíti a kód hibakeresését és karbantartását.", "Lehetővé teszi ugyanazon metódusnév újrafelhasználását különböző paraméterekkel."));
        kvizKerdesek.add(new Quizzes("Mit jelent a metódus túlterhelése?","Egy metódusnak több visszatérési értéke van.", "Egy metódusnak csak egyszerű visszatérési értéke lehet.", "A metódusok nem fogadhatnak el paramétereket.", "Ugyanazt a metódusnevet többször is definiálhatjuk, de különböző paraméterlistákkal.", "Ugyanazt a metódusnevet többször is definiálhatjuk, de különböző paraméterlistákkal."));
        kvizKerdesek.add(new Quizzes("Melyik állítás igaz a függvényekre?","A függvények csak a main függvényből hívhatóak meg.", "Nem minden függvénynek kötelező visszatérési értékkel rendelkeznie.", "A függvényeket tilos túlterhelni.", "A függvények bármennyiszer használhatóak egy programban.", "A függvények csak a main függvényből hívhatóak meg."));
        kvizKerdesek.add(new Quizzes("Melyik állítás hamis a függvényekkel kapcsolatban?","A függvények segítenek strukturálni a kódot.", "Minden függvénynek van visszatérési értéke.", "A függvények nem fogadhatnak paramétereket.", "A függvények csak egyszer használhatóak egy programban.", "A függvények nem fogadhatnak paramétereket."));
        kvizKerdesek.add(new Quizzes("Melyik állítás igaz az eljárások túlterhelésére?","Egy eljárást csak egyszer lehet definiálni egy osztályban.", "Ugyanazt az eljárásnevet többször is definiálhatjuk, de különböző paraméterlistákkal.", "Egy eljárásnak mindig van visszatérési értéke.", "Csak akkor lehetséges, ha az összes paramétert ugyanolyan típusúra állítjuk be.", "Ugyanazt az eljárásnevet többször is definiálhatjuk, de különböző paraméterlistákkal."));
        kvizKerdesek.add(new Quizzes("Miért hasznos a metódus túlterhelése?","Csökkenti a kód olvashatóságát.", "Nem hasznos, csak felesleges szintaktikai kényelmetlenséget okoz.", "Lehetővé teszi ugyanazon metódusnév újrafelhasználását különböző paraméterekkel.", "Megnehezíti a kód hibakeresését és karbantartását.", "Lehetővé teszi ugyanazon metódusnév újrafelhasználását különböző paraméterekkel."));
        kvizKerdesek.add(new Quizzes("Mit jelent a metódus túlterhelése?","Egy metódusnak több visszatérési értéke van.", "Egy metódusnak csak egyszerű visszatérési értéke lehet.", "A metódusok nem fogadhatnak el paramétereket.", "Ugyanazt a metódusnevet többször is definiálhatjuk, de különböző paraméterlistákkal.", "Ugyanazt a metódusnevet többször is definiálhatjuk, de különböző paraméterlistákkal."));
        kvizKerdesek.add(new Quizzes("Melyik nem egy változó típusa?","int", "char", "String", "static", "static"));
        kvizKerdesek.add(new Quizzes("Melyik deklaráció a helyes?","int 25;", "boolean true;", "char c;", "double 3.14;", "char c;"));
        kvizKerdesek.add(new Quizzes("Melyik típus tárol lebegőpontos számokat?","int", "double", "String", "Object", "double"));
        kvizKerdesek.add(new Quizzes("Melyik deklarálás és inicializálás a helytelen?","boolean = true;", "int életkor = 25;", "char c = 'B'", "double szám = 5.98;", "boolean = true;"));
        kvizKerdesek.add(new Quizzes("Hogy hívják azt a típust, amelyik karakterláncokat tárol?","double", "Object", "int", "String", "String"));
        kvizKerdesek.add(new Quizzes("Melyik nem aritmetikai operátor?","+", "*", "==", "-", "=="));
        kvizKerdesek.add(new Quizzes("Mit csinál a += operátor?","Összeadás és értékadás a bal oldalon.", "Összeadás és értékadás a jobb oldalon.", "Egyiket sem.", "Mindkét oldalt összeadja.", "Összeadás és értékadás a bal oldalon."));
        kvizKerdesek.add(new Quizzes("Melyik az eltolás operátora?","&&", "|", "*", ">>", ">>"));
        kvizKerdesek.add(new Quizzes("Mennyi operandus lehetséges?","Egy", "Kettő", "Húsz", "Bármennyi", "Bármennyi"));
        kvizKerdesek.add(new Quizzes("Melyik nem bitenkénti operátor?","&", "|", ">>", "&&", "&&"));
        kvizKerdesek.add(new Quizzes("Melyik nem elágazás?","if-else", "switch-case", "Mindkettő az.", "Egyik sem az.", "Mindkettő az."));
        kvizKerdesek.add(new Quizzes("Melyik ciklus hátul tesztelő?","For", "While", "Foreach", "Do-while", "Do-while"));
        kvizKerdesek.add(new Quizzes("Melyik ciklusba szoktunk deklarálni számlálót?","While", "For", "Switch-case", "Do-while", "For"));
        kvizKerdesek.add(new Quizzes("Hányszor ismétel a for ciklus?","Egyszer", "Kétszer", "Amennyit beállítunk neki.", "Bármennyiszer.", "Amennyit beállítunk neki."));
        kvizKerdesek.add(new Quizzes("Melyik fajta adatszerkezet mérete fix?","Lista", "Tömb", "Verem", "Térkép", "Tömb"));
        kvizKerdesek.add(new Quizzes("Melyik a kakukktojás?","Térkép", "Halmaz", "Vár", "Fésű", "Fésű"));
        kvizKerdesek.add(new Quizzes("Melyik deklaráció helyes?","int[] érdemjegyek = {1, 2, 3, 4, 5};", "Map<String> utcaNevek = new HashMap<>();", "Queue<String> recept = new List<>();", "List<String> tanulóNevek = new Array<>();", "int[] érdemjegyek = {1, 2, 3, 4, 5};"));
        kvizKerdesek.add(new Quizzes("Mit jelent a LIFO?","A legutolsó elemet veszik ki.", "A legutoljára hozzáadott elemet veszik ki először.", "A legelső elemet veszik ki.", "A legelőször hozzáadott elemet veszik ki legutoljára.", "A legutoljára hozzáadott elemet veszik ki először."));
    }

}