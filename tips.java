package com.example.goodnightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tips extends AppCompatActivity {


    ListView list;
    String[] titles = {"2분만에 꿀잠자는 꿀팁!->해파리 수면법","지나친 수면이 가져오는 `7가지 위험`","연령대별 적절한 수면 시간",
            "코로나 바이러스를 이기는 강력한 무기, 수면","'이건 몰랐지?' 꿈에 대한 놀라운 사실 5가지","불면증과 우울증의 관계"

    } ;
    Integer[] images = {R.drawable.sleeping,R.drawable.risk,R.drawable.timed,R.drawable.coronavirus,R.drawable.dream
            ,R.drawable.dd


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        CustomList adapter = new CustomList(tips.this);
        list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), titles[+position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(tips.this, listClicked.class);
                /* putExtra의 첫 값은 식별 태그, 뒤에는 다음 화면에 넘길 값 */
                String title1=titles[position];
                intent.putExtra("position", title1);
                startActivity(intent);


            }
        });
    }


    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context ) {
            super(context, R.layout.listview, titles);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.listview, null, true);
            ImageView image1 = (ImageView) rowView.findViewById(R.id.image1);
            TextView title = (TextView) rowView.findViewById(R.id.grade);
            title.setText(titles[position]);
            image1.setImageResource(images[position]);
            return rowView;
        }
    }


    }

