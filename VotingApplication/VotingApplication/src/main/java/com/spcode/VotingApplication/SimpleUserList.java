package com.spcode.VotingApplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component("userlist")
public class SimpleUserList implements UserList{

    List<User> ListOfUsers;

    public SimpleUserList(){
        this.ListOfUsers = new ArrayList<User>();
    }

    @Override
    public void addUser(User user) {
        ListOfUsers.add(user);
    }

    @Override
    public List<User> getUserList() {
        return this.ListOfUsers;
    }
}
