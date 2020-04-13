package com.woowrale.jmvvm.ui.search.remote;

import android.util.Log;

import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;
import com.woowrale.jmvvm.data.model.Contact;
import com.woowrale.jmvvm.data.repository.ApiService;
import com.woowrale.jmvvm.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.observers.DisposableObserver;

@Singleton
public class RemoteSearchPresenter extends BasePresenter<RemoteSearchView> {

    private static final String TAG = RemoteSearchPresenter.class.getSimpleName();

    private ApiService apiService;

    @Inject
    public RemoteSearchPresenter(ApiService apiService){
        this.apiService = apiService;
    }

    public DisposableObserver<List<Contact>> getSearchObserver() {
        return new DisposableObserver<List<Contact>>() {
            @Override
            public void onNext(List<Contact> contacts) {
                getView().getContactsList().clear();
                getView().getContactsList().addAll(contacts);
                getView().getmAdapter().notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public DisposableObserver<TextViewTextChangeEvent> searchContactsTextWatcher() {
        return new DisposableObserver<TextViewTextChangeEvent>() {
            @Override
            public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                Log.d(TAG, "Search query: " + textViewTextChangeEvent.text());
                getView().getPublishSubject().onNext(textViewTextChangeEvent.text().toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public ApiService getApiService() {
        return apiService;
    }
}
