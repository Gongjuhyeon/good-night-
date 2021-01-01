package com.example.goodnightapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;//레이아웃 변수 설정
    ImageView image=null;//아이콘 변수 설정
    int count=0;//배경색 누른 횟수
    int count1=0;//아이콘 누른 횟수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=(ConstraintLayout)findViewById(R.id.mainlayout);//배경 아이디 가져오기
        image = (ImageView)findViewById(R.id.imageView5);

        }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item:
                if(count%2==0){
                layout.setBackgroundResource(R.drawable.gradient1);//처음 눌렀을때 나누기 할시 0이면
                Toast.makeText(this, "배경색이 바꼈습니다.", Toast.LENGTH_SHORT).show();
                count++;}
                else if (count % 2 == 1) {
                    layout.setBackgroundResource(R.drawable.gradientt);//두번째 눌렀을 때 1이면
                    Toast.makeText(this, "배경색이 바꼈습니다.", Toast.LENGTH_SHORT).show();
                    count++;
                }

                return true;

            case R.id.item2:
                if(count1%2==0){
                    image.setImageResource(R.drawable.sleepbaby);//처음 눌렀을때 나누기 할시 0이면
                    Toast.makeText(this, "아이콘이 바꼈습니다.", Toast.LENGTH_SHORT).show();
                    count1++;}
                else if (count1% 2 == 1) {
                    image.setImageResource(R.drawable.staraststa);//두번째 눌렀을 때 1이면
                    Toast.makeText(this, "아이콘이 바꼈습니다.", Toast.LENGTH_SHORT).show();
                    count1++;
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onClicked1(View v){
        Intent intent =new Intent(getApplicationContext(),Clockview.class);
        startActivity(intent);

    }
    public void onClicked2(View v){
        Intent intent =new Intent(getApplicationContext(),Clockview1.class);
        startActivity(intent);

    }
    public void onClicked3(View v){
        Intent intent =new Intent(getApplicationContext(),graph.class);
        startActivity(intent);

    }
    public void onClicked4(View v){
        Intent intent =new Intent(getApplicationContext(),Lentern.class);
        startActivity(intent);
    }
    public void onClicked5(View v){
        Intent intent =new Intent(getApplicationContext(),tips.class);
        startActivity(intent);
    }


}