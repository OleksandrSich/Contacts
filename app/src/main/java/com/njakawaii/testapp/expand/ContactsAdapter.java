package com.njakawaii.testapp.expand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.njakawaii.testapp.R;
import com.njakawaii.testapp.data.Category;
import com.njakawaii.testapp.data.Person;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class ContactsAdapter extends ExpandableRecyclerViewAdapter<CategoryViewHolder, ContactViewHolder> {

    public ContactsAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public CategoryViewHolder onCreateGroupViewHolder(
            ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_group,
                         parent,
                         false);
        return new CategoryViewHolder(view);
    }

    @Override
    public ContactViewHolder onCreateChildViewHolder(
            ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_contact,
                         parent,
                         false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(
            final ContactViewHolder holder,
            final int flatPosition,
            final ExpandableGroup group,
            final int childIndex
    ) {
        final Person person = ((Category) group).getItems()
                .get(childIndex);
        holder.setName(person.getFirstName() + " " + person.getLastName());
        holder.setIcon(R.drawable.contacts_list_avatar_male);
        holder.setStatus(person.getStatusMessage());
        holder.setStatusIcon(person.getStatusIcon());
    }

    @Override
    public void onBindGroupViewHolder(
            final CategoryViewHolder holder,
            final int flatPosition,
            final ExpandableGroup group
    ) {
        holder.setCategoryName(group.getTitle());
    }
}
