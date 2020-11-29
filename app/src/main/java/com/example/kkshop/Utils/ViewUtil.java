package com.example.kkshop.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class ViewUtil {

    private static ViewUtil viewUtil=null;

    public static ViewUtil Instance(){
        if(viewUtil==null)
            viewUtil=new ViewUtil();

        return viewUtil;
    }

    public void changeStatusBarTextImgColor(boolean isBlack,Context context) {
        if (isBlack) {
            //设置状态栏黑色字体
            ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            //恢复状态栏白色字体
            ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

    public static void ActivityJump(Context context,Class c){
        Intent intent=new Intent(context,c);
        context.startActivity(intent);
    }
}
