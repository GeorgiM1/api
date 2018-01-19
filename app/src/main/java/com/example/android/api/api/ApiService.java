package com.example.android.api.api;

import com.example.android.api.model.BookModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pc on 1/19/2018.
 */

public interface ApiService {
    @GET ("volumes?"+ApiConstants.KEY)
    Call<BookModel> getBooks (@Query("q") String id);

}
