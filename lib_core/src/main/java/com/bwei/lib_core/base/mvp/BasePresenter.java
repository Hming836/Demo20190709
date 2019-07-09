package com.bwei.lib_core.base.mvp;

import java.lang.ref.WeakReference;

/**
 * @Auther :Hming
 * @Date : 2019/7/9  21:21
 * @Description: BasePresenter
 */
public abstract class BasePresenter<M, V> {
    public M model;
    public V view;
    private WeakReference<V> weakReference; //软引用

    public abstract M getModel();

    /*
     * 绑定
     *
     * */
    public void attach(M model, V view) {
        this.model = model;
        weakReference = new WeakReference<>(view);
        this.view = weakReference.get();

    }


    /**
     * 解绑
     *
     */
    public void detach() {
        if (weakReference != null) {
            weakReference.clear();//清空对象
            weakReference = null;
            this.view = null;
        }
    }
}
