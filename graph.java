package com.example.goodnightapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;



import java.util.ArrayList;


public class graph extends AppCompatActivity {
    EditText age;
    EditText time;
    BarChart bar;
    double a;
    int b;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        bar=(BarChart)findViewById(R.id.chart);
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void clicktime(View view){
        time=(EditText)findViewById(R.id.sleeptime);
        age=(EditText)findViewById(R.id.age);
        a=Float.parseFloat(time.getText().toString());
        b=Integer.parseInt(age.getText().toString());
        if(b<20&&b>10&&a>8.43){
            Toast.makeText(this,"나이에 비해 수면 시간이 많습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"나이에 비해 수면 시간이 적습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        if(b<30&&b>20&&a>8.27){
            Toast.makeText(this,"나이에 비해 수면 시간이 많습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"나이에 비해 수면 시간이 적습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        if(b<40&&b>30&&a>8.14){
            Toast.makeText(this,"나이에 비해 수면 시간이 많습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"나이에 비해 수면 시간이 적습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        if(b<50&&b>40&&a>7.57){
            Toast.makeText(this,"나이에 비해 수면 시간이 많습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"나이에 비해 수면 시간이 적습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        if(b<60&&b>50&&a>7.48){
            Toast.makeText(this,"나이에 비해 수면 시간이 많습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"나이에 비해 수면 시간이 적습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        if(b<150&&b>60&&a>8.18){
            Toast.makeText(this,"나이에 비해 수면 시간이 많습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"나이에 비해 수면 시간이 적습니다.수면은 신체 회복 기능을 높입니다.",Toast.LENGTH_LONG).show();
        }

        drawChart((float)a,b);

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    private void drawChart(float a, int b){

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(10, 8.43f));//10대 평균
        entries.add(new BarEntry(20, 8.27f));//20대 평균
        entries.add(new BarEntry(30, 8.14f));//30대 평균
        entries.add(new BarEntry(40, 7.57f));//40대 평균
        entries.add(new BarEntry(50, 7.48f));//50대 평균
        entries.add(new BarEntry(60, 8.18f));//60대 평균
        entries.add(new BarEntry(b,a));



        BarDataSet barDataSet = new BarDataSet(entries, "자신의 나이를 찾으세요. 그리고 비교하세요");

        BarData data = new BarData(barDataSet);
        int[] colors = new int[] {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW,Color.RED};
        barDataSet.setColor(Color.RED);
        barDataSet.setColors(colors);//color 설정
        bar.setData(data);
        bar.setFitBars(false);
        bar.animateXY(1000,100);
        bar.invalidate();//다시 시작 시 초기화

    }


   }