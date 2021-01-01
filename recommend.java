package com.example.goodnightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class recommend extends AppCompatActivity {
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
        setContentView(R.layout.activity_recommend);
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

        int a=hour+3;//90분을 두번 더했다.
        int b=min+14;//잠드는 시간이 14분 정도 된다.(평균)

        if(b==60){
            a+=1;
            b=0;
            if(a>12){
                a-=12;
            }
        }
        else if(b>60){
            a+=1;
            b-=60;
            if(a>12){
                a-=12;
            }
        }
        hour2.setText(Integer.toString(a));
        min2.setText(Integer.toString(b));


    }
    public void showTime2(int hour ,int min){

        hour+=4;
        min+=44;

        if(min==60){
            hour+=1;
            min=0;
            if(hour>12){
                hour-=12;
            }
        }
        else if(min>60){
            hour+=1;
            min-=60;
            if(hour>12){
                hour-=12;
            }
        }
        hour3.setText(Integer.toString(hour));
        min3.setText(Integer.toString(min));


    }
    public void showTime3(int hour ,int min){

        hour+=6;
        min+=14;
        if(min==60){
            hour+=1;
            min=0;
            if(hour>12){
                hour-=12;
            }
        }
        else if(min>60){
            hour+=1;
            min-=60;
            if(hour>12){
                hour-=12;
            }
        }
        hour4.setText(Integer.toString(hour));
        min4.setText(Integer.toString(min));


    }
}