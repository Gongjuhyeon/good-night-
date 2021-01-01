package com.example.goodnightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class recommend2 extends AppCompatActivity {
    TextView hour1;
    TextView min1;
    TextView hour2;
    TextView min2;
    TextView hour3;
    TextView min3;
    TextView hour4;
    TextView min4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend2);

        Intent intent=getIntent();
        Integer hour=intent.getIntExtra("시간",0);
        Integer min=intent.getIntExtra("분",0);
        String format=intent.getStringExtra("format");

        hour1= (TextView)findViewById(R.id.texthour);
        min1=(TextView)findViewById(R.id.textmin);
        hour2= (TextView)findViewById(R.id.texthour2);
        min2=(TextView)findViewById(R.id.textmin2);
        hour3= (TextView)findViewById(R.id.texthour6);
        min3=(TextView)findViewById(R.id.textmin3);
        hour4= (TextView)findViewById(R.id.texthour8);
        min4=(TextView)findViewById(R.id.textmin4);
        hour1.setText(Integer.toString(hour));
        min1.setText(Integer.toString(min));
        showTime1(hour, min);
        showTime2(hour,min);
        showTime3(hour,min);

    }
    public void showTime1(int hour ,int min){

        int a=hour-3;
        int b=min-14;
        if(a<=0){
            a+=12;
            b+=0;
            if(b<0) {
                b += 60;
                if(a==0){
                    a=+12;
                }
            }


        }
        else if(a>0){
            a+=0;
            b+=0;
            if(b<0) {
                a -= 1;
                b += 60;
                if(a==0){
                    a=+12;
                }
            }
        }
        hour2.setText(Integer.toString(a));
        min2.setText(Integer.toString(b));


    }
    public void showTime2(int hour ,int min){

        hour-=4;
        min-=44;

        if(hour<=0){
            hour+=12;
            min+=0;
                if(min<0) {
                    min += 60;
                    if(hour==0){
                        hour=+12;
                }
            }


        }
        else if(hour>0){
            hour+=0;
            min+=0;
            if(min<0) {
                hour -= 1;
                min += 60;
                if(hour==0){
                    hour=+12;
                }
            }
        }

        hour3.setText(Integer.toString(hour));
        min3.setText(Integer.toString(min));


    }
    public void showTime3(int hour ,int min){

        hour-=6;
        min-=14;
        if(hour<=0){
            hour+=12;
            min+=0;
            if(min<0) {
                min += 60;
                if(hour==0){
                    hour=+12;
                }
            }


        }
        else if(hour>0){
            hour+=0;
            min+=0;
            if(min<0) {
                hour -= 1;
                min += 60;
                if(hour==0){
                    hour=+12;
                }
            }
        }
        hour4.setText(Integer.toString(hour));
        min4.setText(Integer.toString(min));


    }
}