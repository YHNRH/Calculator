package com.example.kakhocheshtakinaozvi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    GridLayout gr;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gr = new GridLayout(this);
        gr.setColumnCount(3);
        gr.setRowCount(5);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    //    params.weight = 1.0f;
        params.gravity = Gravity.CENTER;


        int vlad = 0;
        char[] marinochka = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '0', '+', '/', '=', '*'};
        // j -- нормер в строке
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {                          // i -- номер в столбце


                GridLayout.Spec row = GridLayout.spec(i, 1);
                //... и в этой колонке
                GridLayout.Spec column = GridLayout.spec(j, 1);
                // Создадим параметр, в который передадим 2 строчки выше.
                GridLayout.LayoutParams gridLayoutParam = new GridLayout.LayoutParams(row, column);
                Button b = new Button(this);
                b.getBackground().setColorFilter(new LightingColorFilter(0x11ace7f2, 0x11111111));


                b.setText(String.valueOf(marinochka[vlad]));
                vlad++;
                //добавили кнопку в GridLayout, применив к ней параметры gridLayoutParam (кнопка появится в ячейке row;column)
                gr.addView(b, gridLayoutParam);

            }
        }

        gr.setLayoutParams(params);
        //gr.setPadding(0,0,0,100);
        TextView virajenie = new TextView(this);
        virajenie.setHint("Введите выражение");
        TextView result = new TextView(this);

       // result.setHeight(10);

        result.setHint("Ответ");


        result.setLayoutParams(params);


        virajenie.setLayoutParams(params);
        ll.addView(virajenie);
        ll.addView(result);
        ll.addView(gr);
        setContentView(ll);
    }
}



  /*  public void Create(View v) {
        //Кнопка будет создана в этой строке...
        GridLayout.Spec row = GridLayout.spec(rowIndex, 1);
        //... и в этой колонке
        Spec column = GridLayout.spec(columnIndex, 1);
        // Создадим параметр, в который передадим 2 строчки выше.
        GridLayout.LayoutParams gridLayoutParam = new GridLayout.LayoutParams(row, column);
        //Создали кнопку
        RadioButton btnNew = new RadioButton(this);
        //добавили кнопку в GridLayout, применив к ней параметры gridLayoutParam (кнопка появится в ячейке row;column)
        FieldLayout.addView(btnNew,gridLayoutParam);
        Toast.makeText(this, "Создана кнопка", Toast.LENGTH_SHORT).show();
        rowIndex++; columnIndex++;
    }*/