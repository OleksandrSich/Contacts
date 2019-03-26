package com.njakawaii.testapp.model;

import com.njakawaii.testapp.data.Groups;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ContactsSevice {

    @GET("owncloud/index.php/s/F5WttwCODi1z3oo/download?path=%2F&files=contacts.json")
    public Observable<Groups> getContacts();
}
