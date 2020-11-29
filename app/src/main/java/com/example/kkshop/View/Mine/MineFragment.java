package com.example.kkshop.View.Mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.kkshop.Base.BaseMainFragment;
import com.example.kkshop.Controller.UserController;
import com.example.kkshop.Po.User;
import com.example.kkshop.R;
import com.example.kkshop.Utils.ToastUtil;
import com.example.kkshop.Utils.ViewUtil;

public class MineFragment extends BaseMainFragment implements View.OnClickListener {

    private static final String TAG = "MineFragment";
    private UserController userController;

    //Btn
    private Button location;
    private Button Myorder;
    private Button starShop;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.mine_fag,container,false);

        userController=UserController.Instance();
        //view 的初始化
        InitView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        InitContent(view);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.mine_toolbar,menu);
    }


    /**
     * Toolbar标题栏的选择事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mine_setting:
                ViewUtil.ActivityJump(getContext(), SettingActivity.class);
                break;
            default:
                break;
        }
        return true;
    }


    /**
     * 按钮的点击事件
     * @param v
     * @return
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_location:
                ToastUtil.showMsg(getContext(),"location");
                break;

            default:
                break;
        }

    }

    //初始化View
    private void InitView(View v){
        //设置ToolBar
        Toolbar toolbar=v.findViewById(R.id.mine_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //设置Toolbar的menu的填充,设置调用
        setHasOptionsMenu(true);
        toolbar.setTitle("");

        //设置按钮点击事件
        location=v.findViewById(R.id.mine_location);
        Myorder=v.findViewById(R.id.mine_Myorder);
        starShop=v.findViewById(R.id.mine_starShop);
        location.setOnClickListener(this);
        Myorder.setOnClickListener(this);
        starShop.setOnClickListener(this);
    }

    private void InitContent(View v){
        User user =userController.getUser();
        TextView username=v.findViewById(R.id.minefrg_username);
        TextView useremail=v.findViewById(R.id.minefrg_email);
        username.setText(user.getName());
        useremail.setText(user.getEmail());
    }
}
