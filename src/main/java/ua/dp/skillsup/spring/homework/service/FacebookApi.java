package ua.dp.skillsup.spring.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.dp.skillsup.spring.homework.Post;

import java.util.Arrays;
import java.util.List;

@Component
public class FacebookApi implements ServiceApi{
    @Value("${facebookLogin}")
    private String apiKey;
    @Value("${facebookPassword}")
    private String secret;

    @Override
    public List<Post> getPosts() {
        System.out.println("Reading posts from Facebook with following credentials: " + apiKey + "/" + secret);
        //some fancy implementation here
        return Arrays.asList(
                new Post("I’m Living Quite the Life", "http://facebook.com/bragging_photo.jpg"),
                new Post("je suis git", ""),
                new Post("Dogs are awesome", "http://facebook.com/goodboy.jpg")
        );
    }


    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }
}
