package it.croway;

public class Message {

    private String message;
    private String chat;

    public Message() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Message(String message, String chat) {
        this.message = message;
        this.chat = chat;
    }

}