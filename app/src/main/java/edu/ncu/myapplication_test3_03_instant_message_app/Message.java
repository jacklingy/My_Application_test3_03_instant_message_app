package edu.ncu.myapplication_test3_03_instant_message_app;

public class Message {
    private String content;
    private int avatar;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public Message(String content, int avatar) {
        this.content = content;
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
