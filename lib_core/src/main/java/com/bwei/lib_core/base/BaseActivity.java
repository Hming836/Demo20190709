package com.bwei.lib_core.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Auther :Hming
 * @Date : 2019/7/9  21:02
 * @Description: BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {

    private boolean isStatus; // 沉浸式
    private boolean isFullScreen; // 全屏
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }


    protected abstract void initData();

    protected abstract void initView();


    /**
     * 绑定根布局id
     *
     * @return
     */
    protected abstract int bindLayoutId();

    /**
     * 显示toast
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 无参跳转
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 有参跳转
     *
     * @param clz
     */
    public void startActivity(Bundle bundle, Class<?> clz) {
        Intent intent = new Intent(this, clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * @param status
     */
    public void isStatus(boolean status) {
        if (status) {
            //沉浸式代码
        }
    }

    /**
     * 全屏
     *
     * @param
     */
    public void isFullscreen(boolean fullscreenn) {
        if (fullscreenn) {
            //全屏代码
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.aTag("走了onStart方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.aTag("走了onRestart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.aTag("走了onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.aTag("走了onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.aTag("走了onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.aTag("走了onDestroy方法");
        if (unbinder != null) {
            unbinder.unbind();//解绑butterkinife
        }
    }
}
