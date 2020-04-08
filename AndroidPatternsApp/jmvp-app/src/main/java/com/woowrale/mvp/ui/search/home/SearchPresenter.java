package com.woowrale.mvp.ui.search.home;

import com.woowrale.mvp.ui.base.BasePresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SearchPresenter extends BasePresenter<SearchView> {

    @Inject
    public SearchPresenter() {

    }

    public void navigateToSearch(String searchType){
        if (searchType.equals("L")){
            getView().navigateToSearchLocal();
        }else{
            getView().navigateToSearchRemote();
        }
    }
}
