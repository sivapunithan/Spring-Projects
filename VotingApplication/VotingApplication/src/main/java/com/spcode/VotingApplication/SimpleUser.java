package com.spcode.VotingApplication;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user")
@Scope("prototype")
public class SimpleUser implements User{

    private String userName;
    private PoliticalParty politicalParty;

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setPartyName(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    @Override
    public PoliticalParty getpoliticalParty() {
        return this.politicalParty;
    }
}
