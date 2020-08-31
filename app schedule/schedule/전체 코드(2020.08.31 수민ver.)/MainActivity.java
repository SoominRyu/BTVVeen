package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //예현코드
    private TextView tv1;//일정제목
    private TextView tv2;//장소
    private TextView tv3;//추가 메시지
    //예현코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent lintent = new Intent(this, LoadingActivity.class); //수민코드(08.31)-로딩화면
        startActivity(lintent);//수민코드(08.31)-로딩화면

        ImageView imageView = (ImageView)findViewById(R.id.imageview);


        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page1); //page1은 그림 이름이야 drawable 안에 넣어줘야 함

        //예현코드
        Intent intent = getIntent();//받는다

        String title = intent.getStringExtra("title1");//String 데이타 받기
        tv1 = findViewById(R.id.TextView_title);//tv1(일정제목)
        tv1.setText(title);//받아 온 데이터 tv1 에 넣기

        String place = intent.getStringExtra("place1");//String 데이타 받기
        tv2 = findViewById(R.id.TextView_place);//tv2(장소)
        tv2.setText(place);//받아 온 데이터 tv2 에 넣기

        String content = intent.getStringExtra("content1");//String 데이타 받기
        tv3 = findViewById(R.id.TextView_content);//tv3(메세지)
        tv3.setText(content);//받아 온 데이터 tv3 에 넣기
        //예현코드

        //버튼 생성(activity_main)에서 확인 가능
        Button button=findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);
            }
        });



    }
}
