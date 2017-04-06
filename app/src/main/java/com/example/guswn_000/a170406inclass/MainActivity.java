package com.example.guswn_000.a170406inclass;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tv1;
    Button b1,b3;
    final int REQUESTMSGCODE = 21;
    static final int PICK_CONTACK_REQUEST = 212;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        tv1 = (TextView)findViewById(R.id.tv1);
        b3 = (Button)findViewById(R.id.b3);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.b2)
        {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    ContactsContract.Contacts.CONTENT_URI);

            startActivityForResult(intent, PICK_CONTACK_REQUEST);
            //연락처버튼

        }
        else if (v.getId() == R.id.b4)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:/01092611126"));
            startActivity(intent);
        }
        else if (v.getId() == R.id.b3) // 학생정보넘기기
        {
            Intent intent = new Intent (this,Main2Activity.class);
            Student s1 = new Student ("홍길동","2015038259",20,1);
            intent.putExtra("student1",s1);
            startActivityForResult(intent,20);
        }
        else//텍스트받아오는버튼
        {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("msg", tv1.getText().toString());
            intent.putExtra("num1",100);
            startActivityForResult(intent, REQUESTMSGCODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUESTMSGCODE)
        {
            //이 엑티비티 하나에서 여러 액티비티와 정보 주고받을수잇다
            if(resultCode == RESULT_OK)
            {
                //인텐트가 데이터로 넘어옴
                String msg = data.getStringExtra("remakemsg");
                tv1.setText(msg);
            }
        }
        else if (requestCode == PICK_CONTACK_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                startActivity(data);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
        //이리로 정보가 넘어온다
    }
}
