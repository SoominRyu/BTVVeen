package com.example.test_;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private Button btn_second;
    private EditText et_test;
    private String str;
    private RadioButton rbt0;
    private int rnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_test = findViewById(R.id.et_test);//et_test 아이디 찾기


        rbt0 = (RadioButton)findViewById(R.id.rbt0);//rbt0 아이디 찾기

        btn_second = findViewById(R.id.btn_second);// btn_second 버튼 아이디을 찾아 와라!
        btn_second.setOnClickListener(new View.OnClickListener()
        { //선언

            @Override
            public void onClick(View v) {//버튼을 눌렀을떄 second 이동 을 할꺼임
                str = et_test.getText().toString();// String 형태로 et_test 에 text 을 받아오겠다
                if(rbt0.isChecked())
                {
                    rnum=1;
                }
                else
                {
                    rnum=2;
                }


                //MainActivity 에서 SecondActivity 로 이동 경로
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("str", str);//str에있는 값을 가져 가겠다
                intent.putExtra("rnum", rnum);//rnum에있는 값을 가져 가겠다

                startActivity(intent);//액티비티 이동
            }
        });
    }
}