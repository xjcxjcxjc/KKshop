package com.example.kkshop.View.Mine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.kkshop.Base.BaseActivity;
import com.example.kkshop.Controller.Controller;
import com.example.kkshop.Po.DeliverLocation;
import com.example.kkshop.R;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends BaseActivity {

    private List<DeliverLocation> locations=null;
    private final Controller controller = Controller.Instance();
    private LocationAdapter locationAdapter;

//    @SuppressLint("HandlerLeak")
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 1:
//                    locations= (List<DeliverLocation>) msg.obj;
//                    locationAdapter.notifyDataSetChanged();
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        InitView();
        /*
         * 对用户Location的展示
         */
        locations=controller.provideLocations();
        if (locations==null){
            locations=new ArrayList<>();
        }

        RecyclerView recyclerView = findViewById(R.id.location_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        locationAdapter=new LocationAdapter(locations,this);
        recyclerView.setAdapter(locationAdapter);
        recyclerView.addItemDecoration(new Mdecoration());
    }

    private void InitView(){
        InitToolBar();

//        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.Blcak));
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                InitLocations();
//            }
//        });
    }


//    private void InitLocations(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                List<DeliverLocation> deliverLocations=controller.provideLocations();
//                Message message=Message.obtain();
//                message.obj=deliverLocations;
//                message.what=1;
//                handler.sendMessage(message);
//            }
//        }).start();
//    }

    private void InitToolBar(){
        Toolbar toolbar = findViewById(R.id.location_toolbar);
        toolbar.setTitle("我的收货地址");

        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.location_toolbar_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.location_toolbaritem_add:
                DeliverLocation deliverLocation=null;
                Intent intent =new Intent(this,EditorLocationActivity.class);
                intent.putExtra("Location",deliverLocation);
                startActivity(intent);
                break;
        }
        return true;
    }
}


class Mdecoration extends RecyclerView.ItemDecoration{
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0,0,0,50);
    }
}