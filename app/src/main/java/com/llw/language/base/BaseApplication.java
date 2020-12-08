package com.llw.language.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

import com.llw.language.utils.LocalManageUtils;

/**
 * 自定义基础Application
 * @author llw
 */
public class BaseApplication extends Application {

    public static final String TAG = "BaseApplication";

    @Override
    protected void attachBaseContext(Context base) {
        //设置系统当前语言
        LocalManageUtils.setSystemCurrentLanguage(base);
        super.attachBaseContext(LocalManageUtils.setLocale(base));
        Log.d(TAG,"attachBaseContext");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //设置App的语言
        LocalManageUtils.setAppLanguage(this);
        Log.d(TAG,"onCreate");
    }



    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //通过全局的上下文参数更改相关资源配置
        LocalManageUtils.onConfigurationChanged(getApplicationContext());
        Log.d(TAG,"onConfigurationChanged");
    }
}
