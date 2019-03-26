package com.njakawaii.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.njakawaii.testapp.data.Category;
import com.njakawaii.testapp.data.Group;
import com.njakawaii.testapp.data.Groups;
import com.njakawaii.testapp.expand.ContactsAdapter;
import com.njakawaii.testapp.model.ContactsDataSourse;
import com.njakawaii.testapp.model.ContactsRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    public ContactsAdapter adapter;

    private Disposable loadContactsSubscription;
    private ContactsDataSourse contactsDataSourse = new ContactsRepository();
    private List<Group> groupList = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);

         recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
         layoutManager = new LinearLayoutManager(this);


        // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
        // Specifically when you call notifyItemChanged() it does a fade animation for the changing
        // of the data in the ViewHolder. If you would like to disable this you can use the following:
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        contactsDataSourse.getContacts().subscribe(new Observer<Groups>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Groups groups) {
                groupList = groups.getGroups();

                Toast.makeText(MainActivity.this, "Size is:" + groupList.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                init();
            }
        });


    }

    private void init(){

        List<Category> categories = new ArrayList<>();
        for (Group group : groupList){
            if (!group.getPeople().isEmpty())
            categories.add(new Category(group.getGroupName(), group.getPeople()));
        }
        adapter = new ContactsAdapter(categories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
}
