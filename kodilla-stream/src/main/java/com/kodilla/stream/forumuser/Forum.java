package com.kodilla.stream.forumuser;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUsersList = new ArrayList<>();
    public Forum() {
        theForumUsersList.add(new ForumUser(1, "Dylan Murphy", 'M',"1998-02-20", 3));
        theForumUsersList.add(new ForumUser(2, "Phoebe Pearson", 'F',"1990-10-01", 5));
        theForumUsersList.add(new ForumUser(3, "Morgan Wals", 'M',"1980.11.21", 10));
        theForumUsersList.add(new ForumUser(4, "Aimee Murphy", 'F',"1976-05-05", 20));
        theForumUsersList.add(new ForumUser(5, "Ryan Talley", 'M',"1985-01-11", 0));
        theForumUsersList.add(new ForumUser(6, "Madelynn Carson", 'F',"1995-08-01", 11));
        theForumUsersList.add(new ForumUser(7, "Giancarlo Guerrero", 'M',"1965-12-31", 33));
        theForumUsersList.add(new ForumUser(8, "Robert Greenfield", 'M',"1999-10-01", 53));
        theForumUsersList.add(new ForumUser(9, "Monica Smith", 'F',"1988-02-10", 0));
        theForumUsersList.add(new ForumUser(10, "Steven Newmack", 'M',"1997;01;15", 1));
    }
    public List<ForumUser> getTheForumUsersList() {
        return new ArrayList<>(theForumUsersList);
    }
}