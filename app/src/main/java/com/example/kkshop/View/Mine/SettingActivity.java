package com.example.kkshop.View.Mine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kkshop.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minefrag_setting);
        InitView();

    }

    private void InitView(){
        Button quit=findViewById(R.id.minesetting_quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("action.exit");
                sendBroadcast(intent);
                finish();
            }
        });
    }
}