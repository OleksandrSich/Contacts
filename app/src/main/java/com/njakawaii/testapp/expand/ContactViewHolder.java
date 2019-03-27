package com.njakawaii.testapp.expand;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.njakawaii.testapp.R;
import com.njakawaii.testapp.data.ContactStatus;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ContactViewHolder extends ChildViewHolder {

    private TextView name;
    private TextView status;
    private ImageView icon;
    private ImageView statusIcon;

    ContactViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.list_item_name);
        status = (TextView) itemView.findViewById(R.id.list_item_status);
        icon = (ImageView) itemView.findViewById(R.id.list_item_photo);
        statusIcon = (ImageView) itemView.findViewById(R.id.list_item_status_icon);
    }

    public void setName(String group) {
        name.setText(group);
    }

    public void setIcon(int res) {
        icon.setBackgroundResource(res);
    }

    void setStatus(final String status) {
        this.status.setText(status);
    }

    void setStatusIcon(final String statusIcon) {
        this.statusIcon.setBackgroundResource(ContactStatus.valueOf(statusIcon.toUpperCase())
                                                      .getRes());
    }
}
