package com.tatuas.android.retrofit2sample;


import com.tatuas.android.retrofit2sample.structure.Repo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("/users/{user}/repos")
    Single<Response<List<Repo>>> listRepos(@Path("user") String user);

    @GET("/users/{user}/repos")
    Observable<List<Repo>> listRepos2(@Path("user") String user);
}



