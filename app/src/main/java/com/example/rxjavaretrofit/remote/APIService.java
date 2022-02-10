package com.example.rxjavaretrofit.remote;

import com.example.rxjavaretrofit.model.EmployeeList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    @GET("/test/first.json")
    Observable<EmployeeList> getEmployeeList();
}
