package com.llw.language;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.llw.language.base.BaseActivity;

/**
 * 其他页面
 * @author llw
 */
public class OtherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Back(toolbar);
    }
}
