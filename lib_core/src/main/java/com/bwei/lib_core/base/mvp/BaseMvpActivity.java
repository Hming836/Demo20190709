package com.bwei.lib_core.base.mvp;

import com.bwei.lib_core.base.BaseActivity;

/**
 * @Auther :Hming
 * @Date : 2019/7/9  21:17
 * @Description: BaseMvpActivity
 */
public abstract class BaseMvpActivity<M extends IBaseModel, P extends BasePresenter> extends BaseActivity implements IBaseView {
    public M model;
    public P presenter;

    @Override
    protected void initData() {

        presenter = (P) initPresenter();
        if (presenter != null) {
            model = (M) presenter.getModel();
            if (model != null) {
                //绑定 
                presenter.attach(model, this);

            }
        }

        init();
    }

    protected abstract void init();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //解绑
            presenter.detach();
        }
    }
}
