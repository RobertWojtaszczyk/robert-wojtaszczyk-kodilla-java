package com.kodilla.patterns.strategy.social.shares;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "sharing with Twitter";
    }
}