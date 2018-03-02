package com.kodilla.good.patterns.challenges.definitions;
import com.kodilla.good.patterns.challenges.Item;
import com.kodilla.good.patterns.challenges.User;
import java.util.ArrayList;
import java.util.List;

public final class Definitions {

    public static List<User> getUsers() {
        final List<User> users = new ArrayList<>();
        users.add(new User("John Doe1", "johndoe1@gmail.com"));
        users.add(new User("John Doe2", "johndoe2@gmail.com"));
        users.add(new User("John Doe3", "johndoe3@gmail.com"));
        users.add(new User("John Doe4", "johndoe4@gmail.com"));
        users.add(new User("John Doe5", "johndoe5@gmail.com"));
        users.add(new User("John Doe6", "johndoe6@gmail.com"));
        return new ArrayList<>(users);
    }

    public static List<Item> getItems() {
        final List<Item> items = new ArrayList<>();
        items.add(new Item("Samsung Galaxy","Mobile phone", 1));
        items.add(new Item("Apple iPhone","Mobile phone", 1));
        items.add(new Item("Kindle E-reader","Mobile phone", 1));
        items.add(new Item("BLACK+DECKER LDX120C 20-Volt MAX ","Lithium-Ion Cordless Drill/Driver", 1));
        items.add(new Item("Yamaha FG840","Solid Top Acoustic Guitar, Flamed Maple ", 1));
        items.add(new Item("Texas Instruments TI-30X IIS","2-Line Scientific Calculator, Black with Blue Accents", 1));
        items.add(new Item("Hiking Daypack","Lightweight Packable Backpack Water Resistant,Small Backpack Handy Foldable Camping Outdoor Backpack Little Bag", 1));
        items.add(new Item("Coleman Sundome","4 Person Tent (Green and Navy color options)", 1));
        return new ArrayList<>(items);
    }
}
