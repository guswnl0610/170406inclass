package com.example.guswn_000.a170406inclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        setListView();
    }

    public void setListView()
    {
        listView = (ListView)findViewById(R.id.list1);
        e1 = (EditText)findViewById(R.id.et1);


        //1단계 데이터 만들기
        data.add("사과");
        data.add("포도");
        data.add("바나나");

        //어댑터 만들기
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        //꾹 눌렀을때 삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)  // position은 위치정보
            {
                data.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
    public void onClick(View v)
    {
        data.add(e1.getText().toString());
        adapter.notifyDataSetChanged(); // 데이터가 변경됐다고 adapter에게 신호를 줌

    }
}
