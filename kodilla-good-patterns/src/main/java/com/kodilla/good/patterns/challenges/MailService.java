package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void sendConfirmation(User user) {
        System.out.println("Sending confirmation e-mail to user: " + user.getName() + "\nto address: " + user.getEmail());
    }
}
