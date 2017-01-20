package com.example.hillarybriones.threadquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   private TextView change;
    private Switch switchChange;
    private Button btnTrue;
    private Button btnFalse;
    private TextView color;
    private TextView score,timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         change=(TextView) findViewById(R.id.etColor) ;
        color=(TextView)findViewById(R.id.mColor);
        score=(TextView)findViewById(R.id.etScore);
        timer=(TextView)findViewById(R.id.etTimer);
        btnTrue=(Button) findViewById(R.id.mbtnTrue);
        btnFalse=(Button) findViewById(R.id.mBtnFalse);
        switchChange=(Switch) findViewById(R.id.mSwitch);
        switchChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                   if(isChecked){
                       startTimer(200000);

                       Log.d("sud oy ","hoy");
                       Random rand=new Random();
                       int numBGColor=rand.nextInt(6-1) +1;
                       int numColText=rand.nextInt(6-1)+1;
                       String words=Integer.toString(numBGColor);
                       if(numBGColor==1){
                           change.setBackgroundColor(Color.BLUE);
                       }
                       else if(numBGColor==2){
                           change.setBackgroundColor(Color.GREEN);
                       }
                       else if(numBGColor==3){
                           change.setBackgroundColor(Color.RED);
                       }
                       else if(numBGColor==4){
                           change.setBackgroundColor(Color.YELLOW);
                       }
                       else if(numBGColor==5){
                           change.setBackgroundColor(Color.MAGENTA);
                       }
                       else{
                           change.setBackgroundColor(Color.GRAY);
                       }


                       if(numColText==1){
                           color.setText("Blue");
                       }
                       else if(numColText==2){
                           color.setText("Green");
                       }
                       else if(numColText==3){
                           color.setText("Red");
                       }
                       else if(numColText==4){
                           color.setText("Yellow");
                       }
                       else if(numColText==5){
                           color.setText("Magenta");
                       }
                       else{
                           color.setText("Gray");
                       }

                       int score=0;




                   }else {
                     //  btnFalse.setEnabled(false);
                     //  btnTrue.setEnabled(false);
                   }
            }
        });



    }


    private void startTimer(long time){
        CountDownTimer counter = new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilDone){

                Log.d("counter_label", "Counter text should be changed");
                timer.setText( ""+Math.round(millisUntilDone*0.001));
            }

            public void onFinish() {
                timer.setText("DONE!");

            }
        }.start();
    }

}


