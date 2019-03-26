package com.njakawaii.testapp.model;

import com.njakawaii.testapp.data.Groups;

import io.reactivex.Observable;


public interface ContactsDataSourse {
   public Observable<Groups> getContacts ();
}
