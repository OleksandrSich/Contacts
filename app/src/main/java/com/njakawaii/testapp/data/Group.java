package com.njakawaii.testapp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group  {

    @SerializedName("groupName")
    @Expose
    private String groupName;
    @SerializedName("people")
    @Expose
    private List<Person> people = new ArrayList<>();

    private int iconResId;


    public int getIconResId() {
        return iconResId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getGroupName(), group.getGroupName()) &&
                Objects.equals(getPeople(), group.getPeople());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGroupName(), getPeople());
    }
}