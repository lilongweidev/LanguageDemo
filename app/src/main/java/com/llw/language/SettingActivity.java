package com.llw.language;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.llw.language.base.BaseActivity;
import com.llw.language.utils.LocalManageUtils;
import com.llw.language.utils.SPUtils;

/**
 * 设置页面
 *
 * @author llw
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    ImageView iv_system, iv_chinese, iv_english, iv_traditional_chinese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //初始化页面
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        Back(toolbar);

        RelativeLayout lay_system = findViewById(R.id.lay_system);
        RelativeLayout lay_chinese = findViewById(R.id.lay_chinese);
        RelativeLayout lay_english = findViewById(R.id.lay_english);
        RelativeLayout lay_traditional_chinese = findViewById(R.id.lay_traditional_chinese);

        iv_system = findViewById(R.id.iv_system);
        iv_chinese = findViewById(R.id.iv_chinese);
        iv_english = findViewById(R.id.iv_english);
        iv_traditional_chinese = findViewById(R.id.iv_traditional_chinese);

        lay_system.setOnClickListener(this);
        lay_chinese.setOnClickListener(this);
        lay_english.setOnClickListener(this);
        lay_traditional_chinese.setOnClickListener(this);

        //根据缓存中语言来表示设置中选中的语言
        controlView(SPUtils.getInstance(this).getLanguage());
    }

    /**
     * 控制选中视图
     * @param select 选项
     */
    private void controlView(int select) {
        switch (select) {
            case 0://系统
                iv_system.setVisibility(View.VISIBLE);
                iv_chinese.setVisibility(View.GONE);
                iv_english.setVisibility(View.GONE);
                iv_traditional_chinese.setVisibility(View.GONE);
                break;
            case 1://中文
                iv_system.setVisibility(View.GONE);
                iv_chinese.setVisibility(View.VISIBLE);
                iv_english.setVisibility(View.GONE);
                iv_traditional_chinese.setVisibility(View.GONE);
                break;
            case 2://英文
                iv_system.setVisibility(View.GONE);
                iv_chinese.setVisibility(View.GONE);
                iv_english.setVisibility(View.VISIBLE);
                iv_traditional_chinese.setVisibility(View.GONE);
                break;
            case 3://中文繁体
                iv_system.setVisibility(View.GONE);
                iv_chinese.setVisibility(View.GONE);
                iv_english.setVisibility(View.GONE);
                iv_traditional_chinese.setVisibility(View.VISIBLE);
                break;
            default:
                break;

        }
    }

    /**
     * 选择语言后，重新进入setting页面
     *
     * @param context
     * @param select
     */
    public void reStart(Context context, int select) {
        LocalManageUtils.setSelectLanguage(this, select);
        controlView(select);//控制选择的视图
        finish();
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lay_system://系统
                reStart(this, 0);
                break;
            case R.id.lay_chinese://中文
                reStart(this, 1);
                break;
            case R.id.lay_english://英文
                reStart(this, 2);
                break;
            case R.id.lay_traditional_chinese://中文繁体
                reStart(this, 3);
                break;
            default:
                break;
        }
    }
}
