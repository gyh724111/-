package com.gyh.resumeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gyh.resumeapp.Utils.Data;

public class MainActivity extends Activity {
    EditText mIpPort;
    Button bindButton;
    Button startButton;
    String ipPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Data app = (Data)getApplication();
        mIpPort = (EditText)findViewById(R.id.IpPortEditText);
        bindButton = (Button)findViewById(R.id.bindButton);
        startButton = (Button)findViewById(R.id.startButton);
        bindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ipPort = mIpPort.getText().toString();
                app.setIpPortData(ipPort);
                Toast.makeText(MainActivity.this,"设置${ip:port}为:"+app.getIpPortData(),Toast.LENGTH_SHORT).show();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllResumeActivity.class);
                startActivity(intent);

//                Intent intent = new Intent(MainActivity.this, ResumeDetailActivity.class);
//                startActivity(intent);
            }
        });

    }
}
