package com.woowrale.instantsearch.japp.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.woowrale.instantsearch.japp.data.repository.ApiClient;

import retrofit2.Retrofit;

public class BaseActivity extends AppCompatActivity implements BasePresenter.View {

    private static ApiClient apiClient = new ApiClient();

    public Retrofit getRetrofit(){
        return apiClient.getClient();
    }
}
