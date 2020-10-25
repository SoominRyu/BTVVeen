package com.example.newpro;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;


//import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    EditText title1, content1, place1;
    ListView listView;
    ListViewAdapter listViewAdapter;
    TextView tv;
    ArrayList<ListItem> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();//받는다

        tv=findViewById(R.id.tv);



        //Get 방식 1
        String serverUrl = "http://15.164.218.79:8080/test_table/testtable_2.jsp";



        //String getUrl = serverUrl + "?title1=" + title1 + "&place1=" + place1 + "&content1=" + content1  ;
        String getUrl = serverUrl;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //while문으로 line해서 읽어오는 작업과 UI에 업데이트하는 runOnUiThread도 안만들어도 된다.

                String[] arr = response.split("/");

/*
                String arr2 = "";
                for(int i=0;i<arr.length;i++) {
                    arr2 += arr[i];
                }
                tv.setText(arr2);
*/
                int i =0;
                String Array[][] = new String[20][8];

                for(int j=0; j<8; j++)
                    Array[0][j] = "";

                for(i=1; i<= (arr.length)/8;i++){
                    for(int j=0; j<8 ; j++)
                        Array[i][j] = arr[j+(i-1)*8];
                }


                //tv.setText(Array[3][5]);
                list = new ArrayList<>();
                listView = (ListView)findViewById(R.id.listView);

                for(int k=1 ; k<(arr.length)/8;k++){
                    list.add(new ListItem(Array[k][1],Array[k][2],Array[k][3],Array[k][4],Array[k][5]));
                }
                listViewAdapter= new ListViewAdapter(getApplicationContext(), list);
                listView.setAdapter(listViewAdapter);



            }




        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

            }
        });
        //서버와 데이터를 주고 받는 요청 객체를
        //서버로 보내줄 우체통 같은 역할의 객체
        //요청큐(RequestQueue)
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //우체통에 요청 편지 넣기
        //요청큐에 요청 객체 추가..
        requestQueue.add(stringRequest);



        //버튼 생성(activity_main)에서 확인 가능
        Button button=findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,SubActivity.class);


                startActivity(intent);
            }
        });
        ImageView imageView = (ImageView)findViewById(R.id.imageview);


        // drawable에 있는 이미지를 지정합니다.
        imageView.setImageResource(R.drawable.page1); //page1은 그림 이름이야 drawable 안에 넣어줘야 함

        Button bnt_back_main=findViewById(R.id.btn_back_main);
        bnt_back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Button bnt_menu_main=findViewById(R.id.btn_menu_main);
        bnt_menu_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트를 통해 main-sub 연결
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        //Toast 메세지 : 서비스 준비 중 (수민 수정 09.12)
        Button button44 = (Button)findViewById(R.id.btntosearch4);
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "서비스 준비 중입니다.", Toast.LENGTH_LONG).show();
            }
        });





    }

    private class ListViewAdapter extends BaseAdapter{
        private final List<ListItem> list;
        private final LayoutInflater inflater;

        private ListViewAdapter(Context context, ArrayList<ListItem> list){
            this.list= list;
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            if( convertView==null){
                convertView = inflater.inflate(R.layout.item,parent,false);
                holder = new ViewHolder();
                holder.tv1 = (TextView)convertView.findViewById(R.id.tx1);
                holder.tv2 = (TextView)convertView.findViewById(R.id.tx2);
                holder.tv3 = (TextView)convertView.findViewById(R.id.tx3);
                holder.tv4 = (TextView)convertView.findViewById(R.id.tx4);
                holder.tv5 = (TextView)convertView.findViewById(R.id.tx5);
                convertView.setTag(holder);
            }
            else {
                holder= (ViewHolder)convertView.getTag();
            }
            holder.tv1.setText(list.get(position).t1);
            holder.tv2.setText(list.get(position).t2);
            holder.tv3.setText(list.get(position).t3);
            holder.tv4.setText(list.get(position).t4);
            holder.tv5.setText(list.get(position).t5);

            return convertView;
        }
    }

    private class ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;

    }








}



