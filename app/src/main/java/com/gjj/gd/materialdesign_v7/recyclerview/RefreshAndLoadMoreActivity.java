package com.gjj.gd.materialdesign_v7.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.recyclerview.adapter.RefreshLoadMoreAdpater;
import com.gjj.gd.materialdesign_v7.recyclerview.other.MyItemDecoration;
import com.gjj.gd.materialdesign_v7.recyclerview.view.RefreshLoadMaoreRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RefreshAndLoadMoreActivity extends AppCompatActivity {

    @BindView(R.id.custom_rv)
    RefreshLoadMaoreRecyclerView mRecyclerView;

    private RecyclerView.Adapter adapter;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_and_load_more);
        ButterKnife.bind(this);


//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3434000068,2874621746&fm=116&gp=0.jpg");

        adapter = new RefreshLoadMoreAdpater(this, list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new MyItemDecoration(this,10));

        mRecyclerView.setPullToRefreshListener(new RefreshLoadMaoreRecyclerView.PullToRefreshListener() {
            @Override
            public void onRefreshing() {
                refreshData();
            }
        });
        mRecyclerView.setLoadMoreListener(new RefreshLoadMaoreRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadMoreData();
            }
        });

    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                for (int i = 0; i < 2; i++)
                    list.add(0, "http://img15.3lian.com/2015/a1/16/d/202.jpg");
                mRecyclerView.setRefreshComplete();
            }
            if (msg.what == 2){
                for (int i = 0; i < 2; i++)
                    list.add("http://a.hiphotos.baidu.com/image/pic/item/03087bf40ad162d96270c41b13dfa9ec8a13cd1f.jpg");
                mRecyclerView.setLoadMoreComplete();
            }
        }
    };

    public void refreshData(){
        mHandler.sendEmptyMessageDelayed(1,3000);
    }

    public void loadMoreData(){
        mHandler.sendEmptyMessageDelayed(2,3000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("add header");
        menu.add("add footer");
        menu.add("change");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //不能在onCreate()中获取View,防止添加时的无缘故的错乱.
//        View Hview = LayoutInflater.from(this).inflate(R.layout.head_layout, null);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        Hview.setLayoutParams(params);
////        if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
////            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
////            view.setLayoutParams(params);
////        }
//        if (item.getTitle().toString() == "add header") {
//            mRecyclerView.addHeaderView(Hview);
//        } else if (item.getTitle().toString() == "add footer") {
//            mRecyclerView.addFooterView(view);
//        } else {
//            view.setVisibility(View.VISIBLE);
//        }
        return true;
    }
}

