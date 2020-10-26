package com.example.newpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EmergencyActivity extends AppCompatActivity {


    private EditText emergency;
    private Button bntsend;
    private ListView listView2;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        emergency = findViewById(R.id.EditText_send);
        bntsend = findViewById(R.id.btntosend);

        listItem1 = new ArrayList<String>();
        // 아이템 추가한다.
        bntsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listItem1.add(emergency.getText().toString());
                emergency.setTextColor(Color.parseColor("#000000"));
                adapter.notifyDataSetChanged(); // 변경되었음을 어답터에 알려준다.
                emergency.setText("");

            }
        });


        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item_1,listItem1);
        //list_item_1 : 글자색 검정으로 변경 (수민추가 0912)

        listView2 = findViewById(R.id.listview2);

        // listView1.setTextColor(Color.parseColor("#000000"));
        listView2.setAdapter(adapter);

        // 각 아이템 클릭시 해당 아이템 삭제한다.
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 콜백매개변수는 순서대로 어댑터뷰, 해당 아이템의 뷰, 클릭한 순번, 항목의 아이디
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),listItem1.get(i).toString() + " 삭제되었습니다.",Toast.LENGTH_SHORT).show();

                listItem1.remove(i);
                adapter.notifyDataSetChanged();

            }

        });








        Button bnt_back_emergency=findViewById(R.id.btn_back_emergency);
        bnt_back_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(EmergencyActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_emergency=findViewById(R.id.btn_menu_emergency);
        bnt_menu_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(EmergencyActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });


    }
}

