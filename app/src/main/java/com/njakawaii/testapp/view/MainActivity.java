package com.njakawaii.testapp.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.njakawaii.testapp.R;
import com.njakawaii.testapp.data.Category;
import com.njakawaii.testapp.expand.ContactsAdapter;
import com.njakawaii.testapp.presenter.ContactsPresenter;
import com.njakawaii.testapp.presenter.ContactsPresenterImpl;
import dmax.dialog.SpotsDialog;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactsView {

    public ContactsAdapter adapter;

    private ContactsPresenter presenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private AlertDialog dialog;

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                                                                                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

    @Override
    public void showContacts(final List<Category> categories) {
        adapter = new ContactsAdapter(categories);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showDialog(final boolean show) {
        if (show) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }

    @Override
    public void showError(final String msg) {
        Toast.makeText(this,
                       msg,
                       Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new ContactsPresenterImpl(this,
                                              this);
        dialog = new SpotsDialog.Builder().setContext(this)
                .setCancelable(false)
                .build();
        init();
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

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getContacts();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }
}
