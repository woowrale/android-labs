package com.woowrale.architecture.mvp.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.woowrale.architecture.mvp.data.repository.ApiClient;

import retrofit2.Retrofit;

public class BaseActivity extends AppCompatActivity implements IView {

    private static ApiClient apiClient = new ApiClient();

    @Override
    public Retrofit getRetrofit(){
        return apiClient.getClient();
    }
}