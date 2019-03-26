package com.njakawaii.testapp.expand;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.njakawaii.testapp.R;
import com.njakawaii.testapp.data.Category;
import com.njakawaii.testapp.data.Group;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ContactViewHolder extends ChildViewHolder {

  private TextView genreName;
  private ImageView icon;

  public ContactViewHolder(View itemView) {
    super(itemView);
    genreName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
    icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);
  }

  public void setName(String group) {
      genreName.setText(group);


  }
    public void setIcon(int res){
        icon.setBackgroundResource(res);
    }

}
