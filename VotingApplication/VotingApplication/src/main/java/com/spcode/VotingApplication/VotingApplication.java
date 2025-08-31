package com.spcode.VotingApplication;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

//@SpringBootApplication
public class VotingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VotingApplication.class, args);

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.spcode.VotingApplication");

        AuthorityCounter authorityCounter = (AuthorityCounter) applicationContext.getBean("authoritycounter");
        while (true) {
            System.out.println("Welcome user");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose from below:\n1. I wanna Vote \n2. See All Votes(ADMIN");
            int userInput = scanner.nextInt();
            String beanID = "";

            switch (userInput) {
                case 1: {
                    System.out.println("Enter your Username");
                    scanner.nextLine();
                    String userName = scanner.nextLine();
                    User user = (User) applicationContext.getBean("user");
                    user.setUserName(userName);

                    System.out.println("Choose the party you wants to vote for \n1. Democratic \n2. Republic \n3. Independent");
                    int userPartySelect = scanner.nextInt();

                    switch (userPartySelect) {

                        case 1: {
                            beanID = "democratic";
                            break;
                        }
                        case 2: {
                            beanID = "republic";
                            break;
                        }
                        case 3: {
                            beanID = "independent";
                            break;
                        }
                    }
                    PoliticalParty politicalParty = (PoliticalParty) applicationContext.getBean(beanID);
                    user.setPartyName(politicalParty);
                    UserList userList = (UserList) applicationContext.getBean("userlist");
                    userList.addUser(user);
                    break;
                }

                case 2: {
                    authorityCounter.getUserList().getUserList().forEach(item -> System.out.println(item.getUserName() + " is Voted for " + item.getpoliticalParty().getPartyName()));
                    break;
                }
            }
        }
	}

}
