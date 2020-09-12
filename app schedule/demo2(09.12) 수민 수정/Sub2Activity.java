package com.example.newpro;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;



public class Sub2Activity extends AppCompatActivity {
    int rnum;
    private RadioButton rbt0, rbt1, rbt2, rbt3, rbt4, rbt5, rbt6, rbt7;
    // private RadioButton rbt1;
    //  private RadioGroup grb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        ImageView imageView = (ImageView)findViewById(R.id.imageview2);

        //radio button 찾기
        rbt0 = (RadioButton)findViewById(R.id.radio0);//rbt0 아이디 찾기
        rbt1 = (RadioButton)findViewById(R.id.radio1);//rbt1 아이디 찾기
        rbt2 = (RadioButton)findViewById(R.id.radio2);//rbt2 아이디 찾기
        rbt3 = (RadioButton)findViewById(R.id.radio3);//rbt3 아이디 찾기
        rbt4 = (RadioButton)findViewById(R.id.radio4);//rbt4 아이디 찾기
        rbt5 = (RadioButton)findViewById(R.id.radio5);//rbt5 아이디 찾기
        rbt6 = (RadioButton)findViewById(R.id.radio6);//rbt6 아이디 찾기
        rbt7 = (RadioButton)findViewById(R.id.radio7);//rbt7 아이디 찾기


        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page3); //page1은 그림 이름이야 drawable 안에 넣어줘야 함


        /*
        //sub3으로 이동
        Button button1=findViewById(R.id.btn4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(Sub2Activity.this,Sub3Activity.class);
                startActivity(intent);
            }
        });*/



        //버튼 생성(activity_main)에서 확인 가능
        Button button=findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent data =new Intent(Sub2Activity.this,SubActivity.class);

                if(rbt0.isChecked())
                {
                    rnum=1;
                }
                else if(rbt1.isChecked())
                {
                    rnum=2;
                }
                else if(rbt2.isChecked())
                {
                    rnum=3;
                }
                else if(rbt3.isChecked())
                {
                    rnum=4;
                }
                else if(rbt4.isChecked())
                {
                    rnum=5;
                }
                else if(rbt5.isChecked())
                {
                    rnum=6;
                }
                else if(rbt6.isChecked())
                {
                    rnum=7;
                }
                else if(rbt7.isChecked())
                {
                    rnum=8;
                }


                //수민 코드(2020.08.29)
                data.putExtra("rnum", rnum);//rnum에있는 값을 가져 가겠다

                setResult(0, data); //수민 코드(2020.08.29)

                finish(); //수민 코드(2020.08.29)
            }
        });


    }
}
