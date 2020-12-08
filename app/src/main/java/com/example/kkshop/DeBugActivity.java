package com.example.kkshop;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kkshop.Dao.Imp.UserDaoImp;
import com.example.kkshop.Po.User;
import com.example.kkshop.Utils.logUtil;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class DeBugActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_bug);
    }


    @Override
    public void onClick(View v) {
    }

}