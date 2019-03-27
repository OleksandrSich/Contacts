package com.njakawaii.testapp.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.njakawaii.testapp.data.Category;
import com.njakawaii.testapp.data.Group;
import com.njakawaii.testapp.data.Groups;
import com.njakawaii.testapp.model.ContactsDataSourse;
import com.njakawaii.testapp.model.ContactsRepository;
import com.njakawaii.testapp.view.ContactsView;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

public class ContactsPresenterImpl implements ContactsPresenter {

    private Disposable loadContactsSubscription;
    private ContactsDataSourse contactsDataSourse = new ContactsRepository();
    private Context context;
    private ContactsView contactsView;

    public ContactsPresenterImpl(
            Context context,
            ContactsView contactsView
    ) {
        this.context = context;
        this.contactsView = contactsView;
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (cm != null) {
            netInfo = cm.getActiveNetworkInfo();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private void generateCategories(final Groups groups) {
        List<Category> categories = new ArrayList<>();
        for (Group group : groups.getGroups()) {
            if (!group.getPeople()
                    .isEmpty()) {
                categories.add(new Category(group.getGroupName(),
                                            group.getPeople()));
            }
        }
        contactsView.showContacts(categories);
    }

    @Override
    public void getContacts() {
        if (isOnline()) {
            contactsView.showDialog(true);
            loadContactsSubscription = contactsDataSourse.getContacts()
                    .subscribe(groups -> {
                        generateCategories(groups);
                        contactsView.showDialog(false);
                    });
        } else {
            contactsView.showError("Unable to load data. Please check your internet connection and try again");
        }
    }

    @Override
    public void onPause() {
        if (loadContactsSubscription != null && loadContactsSubscription.isDisposed()) {
            loadContactsSubscription.dispose();
        }
    }
}
