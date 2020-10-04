package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button bnt_schedule=findViewById(R.id.btn_schedule);
        bnt_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button bnt_med=findViewById(R.id.btn_med);
        bnt_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MenuActivity.this,MedActivity.class);
                startActivity(intent);
            }
        });

        Button bnt_hi=findViewById(R.id.btn_hi);
        bnt_hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MenuActivity.this,HiActivity.class);
                startActivity(intent);
            }
        });

        Button bnt_emergency=findViewById(R.id.btn_emergency);
        bnt_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MenuActivity.this,EmergencyActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_home=findViewById(R.id.btn_home);
        bnt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MenuActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button45 = (Button)findViewById(R.id.btntomypage);
        button45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });
        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button46 = (Button)findViewById(R.id.btntoout2);
        button46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });
    }

}
