package com.example.kkshop.View.Mine;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.kkshop.Base.BaseActivity;
import com.example.kkshop.Controller.Controller;
import com.example.kkshop.Po.DeliverLocation;
import com.example.kkshop.R;
import com.example.kkshop.Utils.ToastUtil;
import com.example.kkshop.Utils.logUtil;

import java.util.ArrayList;
import java.util.List;


public class EditorLocationActivity extends BaseActivity implements View.OnClickListener {

    public LocationClient mLocationClient = null;
    private final MyLocationListener myListener = new MyLocationListener();
    DeliverLocation deliverLocation=null;
    private static final String TAG = "EditorLocationActivity";
    private int location_id=0;

    /*
     * 判断是增加Location还是修改Location，如果从intent拿到的是null就是增加
     * 0是增加
     * 1是修改
     */
    private int status;
    private final static int LOCATION_ADD=0;
    private final static int LOCATION_EDIT=1;

    private EditText tx1;
    private EditText tx2;
    private EditText tx3;
    private EditText tx4;
    private EditText tx5;
    private EditText tx6;
    private EditText tx7;
    private EditText tx8;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_edit);

        InitView();
        deliverLocation= (DeliverLocation) getIntent().getSerializableExtra("Location");
        /*
         * 如果是修改就填入数据
         */
        if(deliverLocation!=null){
            location_id=deliverLocation.getId();
            InitEditView();
            status=LOCATION_EDIT;
        }else{
            status=LOCATION_ADD;
        }

        /*
         * 设置点击获取地址,获取成功会调用myListener，myListener会重新InitEditView()
         */
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(myListener);
        init();  // 初始化权限等配置
    }


    private void InitView(){
        tx1=findViewById(R.id.tx1);
        tx2=findViewById(R.id.tx2);
        tx3=findViewById(R.id.tx3);
        tx4=findViewById(R.id.tx4);
        tx5=findViewById(R.id.tx5);
        tx6=findViewById(R.id.tx6);
        tx7=findViewById(R.id.tx7);
        tx8=findViewById(R.id.tx8);
        checkBox=findViewById(R.id.location_isdefault);
        Button button_get = findViewById(R.id.edit_get);
        button_get.setOnClickListener(this);

        Button button_submit = findViewById(R.id.edit_submit);
        button_submit.setOnClickListener(this);
    }


    private void InitEditView(){
        if(deliverLocation!=null){
            tx1.setText(deliverLocation.getName());
            tx2.setText(deliverLocation.getPhone());
            tx3.setText(deliverLocation.getCountry());
            tx4.setText(deliverLocation.getProvince());
            tx5.setText(deliverLocation.getCity());
            tx6.setText(deliverLocation.getDistrict());
            tx7.setText(deliverLocation.getStreet());
            tx8.setText(deliverLocation.getDetailedAddress());

            if (deliverLocation.getIsdefault()==1)
                checkBox.setChecked(true);
        }
    }

    /*
     * 初始化百度SdK配置，初始化界面的时候就可以请求权限了
     */
    private void init() {
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);

        //存放权限的集合
        List<String> permissionList=new ArrayList<>();
        //判断是否有权限
        if (ContextCompat.checkSelfPermission(EditorLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(EditorLocationActivity.this,Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(EditorLocationActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()){
            String[] permission = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(EditorLocationActivity.this,permission,1);
        }
    }

    /**
     * 开始请求
     */
    public void request(){
        mLocationClient.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_get:
                request();
                break;
            case R.id.edit_submit:
                Submit();
                break;
            default:
                break;
        }
    }

    /**
     * 百度定位的响应接口
     */
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (deliverLocation==null)
                deliverLocation=new DeliverLocation();

            deliverLocation.setCountry(location.getCountry());
            deliverLocation.setProvince(location.getProvince());
            deliverLocation.setCity(location.getCity());
            deliverLocation.setDistrict(location.getDistrict());
            deliverLocation.setStreet(location.getStreet());
            InitEditView();
        }
    }

    /*
     * 获取动态权限的回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0){
                    for (int results : grantResults){
                        if (results!= PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(EditorLocationActivity.this,"必须打开权限才能使用！",Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                }else {
                    Toast.makeText(EditorLocationActivity.this,"未知错误！！",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:break;
        }
    }


    /**
     *
     * Location 提交,如果是添加的话...
     * 如何是修改的话...
     *
     */
    private void Submit(){

        logUtil.e(TAG,"Submit");
        String Name;
        String phone;
        String Country;
        String provence;
        String City;
        String Dis;
        String Street;
        String Detailed;
        int isdefault;
        DeliverLocation NewdeliverLocation;
        Controller controller;

        controller = Controller.Instance();
        boolean nonull=true;
        Name=tx1.getText().toString();
        phone=tx2.getText().toString();
        Country=tx3.getText().toString();
        provence=tx4.getText().toString();
        City=tx5.getText().toString();
        Dis=tx6.getText().toString();
        Street=tx7.getText().toString();
        Detailed=tx8.getText().toString();

        if(checkBox.isChecked()){
            isdefault=1;
        }else{
            isdefault=0;
        }


        if("".equals(Name)){
            nonull=false;
        }

        if("".equals(phone)){
            nonull=false;
        }

        if("".equals(Country)){
            nonull=false;
        }

        if("".equals(City)){
            nonull=false;
        }

        if("".equals(Dis)){
            nonull=false;
        }
        if("".equals(Street)){
            nonull=false;
        }
        if("".equals(Detailed)){
            nonull=false;
        }

        if(!nonull){
            ToastUtil.showMsg(this,"错误");
            return ;
        }

        NewdeliverLocation=new DeliverLocation(location_id,Name,phone,isdefault
                ,Country,provence
                    ,City,Dis,Street,Detailed,Controller.getUser().getId());


        if (status==LOCATION_ADD)
            controller.addLocation(NewdeliverLocation);
        else
            controller.updateLocation(NewdeliverLocation);


        finish();
    }

}



