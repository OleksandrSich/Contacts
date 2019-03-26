package com.njakawaii.testapp.data;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class Category extends ExpandableGroup<Person> {

    public Category(
            final String title,
            final List<Person> items
    ) {
        super(title,
              items);
    }
}
