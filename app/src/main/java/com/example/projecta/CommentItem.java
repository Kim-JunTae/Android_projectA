package com.example.projecta;

public class CommentItem {
    String userId;
    String comment;

    public CommentItem(String userId, String comment) {
        this.userId = userId;
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "userId='" + userId + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
