package com.example.projecta;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CommentItemView extends LinearLayout {
    TextView userId;
    TextView userComment;

    public CommentItemView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        userId = (TextView)findViewById(R.id.userId);
        userComment = (TextView)findViewById(R.id.comment);


    }

    public void setUserId(String id){
        userId.setText(id);
    }

    public void setUserComment(String comment){
        userComment.setText(comment);
    }

}
