package com.example.kkshop.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kkshop.Controller.Controller;
import com.example.kkshop.R;
import com.example.kkshop.Utils.ToastUtil;
import com.example.kkshop.Utils.logUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private Controller controller;
    private static final String TAG = "LoginActivity";

    private String arg1=null;
    private String password=null;
    private EditText arg1ET;
    private EditText passwordET;
    int Result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        controller = Controller.Instance();
        InitLogin();
    }

    private void InitLogin(){
        Button loginBtn =findViewById(R.id.login_submit);
        arg1ET =findViewById(R.id.login_arg1);
        passwordET =findViewById(R.id.login_password);

        //Register
        Button RegisterBtn =findViewById(R.id.login_toregister);
        RegisterBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_submit:
                arg1=arg1ET.getText().toString();
                password=passwordET.getText().toString();
                Login();
                break;
            case R.id.login_toregister:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    private void Login(){
        logUtil.e(TAG,"arg1"+arg1);
        logUtil.e(TAG,"password"+password);
        Result= controller.Login(arg1,password);
        switch (Result){
            case Controller.UserNotExist:
                ToastUtil.showMsg(this,"用户不存在，请注册");
                break;
            case Controller.PasswordError:
                ToastUtil.showMsg(this,"账号或密码错误");
                break;
            case Controller.LoginSuccess:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }

}