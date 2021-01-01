package com.example.goodnightapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Clockview extends AppCompatActivity {
    private TimePicker timePicker1;
    int hhour,mmin;
    String format1;


    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

        timePicker1 = (TimePicker) findViewById(R.id.time);


        //TimePicker에서 시간이 변경될 때 마다 정보를 받을 수 있는 listener를 추가
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {

                showTime(hour, min);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)


    public void showTime(int hour, int min) {
        String format = "";
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        hhour=hour;
        mmin=min;
        format1=format;
        TextView thour = (TextView) findViewById(R.id.texthour);
        TextView tmin = (TextView) findViewById(R.id.textmin);
        TextView tvfm = (TextView) findViewById(R.id.fm);

        thour.setText(Integer.toString(hhour));
        tmin.setText(Integer.toString(mmin));
        tvfm.setText(format);

    }
    public void onsetting(View view) {

        Intent intent =new Intent(getApplicationContext(),recommend.class);
        intent.putExtra("시간",hhour);
        intent.putExtra("분",mmin);//시간과 분을 put하여 전달값을 넣는다.
        intent.putExtra("format",format1);
        startActivity(intent);

    }


}
