package com.example.spring_demo;

import java.util.ArrayList;
import java.util.List;

public class FriendDAO {
    public List<Friend> getAllFriends() {
        List<Friend> friendList = new ArrayList();
        Friend f1 = new Friend(1, "Emma", "Main Street", "333 333-777");
        Friend f2 = new Friend(2, "Sam", "Industry Street", "333 333-778");
        Friend f3 = new Friend(3, "Atlas", "Brooklyn Street", "333 333-779");
        Friend f4 = new Friend(4, "Alyssa", "Liberty Street", "333 333-835");
        Friend f5 = new Friend(5, "Jane", "Brigenton Street", "333 333-376");

        friendList.add(f1);
        friendList.add(f2);
        friendList.add(f3);
        friendList.add(f4);
        friendList.add(f5);

        return friendList;

    }
}
