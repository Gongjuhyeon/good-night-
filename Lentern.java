package com.example.goodnightapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Lentern extends AppCompatActivity {
    protected class MyView extends View {//커스텀 뷰 클래스 만들기
        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.RED);//수면 등 색 빨강
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Typeface tf;
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(60);
            tf=Typeface.createFromAsset(getAssets(),"cagaga.ttf");//asset을 이용하여 폰트 따오기
            paint.setTypeface(tf);//폰트 설정
            canvas.drawText("-> 화면 누르면 음악 서비스 재생",40,500,paint);
        }

        public boolean onTouchEvent(MotionEvent event) {//뷰의 ontouchevent를 사용하여

            if(event.getAction() == MotionEvent.ACTION_DOWN) {//눌렀을때 배경음악 재생
                setBackgroundColor(Color.DKGRAY);//누를때 밝은 빛이 나오니 배경을 다크 그레이로 설정 꾹누르고 있으면 눈 보호를 할 수 있다.
                AlertDialog.Builder adlg = new AlertDialog.Builder(Lentern.this);
                adlg.setTitle("MUSIC PLAY"); //제목
                final String[] versionArray = new String[] {"play","stop"};//리스트 대화 상자 만들기
                adlg.setIcon(R.drawable.sleeping); // 아이콘 설정
//                버튼 클릭시 동작
                adlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(versionArray[which]=="play"){//누른 요소와 문자열 같으면 재생
                            Intent intent = new Intent(Lentern.this, music.class);
                            startService(intent);
                        }
                        else if(versionArray[which]=="stop"){//stop
                            Intent intent = new Intent(Lentern.this, music.class);
                            stopService(intent);
                        }
                   }
                }
                );

                adlg.show();

            }
            if(event.getAction() == MotionEvent.ACTION_UP){
                Toast.makeText(getApplicationContext(),"뗐다",Toast.LENGTH_LONG);
                setBackgroundColor(Color.RED);//터치를 떼면 다시 돌아온다
            }


            invalidate();
            return true;
        }
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            MyView v = new MyView(this);
            setContentView(v);
        }

}