package com.example.spring_demo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendController {

    FriendDAO friendDAO = new FriendDAO();
    List<Friend> allFriends = friendDAO.getAllFriends();

    @RequestMapping("/friend")
    public Friend returnFriend() {
        Friend friend = new Friend(1, "Emma", "Main Street, 34", "333 333-3355");
        return friend;
    }

    @RequestMapping("/friends")
    public List<Friend> getAllFriends() {
        return allFriends;
    }

    @RequestMapping("/friends/{id}")
    public Friend getFriendById(@PathVariable int id){
        for (Friend friend: allFriends) {
            if(friend.getId() == id){
                return friend;
            }
        }
        return null;
    }

    @RequestMapping("/friends/{id}/delete")
    public Response deleteFriendById(@PathVariable int id){
        Response res = new Response("Friend deleted", false);

        int indexToRemove = -1;
        for (int i = 0; i < allFriends.size(); i++) {
            if(allFriends.get(i).getId() == id){
                indexToRemove = i;
            }
        }

        if(indexToRemove != -1){
            allFriends.remove(indexToRemove);
            res.setStatus(true);
        }

        return res;
    }

    @PostMapping("/friend/add")
    public Response addFriend(@RequestBody Friend f){
        Response res = new Response("Friend added", Boolean.FALSE);
        allFriends.add(f);
        res.setStatus(Boolean.TRUE);
        return res;
    }

    @PostMapping("/friend/update")
    public Response updateFriend(@RequestBody Friend f){
        Response res = new Response("Friend updated", Boolean.FALSE);
        for (Friend friend: allFriends) {
            if(friend.getId() == f.getId()){
                friend.setName(f.getName());
                friend.setAdress(f.getAdress());
                friend.setPhonenumber(f.getPhonenumber());
                res.setStatus(Boolean.TRUE);
                return res;
            }
        }
        allFriends.add(f);
        res.setMassage("Friend added");
        res.setStatus(Boolean.TRUE);
        return res;
    }

}
