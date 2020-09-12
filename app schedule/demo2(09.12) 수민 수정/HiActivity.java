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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HiActivity extends AppCompatActivity {
    private EditText hi;
    private Button bnt_send;
    private ListView listView1;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = (ImageView)findViewById(R.id.imageview);
        // drawable 에 있는 이미지를 지정합니다.
        // imageView.setImageResource(R.drawable.hi); //이건 사진 이름
        setContentView(R.layout.activity_hi);
        hi = findViewById(R.id.EditText_hi);
        bnt_send = findViewById(R.id.btn_send);

        listItem = new ArrayList<String>();
        // 아이템 추가한다.
        bnt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listItem.add(hi.getText().toString());
                hi.setTextColor(Color.parseColor("#000000"));
                adapter.notifyDataSetChanged(); // 변경되었음을 어답터에 알려준다.
                hi.setText("");

            }
        });


        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item_1,listItem);
        //list_item_1 : 글자색 검정으로 변경 (수민추가 0912)

        listView1 = findViewById(R.id.listView1);

        // listView1.setTextColor(Color.parseColor("#000000"));
        listView1.setAdapter(adapter);

        // 각 아이템 클릭시 해당 아이템 삭제한다.
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 콜백매개변수는 순서대로 어댑터뷰, 해당 아이템의 뷰, 클릭한 순번, 항목의 아이디
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),listItem.get(i).toString() + " 삭제되었습니다.",Toast.LENGTH_SHORT).show();

                listItem.remove(i);
                adapter.notifyDataSetChanged();

            }

        });

        //

        Button bnt_back_hi=findViewById(R.id.btn_back_hi);
        bnt_back_hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HiActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_hi=findViewById(R.id.btn_menu_hi);
        bnt_menu_hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(HiActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button43 = (Button)findViewById(R.id.btntosearch3);
        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });


    }
}
