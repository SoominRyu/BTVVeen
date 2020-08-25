package com.example.test_scr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;

import android.view.View;
import android.widget.Button;



public class Sub2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        ImageView imageView = (ImageView)findViewById(R.id.imageview2);

        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page3); //page1은 그림 이름이야 drawable 안에 넣어줘야 함

        //버튼 생성(activity_main)에서 확인 가능
        Button button=findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(Sub2Activity.this,SubActivity.class);
                startActivity(intent);
            }
        });


    }
}
