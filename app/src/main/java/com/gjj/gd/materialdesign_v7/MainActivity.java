package com.gjj.gd.materialdesign_v7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gjj.gd.materialdesign_v7.constraintlayout.ConstraintlayoutActivity;
import com.gjj.gd.materialdesign_v7.tablayout.TabLayoutActivity;
import com.gjj.gd.materialdesign_v7.toolbar.ToolbarInstance2Activity;
import com.gjj.gd.materialdesign_v7.toolbar.JichuActivity;
import com.gjj.gd.materialdesign_v7.toolbar.ToolbarInstance1Activity;
import com.gjj.gd.materialdesign_v7.toolbar.ToolbarInstance3Activity;
import com.gjj.gd.materialdesign_v7.toolbar.ZhifuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_btn)
    Button mToolbarBtn;
    @BindView(R.id.zhifu_btn)
    Button mZhifuBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }


    @OnClick({R.id.toolbar_btn, R.id.zhifu_btn,R.id.color_btn,R.id.toolbar_btn01
            ,R.id.toolbar_btn02,R.id.toolbar_btn03,R.id.constraintlayout_btn01,R.id.tablayout_btn01})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.toolbar_btn:
                intent = new Intent(this, JichuActivity.class);
                break;
            case R.id.zhifu_btn:
                intent = new Intent(this, ZhifuActivity.class);
                break;
            case R.id.color_btn:
                intent = new Intent(this, ColorPaletteActivity.class);
                break;
            case R.id.toolbar_btn01:
                intent = new Intent(this, ToolbarInstance1Activity.class);
                break;
            case R.id.toolbar_btn02:
                intent = new Intent(this, ToolbarInstance2Activity.class);
                break;
            case R.id.toolbar_btn03:
                intent = new Intent(this, ToolbarInstance3Activity.class);
                break;
            case R.id.constraintlayout_btn01:
                intent = new Intent(this, ConstraintlayoutActivity.class);
                break;
             case R.id.tablayout_btn01:
                intent = new Intent(this, TabLayoutActivity.class);
                break;






        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
