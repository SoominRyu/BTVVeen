package com.example.test_scr; //여기 복사하지말고 원래 자기꺼 하기 

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

public class SubActivity extends AppCompatActivity { //이 클래스 이름이 SubActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ImageView imageView = (ImageView)findViewById(R.id.imageview);

        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page2);//page2는 그림 이름

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
