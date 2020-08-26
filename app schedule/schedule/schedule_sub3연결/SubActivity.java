package com.example.test_scr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity { //이 클래스 이름이 SubActivity
    private TextView tv;
    int rnum;
    private  String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ImageView imageView = (ImageView)findViewById(R.id.imageview);

        Intent intent = getIntent();//받는다
        rnum = intent.getIntExtra("rnum",0);

        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page2);//page2는 그림 이름

        if(rnum==1)
        {
            str="없음";
        }
        else if(rnum==2)
        {
            str="일정 시작 시간";
        }
        else if(rnum==3)
        {
            str="5분 전";
        }
        else if(rnum==4)
        {
            str="15분 전";
        }
        else if(rnum==5)
        {
            str="30분 전";
        }
        else if(rnum==6)
        {
            str="1시간 전";
        }
        else if(rnum==7)
        {
            str="1일 전";
        }
        else if(rnum==8)
        {
            str="1주 전";
        }

        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
        tv.setText(str);//받아 온 데이터 tv_second 에 넣기

        //버튼 설정
        // sub2로 이동
        Button button2=findViewById(R.id.btn2); //btn2라고 내가 생성한 거(activity_sub2에서 확인 가능)
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SubActivity.this, Sub2Activity.class);

                startActivity(intent);

                //    finish();//초기 화면으로 이동
            }
        });
        //main으로 이동
        Button button3=findViewById(R.id.btn4); //btn2라고 내가 생성한 거(activity_sub2에서 확인 가능)
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent);

                //    finish();//초기 화면으로 이동
            }
        });


    }
}
