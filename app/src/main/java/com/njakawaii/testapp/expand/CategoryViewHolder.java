package com.njakawaii.testapp.expand;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.njakawaii.testapp.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class CategoryViewHolder extends GroupViewHolder {

    private TextView childTextView;

    private ImageView arrow;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_artist_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_group_arrow);
    }

    public void setCategoryName(String name) {
        childTextView.setText(name);
    }

    private void animateExpand() {
        RotateAnimation rotate = new RotateAnimation(360,
                                                     180,
                                                     RELATIVE_TO_SELF,
                                                     0.5f,
                                                     RELATIVE_TO_SELF,
                                                     0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate = new RotateAnimation(180,
                                                     360,
                                                     RELATIVE_TO_SELF,
                                                     0.5f,
                                                     RELATIVE_TO_SELF,
                                                     0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }
}
