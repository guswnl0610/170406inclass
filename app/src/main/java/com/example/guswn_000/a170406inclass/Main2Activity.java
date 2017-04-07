package com.example.guswn_000.a170406inclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv2,tv3;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et = (EditText)findViewById(R.id.editText);
        tv2 = (TextView)findViewById(R.id.tv2);

        Intent intent = getIntent();
        String msss = intent.getStringExtra("msg");
        int num1 = intent.getIntExtra("num1",0); // 0이라고 기본값을 줌

        Student sss = intent.getParcelableExtra("student1");

        String str = sss.toString();
        et.setText(msss);
        tv2.setText(str);

    }

    public void onClick(View v)
    {
        Intent intent = new Intent();
        intent.putExtra("remakemsg", et.getText().toString());
        setResult(RESULT_OK,intent); // resultcode는 OK눌럿을떄 코든지 CANCLE눌럿을때 코든지?

        finish();
    }

}
