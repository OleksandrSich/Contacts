package com.njakawaii.testapp.data;

import com.njakawaii.testapp.R;

public enum ContactStatus {
    ONLINE(R.drawable.contacts_list_status_online),
    OFFLINE(R.drawable.contacts_list_status_offline),
    AWAY(R.drawable.contacts_list_status_away),
    BUSY(R.drawable.contacts_list_status_busy),
    CALLFORWARDING(R.drawable.contacts_list_call_forward),
    PENDING(R.drawable.contacts_list_status_pending);

    int res;

    ContactStatus(
            final int res
    ) {
        this.res = res;
    }

    public int getRes() {
        return res;
    }
}
