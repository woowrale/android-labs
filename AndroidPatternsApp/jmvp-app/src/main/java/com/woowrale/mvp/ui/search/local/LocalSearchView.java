package com.woowrale.mvp.ui.search.local;

import com.woowrale.mvp.data.model.Contact;
import com.woowrale.mvp.ui.adapters.ContactsAdapterFilterable;

import java.util.List;

import com.woowrale.mvp.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;

public interface LocalSearchView extends BasePresenter.View {

    CompositeDisposable getDisposable();

    ContactsAdapterFilterable getmAdapter();

    List<Contact> getContactsList();

}
