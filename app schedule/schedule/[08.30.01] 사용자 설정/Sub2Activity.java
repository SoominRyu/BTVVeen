package com.example.test_scr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class Sub2Activity extends AppCompatActivity {
    int rnum = 0;
    private RadioButton rbt0, rbt1, rbt2, rbt3, rbt4, rbt5, rbt6, rbt7, rbt8;
    private TextView tv;
    String str_num;
    int num, num2, num3, num4, num5;
    // private RadioButton rbt1;
    //  private RadioGroup grb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        ImageView imageView = (ImageView) findViewById(R.id.imageview2);

        //radio button 찾기
        rbt0 = (RadioButton) findViewById(R.id.radio0);//rbt0 아이디 찾기
        rbt1 = (RadioButton) findViewById(R.id.radio1);//rbt1 아이디 찾기
        rbt2 = (RadioButton) findViewById(R.id.radio2);//rbt2 아이디 찾기
        rbt3 = (RadioButton) findViewById(R.id.radio3);//rbt3 아이디 찾기
        rbt4 = (RadioButton) findViewById(R.id.radio4);//rbt4 아이디 찾기
        rbt5 = (RadioButton) findViewById(R.id.radio5);//rbt5 아이디 찾기
        rbt6 = (RadioButton) findViewById(R.id.radio6);//rbt6 아이디 찾기
        rbt7 = (RadioButton) findViewById(R.id.radio7);//rbt7 아이디 찾기
        rbt8 = (RadioButton) findViewById(R.id.radio8);//rbt7 아이디 찾기
        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page3); //page1은 그림 이름이야 drawable 안에 넣어줘야 함


        //sub3으로 이동
        Button button1 = findViewById(R.id.btn4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent = new Intent(Sub2Activity.this, Sub3Activity.class);
                startActivity(intent);
            }
        });

        //sub3에서 사용자 설정을 받아올꺼야
        Intent intent = getIntent();//받는다

        num = intent.getIntExtra("str", -1); //분
        num2 = intent.getIntExtra("str2", -1); //ㅅㅣ
        num3 = intent.getIntExtra("str3", -1); //일
        num4 = intent.getIntExtra("str4", -1); //주
        num5 = intent.getIntExtra("str5", -1); //월
        //받아온거 뿌려주기
        tv = findViewById(R.id.tv);//tv_second 아이디 찾기
        str_num=""; //뿌려줄 애들

        //며칠전에 울릴지 출력을 위해 설정
        if(num5>0) str_num=String.valueOf(num5)+"월 ";
        if(num4>0) str_num+=String.valueOf(num4)+"주 ";
        if(num3>0) str_num+=String.valueOf(num3)+"일 ";
        if(num2>0)
        {
            str_num+=String.valueOf(num2)+"시 ";
            str_num+=String.valueOf(num)+"분 ";
        }
        if(num2==0 && num>0) str_num+=String.valueOf(num)+"분 ";
        if (num > 0 || num > 0 || num > 0 || num >0  || num > 0) str_num+="전";




        if (num > -1 || num > -1 || num > -1 || num > -1  || num > -1) {
           // tv.setText("" + num2+"시"+num+"분");//받아 온 데이터 tv_second 에 넣기, 디폴트보다 큰지 안큰지 확인
            str_num+="전";
            tv.setText(str_num);
            rbt8.setChecked(true);
            rnum=9;

        }
        //버튼 생성(activity_main)에서 확인 가능
        Button button = findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent = new Intent(Sub2Activity.this, SubActivity.class);


                //버튼 클릭이 되었나
                if (rbt0.isChecked()) {
                    rnum = 1;
                } else if (rbt1.isChecked()) {
                    rnum = 2;
                } else if (rbt2.isChecked()) {
                    rnum = 3;
                } else if (rbt3.isChecked()) {
                    rnum = 4;
                } else if (rbt4.isChecked()) {
                    rnum = 5;
                } else if (rbt5.isChecked()) {
                    rnum = 6;
                } else if (rbt6.isChecked()) {
                    rnum = 7;
                } else if (rbt7.isChecked()) {
                    rnum = 8;
                }

                if(rnum==9)
                {
                    if(num5>-1) intent.putExtra("num5", num5);
                    if(num4>-1) intent.putExtra("num4", num4);
                    if(num3>-1) intent.putExtra("num3", num3);
                    if(num2>-1) intent.putExtra("num2", num2);
                    if(num>-1) intent.putExtra("num", num);
                }

                intent.putExtra("rnum", rnum);//rnum에있는 값을 가져 가겠다

                startActivity(intent);
            }
        });

    }
}
