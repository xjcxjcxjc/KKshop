package com.example.kkshop.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kkshop.Controller.Controller;
import com.example.kkshop.Po.User;
import com.example.kkshop.R;
import com.example.kkshop.Utils.ToastUtil;
import com.example.kkshop.Utils.logUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RegisterActivity";

    private Controller controller;
    private String name;
    private String password;
    private String phone;
    private String iccard;
    private String Email;


    private EditText nameET;
    private EditText passwordET;
    private EditText phoneET;
    private EditText iccardET;
    private EditText EmailET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        controller = Controller.Instance();
        InitRegister();
    }

    private void InitRegister(){
        Button RegisterBtn =findViewById(R.id.register_register);
        nameET=findViewById(R.id.register_name);
        passwordET=findViewById(R.id.register_password);
        phoneET=findViewById(R.id.register_phone) ;
        iccardET=findViewById(R.id.register_iccard);
        EmailET=findViewById(R.id.register_Email);

        //Register
        RegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_register:
                name=nameET.getText().toString();
                password=passwordET.getText().toString();
                iccard=iccardET.getText().toString();
                Email=EmailET.getText().toString();
                phone=phoneET.getText().toString();
                Regsiter();
                break;
            default:
                break;

        }
    }

    private void Regsiter(){
        User user=new User(name,password,phone,iccard,Email);
        int  Result= controller.Register(user);

        switch (Result){
            case Controller.EmailExist:
                ToastUtil.showMsg(this,"EmailExist");
                break;
            case Controller.PhoneExist:
                ToastUtil.showMsg(this,"PhoneExist");
                break;
            case Controller.RegisterSuccess:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            default:
                logUtil.e(TAG,"Regsiter");
                break;
        }
    }
}