package com.llw.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.llw.language.base.BaseActivity;
import com.llw.language.utils.LocalManageUtils;

/**
 * 主页面
 *
 * @author llw
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {


    private TextView tvSystemLanguage;//系统语言
    private TextView tvCurrentLanguage;//当前语言

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.iv_setting);
        TextView tvOtherPage = findViewById(R.id.tv_other_pages);
        tvSystemLanguage = findViewById(R.id.tv_sys_language);
        tvCurrentLanguage = findViewById(R.id.tv_cur_language);

        imageView.setOnClickListener(this);
        tvOtherPage.setOnClickListener(this);

        //系统语言
        tvSystemLanguage.setText(getString(R.string.system_language) +
                LocalManageUtils.getSystemLocal(this).getDisplayLanguage());

        //当前应用语言
        tvCurrentLanguage.setText(getString(R.string.current_language) +
                LocalManageUtils.getSelectLanguage(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting://进入设置页面
                goToActivity(SettingActivity.class);
                break;
            case R.id.tv_other_pages://进入其他页面
                goToActivity(OtherActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 跳转页面
     *
     * @param clazz 目标Activity
     */
    private void goToActivity(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }


}
