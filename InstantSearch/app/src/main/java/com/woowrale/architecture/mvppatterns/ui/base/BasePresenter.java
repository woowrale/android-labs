package com.woowrale.architecture.mvppatterns.ui.base;

import android.view.View;

public class BasePresenter<V extends IView> implements IPresenter {

    private View V;

    public View getView(){
        return V;
    }

    @Override
    public void navigateToActivity() {

    }
}
