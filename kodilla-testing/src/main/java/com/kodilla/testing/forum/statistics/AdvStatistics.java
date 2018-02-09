package com.kodilla.testing.forum.statistics;

public class AdvStatistics {
    public int getUsersCount() {
        return usersCount;
    }
    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }
    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }
    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;
    public void calculateAdvStatistics(Statistics statistics){
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        averagePostsPerUser = (usersCount == 0) ? 0 : ((double) postsCount / usersCount);
        averageCommentsPerUser = ((usersCount == 0) || (postsCount == 0)) ? 0 : ((double) commentsCount / usersCount); // zakładam, że jeśli nie ma postów to nie powinno też być komentarzy więc średnia powinna być zero
        averageCommentsPerPost = (postsCount == 0) ? 0 : ((double) commentsCount / postsCount);
    }
    public void showStatistics(){
        System.out.println("Amount of users: " + usersCount);
        System.out.println("Amount of posts: " + postsCount);
        System.out.println("Amount of comments: " + commentsCount + "\n");
        System.out.println("Average posts per user: " + averagePostsPerUser);
        System.out.println("Average comments per user: " + averageCommentsPerUser);
        System.out.println("Average comments per post: " + averageCommentsPerPost);
    }
}
