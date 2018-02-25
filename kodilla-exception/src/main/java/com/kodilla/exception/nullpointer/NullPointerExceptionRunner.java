package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        //User user = new User("Username");
        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message not send, but my program still running very well. Error: " + e);
        } finally {
            System.out.println("Processing other logic...");
        }
    }
}
