package com.example.anthony.futmath10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainFinal extends AppCompatActivity implements View.OnClickListener {
    TextView tv_nombre1, tv_nombre2, tv_puntos1, tv_puntos2, tv_ganador;
    Button btn_reiniciar, btn_nueva, btn_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_final);

        btn_nueva = (Button)findViewById(R.id.btn_nueva);
        btn_reiniciar = (Button)findViewById(R.id.btn_reiniciar);
        btn_salir = (Button)findViewById(R.id.btn_salir);

        tv_ganador = (TextView)findViewById(R.id.tv_operador);
        tv_nombre1 = (TextView)findViewById(R.id.tv_nombre1);
        tv_nombre2 = (TextView)findViewById(R.id.tv_nombre2);
        tv_puntos1 = (TextView)findViewById(R.id.tv_puntos1);
        tv_puntos2 = (TextView)findViewById(R.id.tv_puntos2);

        btn_nueva.setOnClickListener(this);
        btn_reiniciar.setOnClickListener(this);
        btn_salir.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if (extra != null) {
            String dato1 = extra.getString("Nombre1");
            String dato2 = extra.getString("Nombre2");
            String punto1= extra.getString("Puntos1");
            String punto2 = extra.getString("Puntos2");

            tv_nombre1.setText(""+ dato1);
            tv_nombre2.setText("" + dato2);
            tv_puntos1.setText(""+ punto1);
            tv_puntos2.setText(""+ punto2);
        }
    }

    public  void ganador(){
        double jugado1 = Double.parseDouble(tv_puntos1.getText().toString());
        double jugado2 = Double.parseDouble(tv_puntos2.getText().toString());
        if (jugado1 < jugado2){
            tv_ganador.setText(""+ tv_nombre1.getText().toString());
        }else if (jugado1 > jugado2){
            tv_ganador.setText(""+ tv_nombre2.getText().toString());
        }
    }

   public  void  nueva (){

       Intent intent = new Intent(MainFinal.this, MainMenu.class);
       startActivity(intent);
   }

    public  void  reiniciar(){
        Intent intent = new Intent(MainFinal.this, MainActivity.class);
        startActivity(intent);
    }

    public  void salir (){
      finish();

    }
    @Override
    public void onClick(View v) {
        if (v == btn_nueva){
           nueva();
            finish();
        }else if (v == btn_reiniciar){
           reiniciar();
            finish();
        }else  if (v == btn_salir){
           salir();
        }
    }
}