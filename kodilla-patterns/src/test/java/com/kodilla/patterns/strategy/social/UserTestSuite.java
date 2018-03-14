package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.shares.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User adam = new Millenials("Adam Adamski");
        User marcin = new YGeneration("Marcin Marciniak");
        User michal = new ZGeneration("Michał Michalak");
        //When
        String adamIsUser = adam.sharePost();
        System.out.println("Adam is " + adamIsUser);
        String marcinIsUser = marcin.sharePost();
        System.out.println("Marcin is " + marcinIsUser);
        String michalIsUser = michal.sharePost();
        System.out.println("Michał is " + michalIsUser);
        //Then
        Assert.assertEquals("sharing with Facebook", adam.sharePost());
        Assert.assertEquals("sharing with Twitter", marcin.sharePost());
        Assert.assertEquals("sharing with Snapchat", michal.sharePost());
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User adam = new Millenials("Adam Adamski");
        //When
        String adamIsUser = adam.sharePost();
        System.out.println("Adam is " + adamIsUser);
        adam.setShareMethod(new SnapchatPublisher());
        adamIsUser = adam.sharePost();
        System.out.println("Adam is now " + adamIsUser);
        //Then
        Assert.assertEquals("sharing with Snapchat", adam.sharePost());
    }
}