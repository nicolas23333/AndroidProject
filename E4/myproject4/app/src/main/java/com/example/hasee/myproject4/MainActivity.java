package com.example.hasee.myproject4;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        final EditText myuserName=(EditText)findViewById(R.id.edittext_1);
        EditText myuserPassword=(EditText)findViewById(R.id.edittext_2);
        Button btn_log=(Button)findViewById(R.id.button_log);
        Button btn_rig=(Button)findViewById(R.id.btn_rig);

      final  SharedPreferences msp=getSharedPreferences("logUser",0);
        final SharedPreferences.Editor meditor=msp.edit();
        String oldUser=msp.getString("userName", null);
        if(oldUser==null) {
            Toast.makeText(this, "不存在用户！", Toast.LENGTH_SHORT).show();
            btn_log.setVisibility(View.INVISIBLE);
        }
        else{
            btn_rig.setVisibility(View.INVISIBLE);
//            myuserName.setHint("您已登陆过"+oldUser);
              myuserName.setText(msp.getString("userName",""));
        }
//
//        final String m_userName=myuserName.getText().toString();
//        String m_userPassword=myuserPassword.getText().toString();

        //按钮
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m_userName=myuserName.getText().toString();
                meditor.putString("userName",m_userName);//putString方法，第一个参数是Sharedprefrence的记录，第二个是要传的值
                meditor.putBoolean("loginState",true);
                meditor.commit();
                Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
            }
        });

        btn_rig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meditor.putString("userName",myuserName.getText().toString());//putString方法，第一个参数是Sharedprefrence的记录，第二个是要传的值
                meditor.putBoolean("loginState",true);
                meditor.commit();
                Toast.makeText(MainActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
