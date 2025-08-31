package com.spcode.VotingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("authoritycounter")
public class SimpleAuthorityCounter implements AuthorityCounter{

    @Autowired
    private UserList userList;

    @Override
    public UserList getUserList() {
        return this.userList;
    }
}
