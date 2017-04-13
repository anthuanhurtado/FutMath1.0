package com.example.anthony.futmath10;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_result1;
    Button btn_result2;
    Button btn_result3;
    Button btn_result4;
    TextView tv_num1, tv_num2,tv_operador, tv_puntos, tv_player;
    TextView tv_num3, tv_num4,tv_operador2, tv_puntos2, tv_player2;
    String[] operadores = {"*" , "+","/","-"};
    String[] numeros ={"1","2","3","4","5","6","7","8","9","10"};
    int operador, num_1, num_2, puntos;
    double result,a;
    MediaPlayer fondo = new MediaPlayer();
    String nom1, nom2, puntos1, puntos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_result1 =(Button)findViewById(R.id.btn_result1);
        btn_result2 =(Button)findViewById(R.id.btn_result2);
        btn_result3 =(Button)findViewById(R.id.btn_result3);
        btn_result4 =(Button)findViewById(R.id.btn_result4);
        btn_result1.setOnClickListener(this);
        btn_result2.setOnClickListener(this);
        btn_result3.setOnClickListener(this);
        btn_result4.setOnClickListener(this);

        tv_num1 = (TextView)findViewById(R.id.tv_num1);
        tv_num2 = (TextView)findViewById(R.id.tv_num2);
        tv_operador = (TextView)findViewById(R.id.tv_operador);
        tv_player = (TextView)findViewById(R.id.tv_player1);
        tv_puntos = (TextView)findViewById(R.id.tv_puntos);

        tv_num3 = (TextView)findViewById(R.id.tv_num3);
        tv_num4 = (TextView)findViewById(R.id.tv_num4);
        tv_operador2 = (TextView)findViewById(R.id.tv_operador2);
        tv_player2 = (TextView)findViewById(R.id.tv_player2);
        tv_puntos2 = (TextView)findViewById(R.id.tv_puntos2);
        fondo = MediaPlayer.create(this,R.raw.fondo);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if (extra != null) {
            String dato1 = extra.getString("Nombre1");
            String dato2 = extra.getString("Nombre2");
            tv_player.setText(""+ dato1);
            tv_player2.setText("" + dato2);
        }
        fondo.start();
    }

    public void genera_number(){
        operador = (int) Math.round(Math.random() * 4);
        num_1 = (int) Math.round(Math.random() * 10);
        num_2 = (int) Math.round(Math.random() * 10);
        tv_operador.setText(""+ operadores[operador] );
        tv_operador2.setText(""+operadores[operador]);
        tv_num1.setText(""+ numeros[num_1]);
        tv_num2.setText(""+ numeros[num_2]);
        tv_num3.setText(""+ numeros[num_1]);
        tv_num4.setText(""+ numeros[num_2]);
    }

    public void validacion_result1(){
        String val1 = tv_num1.getText().toString();
        String val2 = tv_num2.getText().toString();
        Double num1 = Double.parseDouble(val1);
        Double num2 = Double.parseDouble(val2);
        String oper = tv_operador.getText().toString();
        puntos = Integer.parseInt(tv_puntos.getText().toString());

        if (oper.equals("+")) {
            result= num1 + num2;
        } else if (oper.equals("*")){
            result = num1 * num2;
        }else if (oper.equals("-")){
            result = num1 - num2;
        }else if (oper.equals("/")){
            result = num1 / num2;
        }
        a=result-1;

        double [] resultad ={a,result};
        int r1 = (int) Math.round(Math.random()*1);
        int r2 =(int) Math.round(Math.random()*1);
        if (r1 == r2 && r2==result) {
            btn_result1.setText("" + resultad[r1-1]);
            btn_result3.setText("" + resultad[r1-1]);
        }else if (r1 == r2 && r1==result) {
            btn_result2.setText("" + resultad[r2-1]);
            btn_result4.setText("" + resultad[r2-1]);
        }else {
            btn_result1.setText("" + resultad[r1]);
            btn_result2.setText("" + resultad[r2]);
            btn_result3.setText("" + resultad[r1]);
            btn_result4.setText("" + resultad[r2]);
        }
        double resultado1 = Double.parseDouble(btn_result1.getText().toString());

        if (result == resultado1){
            tv_puntos.setText(""+ ( puntos + 1));
        }else if(result != resultado1){
            tv_puntos.setText(""+ (puntos - 1));
        }
    }

    public void validacion_result2(){
        String val1 = tv_num1.getText().toString();
        String val2 = tv_num2.getText().toString();
        float num1 = Float.parseFloat(val1);
        float num2 = Float.parseFloat(val2);
        String oper = tv_operador.getText().toString();
        puntos = Integer.parseInt(tv_puntos.getText().toString());


        if (oper.equals("+")) {
            result= num1 + num2;
        } else if (oper.equals("*")){
            result = num1 * num2;
        }else if (oper.equals("-")){
            result = num1 - num2;
        }else if (oper.equals("/")){
            result = num1 / num2;
        }
        a=result-1;

        double [] resultad ={a,result};
        int r1 = (int) Math.round(Math.random()%1);
        int r2 =(int) Math.round(Math.random()*1);

        btn_result1.setText(""+ resultad [r1]);
        btn_result2.setText(""+resultad [r2]);
        btn_result3.setText(""+resultad[r1]);
        btn_result4.setText(""+resultad[r2]);
        double resultado2 = Double.parseDouble(btn_result2.getText().toString());

        if (result == resultado2){
            tv_puntos.setText(""+ ( puntos + 1));
        }else{
            tv_puntos.setText(""+ (puntos - 1));
        }
    }

    public void validacion_result3(){
        String val1 = tv_num1.getText().toString();
        String val2 = tv_num2.getText().toString();
        float num1 = Float.parseFloat(val1);
        float num2 = Float.parseFloat(val2);
        String oper = tv_operador.getText().toString();
        puntos = Integer.parseInt(tv_puntos2.getText().toString());

        if (oper.equals("+")) {
            result= num1 + num2;
        } else if (oper.equals("*")){
            result = num1 * num2;
        }else if (oper.equals("-")){
            result = num1 - num2;
        }else if (oper.equals("/")){
            result = num1 / num2;
        }
        a=result-1;

        double [] resultad ={a,result};
        int r1 = (int) Math.round(Math.random()*1);
        int r2 =(int) Math.round(Math.random()*1);

        btn_result1.setText(""+ resultad [r1]);
        btn_result2.setText(""+resultad [r2]);
        btn_result3.setText(""+resultad[r1]);
        btn_result4.setText(""+resultad[r2]);
        double resultado3 = Double.parseDouble(btn_result3.getText().toString());

        if (result == resultado3){
            tv_puntos2.setText(""+ ( puntos + 1));
        }else{
            tv_puntos2.setText(""+ (puntos - 1));
        }
    }

    public void validacion_result4(){
        String val1 = tv_num1.getText().toString();
        String val2 = tv_num2.getText().toString();
        float num1 = Float.parseFloat(val1);
        float num2 = Float.parseFloat(val2);
        String oper = tv_operador.getText().toString();
        puntos = Integer.parseInt(tv_puntos2.getText().toString());

        if (oper.equals("+")) {
            result= num1 + num2;
        } else if (oper.equals("*")){
            result = num1 * num2;
        }else if (oper.equals("-")){
            result = num1 - num2;
        }else if (oper.equals("/")){
            result = num1 / num2;
        }
        a=result-1;

        double [] resultad ={a,result};
        int r1 = (int) Math.round(Math.random()%1);
        int r2 =(int) Math.round(Math.random()*1);

        btn_result1.setText(""+ resultad [r1]);
        btn_result2.setText(""+resultad [r2]);
        btn_result3.setText(""+resultad[r1]);
        btn_result4.setText(""+resultad[r2]);
        double resultado4 = Double.parseDouble(btn_result4.getText().toString());

        if (result == resultado4){
            tv_puntos2.setText(""+ ( puntos + 1));
        }else{
            tv_puntos2.setText(""+ (puntos - 1));
        }
    }

   public  void termina (){
       finish();
       nom1 = tv_player.getText().toString();
       nom2 = tv_player2.getText().toString();
       puntos1 = tv_puntos.getText().toString();
       puntos2= tv_puntos2.getText().toString();
       Intent intent = new Intent(MainActivity.this, MainFinal.class);
       intent.putExtra("Nombre1", nom1);
       intent.putExtra("Nombre2", nom2);
       intent.putExtra("Puntos1", puntos1);
       intent.putExtra("Puntos2", puntos2);
       fondo.stop();
       startActivity(intent);
   }

    @Override
    public void onClick(View v) {
        try {
            if (v == btn_result1) {
                fondo.start();
                genera_number();
                validacion_result1();

            }else if (v == btn_result2) {
                genera_number();
                validacion_result2();

            }
            else if (v == btn_result3) {
                genera_number();
                validacion_result3();

            }else if (v == btn_result4) {
                genera_number();
                validacion_result4();

            }
        }catch (Exception e){

        }
    }
}