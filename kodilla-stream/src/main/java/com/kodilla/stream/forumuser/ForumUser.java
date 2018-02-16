package com.kodilla.stream.forumuser;
import java.time.LocalDate;

public class ForumUser {
    private final int uniqueID;
    private final String userName;
    private final char gender;
    private final LocalDate birthDate;
    private final int postsCount;
    public ForumUser(final int uniqueID, final String userName, final char gender, final String birthDateString, final int postsCount) {
        this.uniqueID = uniqueID;
        this.userName = userName;
        this.gender = gender;
        this.birthDate = LocalDate.of(Integer.parseInt(birthDateString.substring(0,4)),Integer.parseInt(birthDateString.substring(5,7)),Integer.parseInt(birthDateString.substring(8)));
        this.postsCount = postsCount;
    }
    public int getUniqueID() {
        return uniqueID;
    }
    public String getUserName() {
        return userName;
    }
    public char getGender() {
        return gender;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public int getPostsCount() {
        return postsCount;
    }
    @Override
    public String toString() {
        return "UserID=" + uniqueID +
                ",\tName: " + userName +
                ",\tGender: " + gender +
                ",\tBirth Date: " + birthDate +
                ",\tNumber of posts: " + postsCount;
    }
}