package com.example.anthony.futmath10;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{
    Button btn_aceptar;
    Button btn_cancelar;
    EditText text_nombre1;
    EditText text_nombre2;
    String nom1, nom2;

    MediaPlayer inicio = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btn_aceptar= (Button)findViewById(R.id.btn_aceptar);
        btn_cancelar= (Button)findViewById(R.id.btn_cancelar);

        text_nombre1=(EditText)findViewById(R.id.text_nombre1);
        text_nombre2=(EditText)findViewById(R.id.text_nombre2);

        btn_aceptar.setOnClickListener(this);
        btn_cancelar.setOnClickListener(this);
        inicio = MediaPlayer.create(this, R.raw.inicio);
        inicio.start();
        inicio.start();
    }

    public void envia (){
        nom1 = text_nombre1.getText().toString();
        nom2 = text_nombre2.getText().toString();
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        intent.putExtra("Nombre1", nom1);
        intent.putExtra("Nombre2", nom2);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v== btn_aceptar){
            finish();
            envia();
            inicio.stop();
            MainInicio inicio  =  new MainInicio();
            inicio.finish();

        }else if(v == btn_cancelar){
             finish();
            inicio.stop();
        }

    }
}
