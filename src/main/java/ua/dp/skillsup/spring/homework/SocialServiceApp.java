package ua.dp.skillsup.spring.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SocialServiceApp {
    List<PostProvider> providers;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("socialApplicationContext.xml");
        new SocialServiceApp().run();
    }

    public void run(){
        List<Post> posts = new ArrayList<>();
        for (PostProvider provider : providers) {
            posts.addAll(provider.getPosts());
        }
        System.out.println("Filtered posts:");
        for (Post post : posts) {
            System.out.println(post);
        }
    }
}
