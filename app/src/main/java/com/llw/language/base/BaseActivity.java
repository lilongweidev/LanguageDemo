package com.llw.language.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.llw.language.utils.LocalManageUtils;

/**
 * 基类Activity
 *
 * @author llw
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * 附加基础上下文
     * @param newBase 上下文参数
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalManageUtils.setLocale(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        super.onCreate(savedInstanceState);
    }


    /**
     * 设置toolbar的左侧图标的点击事件
     *
     * @param toolbar
     */
    protected void Back(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
