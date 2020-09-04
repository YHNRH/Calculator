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
    TextView virajenie;
    TextView result;
    int a;
    int buf;
    int state;
    char[] marinochka = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '0', '+', '/', '=', '*'};
    int vlad = 0;
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


        // j -- нормер в строке
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {                          // i -- номер в столбце


                GridLayout.Spec row = GridLayout.spec(i, 1);
                //... и в этой колонке
                GridLayout.Spec column = GridLayout.spec(j, 1);
                // Создадим параметр, в который передадим 2 строчки выше.
                GridLayout.LayoutParams gridLayoutParam = new GridLayout.LayoutParams(row, column);
                final Button b = new Button(this);
                b.getBackground().setColorFilter(new LightingColorFilter(0x11ace7f2, 0x11111111));

                switch (marinochka[vlad]) {
                    case('+'):  b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            state = 1;
                            buf = Integer.parseInt(virajenie.getText().toString());
                            virajenie.setText("");
                        }
                    });
                    break;
                    case('-'):  b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            state = 2;
                            buf = Integer.parseInt(virajenie.getText().toString());virajenie.setText("");
                        }
                    });
                        break;
                    case('/'):  b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            state = 4;
                            buf = Integer.parseInt(virajenie.getText().toString());virajenie.setText("");
                        }
                    });
                        break;
                    case('*'):  b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            state = 3;
                            buf = Integer.parseInt(virajenie.getText().toString());
                            virajenie.setText("");
                        }
                    });
                        break;
                    case('='):  b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch(state){
                                case(1):
                                    state = 0;
                                    a = Integer.parseInt(virajenie.getText().toString())+buf;
                                    result.setText(String.valueOf(a));
                                    virajenie.setText("");
                                    break;
                                case(2):
                                    state = 0;
                                    a = Integer.parseInt(virajenie.getText().toString())-buf;
                                    result.setText(String.valueOf(a));
                                    virajenie.setText("");
                                    break;
                            case(3):
                            state = 0;
                                a = Integer.parseInt(virajenie.getText().toString())*buf;
                                result.setText(String.valueOf(a));
                                virajenie.setText("");
                                break;

                            case(4):
                            state = 0;
                                a = Integer.parseInt(virajenie.getText().toString())/buf;
                                result.setText(String.valueOf(a));
                                virajenie.setText("");
                                break;
                        }}
                    });
                        break;
                    default:  b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
virajenie.setText(virajenie.getText().toString()+b.getText());
                        }
                    });
                        break;
                }
                b.setText(String.valueOf(marinochka[vlad]));
                vlad++;
                //добавили кнопку в GridLayout, применив к ней параметры gridLayoutParam (кнопка появится в ячейке row;column)
                gr.addView(b, gridLayoutParam);

            }
        }

        gr.setLayoutParams(params);
        virajenie = new TextView(this);
        result = new TextView(this);


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