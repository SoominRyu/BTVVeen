package com.example.newpro;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class Sub3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner, spinner2, spinner3, spinner4, spinner5; // 시간 값 받아올 애들
    String str, str2, str3, str4, str5; // 스피너에서 값 받아올 애들


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);



        //spinner1
        spinner = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item); //item 배열로 가져옴 --> 배열로 선택한 값을 알아야해
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter); //어뎁터 수상해
        spinner.setOnItemSelectedListener(this); //이게 더 수상해 변수로 받아야하나?

        //  str= (String) spinner.getSelectedItem();
        // check_num = //여기서 에러가 남다

        //spinner2
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.numbers2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        //spinner3
        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.numbers3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        //spinner4
        spinner4 = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.numbers4, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(this);

        //spinner5
        spinner5 = findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.numbers5, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

        //spinner 값을 str로 받아옴
        str= (String) spinner.getSelectedItem(); //분
        str2= (String) spinner2.getSelectedItem(); //시간
        str3= (String) spinner3.getSelectedItem(); //일
        str4= (String) spinner4.getSelectedItem(); // 주
        str5= (String) spinner5.getSelectedItem(); // 월


        Button button1=findViewById(R.id.btn9);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(Sub3Activity.this,Sub2Activity.class);

                // intent.putExtra("check_num",check_num); // 분
                intent.putExtra("str",Integer.parseInt(str)); //정수형 변환후 전달
                intent.putExtra("str2",Integer.parseInt(str2));//정수형 변환후 전달
                intent.putExtra("str3",Integer.parseInt(str3));//정수형 변환후 전달
                intent.putExtra("str4",Integer.parseInt(str4));//정수형 변환후 전달
                intent.putExtra("str5",Integer.parseInt(str5));//정수형 변환후 전달
                //intent.putExtra("check_num2",check_num2); // 분

                startActivity(intent);
                // finish();
                //setResult(0,intent);
                // finish();
            }

        });
        //this.finish();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
