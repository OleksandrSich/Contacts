package com.njakawaii.testapp.view;

import com.njakawaii.testapp.data.Category;
import java.util.List;

public interface ContactsView {

    void showContacts(List<Category> categories);

    void showDialog(boolean show);

    void showError(String msg);
}
