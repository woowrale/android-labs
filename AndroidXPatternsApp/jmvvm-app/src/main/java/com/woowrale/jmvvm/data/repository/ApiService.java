package com.woowrale.jmvvm.data.repository;

import com.woowrale.jmvvm.data.model.Contact;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {

    @GET Single<List<Contact>> getContacts(@Url String apiContacts,
                                           @Query("source") String source,
                                           @Query("search") String query);

}