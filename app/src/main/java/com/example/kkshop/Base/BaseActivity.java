package com.example.kkshop.Base;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.kkshop.R;
import com.example.kkshop.Utils.ViewUtil;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    /**广播关闭所有activity
     *              Intent intent = new Intent();
     *                 intent.setAction("action.exit");
     *                 sendBroadcast(intent);
     *                 finish();
     */
    private static final String EXITACTION = "action.exit";
    private ExitReceiver exitReceiver = new ExitReceiver();
    private ViewUtil viewUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntentFilter filter = new IntentFilter();
        filter.addAction(EXITACTION);
        registerReceiver(exitReceiver, filter);

        viewUtil= ViewUtil.Instance();
        //设置状态栏上的图标颜色是否为黑色
        viewUtil.changeStatusBarTextImgColor(true,this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销广播
        unregisterReceiver(exitReceiver);
    }

}

/**
 * 用于关闭所有activity的广播
 */
class ExitReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ((Activity) context).finish();
    }
}