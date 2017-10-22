package com.example.hasee.myproject4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.net.Uri;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SCOSHelper extends AppCompatActivity {

    GridView gridView;
    List<Map<String,Object>> data_list;
    SimpleAdapter sim_adapter;
    int [] icon={R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon,R.drawable.icon};
    String [] iconName={"用户使用协议","关于系统","电话人工帮助","短信帮助","邮件帮助"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_scoshelper);

        gridView=(GridView)findViewById(R.id.gridview);
        data_list=new ArrayList<Map<String, Object>>();


        String [] from={"image","text"};
        int [] to={R.id.itemImage,R.id.itemText};
        sim_adapter=new SimpleAdapter(this,data_list,R.layout.item,from,to);
        //配置适配器
        getData();

         gridView.setAdapter(sim_adapter);
        //监听每个item点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0: break;
                    case 1: break;
                    case 2: phoneCall();break;//打电话
                    case 3: sendMessage();break;//发短信
                    case 4: sendEmail();break;//发邮件
                }
            }
        });

    }

    public List<Map<String,Object>> getData(){
        for (int i=0;i<5;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

    public void phoneCall(){
        String phoneNumber="5554";
        Uri uri=Uri.parse("tel:"+phoneNumber);
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(uri);
        SCOSHelper.this.startActivity(intent);

    }

    public void sendMessage(){
        String phoneNumber="5554";
        String textMessage="test scos helper";
        SmsManager manager=SmsManager.getDefault();//获得默认的消息管理器
        manager.sendTextMessage(phoneNumber,null,textMessage,null,null);

        Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_SHORT).show();
    }

    public void sendEmail(){
        String emailAdd="370870565@qq.com";
        String emailContext="求助！！";

        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+emailAdd));
        intent.putExtra(Intent.EXTRA_SUBJECT,"help");
        intent.putExtra(Intent.EXTRA_TEXT,emailContext);
        startActivity(intent);
        Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
    }

}
