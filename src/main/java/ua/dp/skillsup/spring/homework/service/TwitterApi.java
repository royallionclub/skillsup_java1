package ua.dp.skillsup.spring.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.dp.skillsup.spring.homework.Post;

import java.util.Arrays;
import java.util.List;


@Component("twitterApi")
public class TwitterApi implements ServiceApi{
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Override
    public List<Post> getPosts() {
        System.out.println("Reading posts from Twitter with following credentials: " + username + "/" + password);
        //some fancy implementation here
        return Arrays.asList(
                new Post("I've just pooped", ""),
                new Post("My dog ate my homework", "http://twitter.com/badboy.jpg"),
                new Post("@realDonaldTrump you're wrong!", "")
        );
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
