package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv1;//일정제목
    private TextView tv2;//장소
    private TextView tv3;//추가 메시지

    private TextView tv1_2;//일정제목
    private TextView tv2_2;//장소
    private TextView tv3_2;//추가 메시지

    private TextView tv1_3;//일정제목
    private TextView tv2_3;//장소
    private TextView tv3_3;//추가 메시지

    private TextView ck;//추가 메시지
    int ck_main=0;
    //    String str1=null, str2=null, str3=null;
    String title, place, content;
    String title_2, place_2, content_2;
    String title_3, place_3, content_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();//받는다

        ck_main=intent.getIntExtra("ck_sub",0);//sub에서 가져온애

        title = intent.getStringExtra("title1");//String 데이타 받기
        place = intent.getStringExtra("place1");//String 데이타 받기
        content = intent.getStringExtra("content1");//String 데이타 받기

        title_2 = intent.getStringExtra("title1_2");//String 데이타 받기
        place_2 = intent.getStringExtra("place1_2");//String 데이타 받기
        content_2 = intent.getStringExtra("content1_2");//String 데이타 받기

        title_3 = intent.getStringExtra("title1_3");//String 데이타 받기
        place_3 = intent.getStringExtra("place1_3");//String 데이타 받기
        content_3 = intent.getStringExtra("content1_3");//String 데이타 받기



        if(ck_main==1)
        {

            tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
            tv1.setText(title);//받아 온 데이터 tv1 에 넣기

            tv2 = findViewById(R.id.TextView_place);//tv2(장소)
            tv2.setText(place);//받아 온 데이터 tv2 에 넣기

            tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
            tv3.setText(content);//받아 온 데이터 tv3 에 넣기




        }
        else if(ck_main==2)
        {
            tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
            tv1.setText(title);//받아 온 데이터 tv1 에 넣기

            tv2 = findViewById(R.id.TextView_place);//tv2(장소)
            tv2.setText(place);//받아 온 데이터 tv2 에 넣기

            tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
            tv3.setText(content);//받아 온 데이터 tv3 에 넣기

            tv1_2 = findViewById(R.id.TextView_title2);//tv1(일정제목)
            tv1_2.setText(title_2);//받아 온 데이터 tv1 에 넣기

            tv2_2 = findViewById(R.id.TextView_place2);//tv2(장소)
            tv2_2.setText(place_2);//받아 온 데이터 tv2 에 넣기

            tv3_2 = findViewById(R.id.TextView_content2);//tv3(메세지)
            tv3_2.setText(content_2);//받아 온 데이터 tv3 에 넣기
        }
        else if(ck_main==3)
        {
            tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
            tv1.setText(title);//받아 온 데이터 tv1 에 넣기

            tv2 = findViewById(R.id.TextView_place);//tv2(장소)
            tv2.setText(place);//받아 온 데이터 tv2 에 넣기

            tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
            tv3.setText(content);//받아 온 데이터 tv3 에 넣기
            // /*------------------------------------------------------------------------*/
            tv1_2 = findViewById(R.id.TextView_title2);//tv1(일정제목)
            tv1_2.setText(title_2);//받아 온 데이터 tv1 에 넣기

            tv2_2 = findViewById(R.id.TextView_place2);//tv2(장소)
            tv2_2.setText(place_2);//받아 온 데이터 tv2 에 넣기

            tv3_2 = findViewById(R.id.TextView_content2);//tv3(메세지)
            tv3_2.setText(content_2);//받아 온 데이터 tv3 에 넣기
            /*------------------------------------------------------------------------*/
            tv1_3 = findViewById(R.id.TextView_title3);//tv1(일정제목)
            tv1_3.setText(title_3);//받아 온 데이터 tv1 에 넣기

            tv2_3 = findViewById(R.id.TextView_place3);//tv2(장소)
            tv2_3.setText(place_3);//받아 온 데이터 tv2 에 넣기

            tv3_3 = findViewById(R.id.TextView_content3);//tv3(메세지)
            tv3_3.setText(content_3);//받아 온 데이터 tv3 에 넣기
        }



        //버튼 생성(activity_main)에서 확인 가능
        Button button=findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                ck_main++;

//                ck = findViewById(R.id.check);//tv1(일정제목)
//                ck.setText(""+ck_main);//받아 온 데이터 tv1 에 넣기

                intent.putExtra("next_title", title);
                intent.putExtra("next_place", place);
                intent.putExtra("next_content", content);

                intent.putExtra("next_title_2", title_2);
                intent.putExtra("next_place_2", place_2);
                intent.putExtra("next_content_2", content_2);

                //보내고 ->받는거 사이에 문제가 있어
                intent.putExtra("ck_main", ck_main);

                startActivity(intent);
            }
        });
        ImageView imageView = (ImageView)findViewById(R.id.imageview);


        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page1); //page1은 그림 이름이야 drawable 안에 넣어줘야 함

        Button bnt_back_main=findViewById(R.id.btn_menu_main);
        bnt_back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_main=findViewById(R.id.btn_menu_main);
        bnt_menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });






    }
}
