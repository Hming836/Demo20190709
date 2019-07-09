package com.bwei.lib_core.base.mvp;

/**
 * @Auther :Hming
 * @Date : 2019/7/9  21:19
 * @Description: IBaseView
 */
public interface IBaseView {

    BasePresenter initPresenter();//初始化presennter方法

    void showLoading(); // 显示加载框

    void hideLoading(); // 隐藏加载框

    void error(String msg); // 请求失败
}
