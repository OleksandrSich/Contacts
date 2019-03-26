package com.njakawaii.testapp.model;

import com.njakawaii.testapp.data.Groups;
import com.njakawaii.testapp.utils.BaseSchedulerProvider;
import com.njakawaii.testapp.utils.SchedulerProvider;

import io.reactivex.Observable;

public class ContactsRepository implements ContactsDataSourse{


    private BaseSchedulerProvider mSchedulerProvider =  SchedulerProvider.getInstance();
    @Override
    public Observable<Groups> getContacts() {
        return NetworkClient.getRetrofit().create(ContactsSevice.class).getContacts().subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui());
    }
}
