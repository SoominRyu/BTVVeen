package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
    }

}