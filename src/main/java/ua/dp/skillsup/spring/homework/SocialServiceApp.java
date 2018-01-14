package ua.dp.skillsup.spring.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dp.skillsup.spring.homework.service.FacebookApi;

import java.util.ArrayList;
import java.util.List;

public class SocialServiceApp {
    List<PostProvider> providers;


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("socialApplicationContext.xml");
        System.out.println("Context initialised");
        SocialServiceApp socialServiceApp = (SocialServiceApp) context.getBean("socialServiceApp");
        socialServiceApp.run();
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

    public List<PostProvider> getProviders() {
        return providers;
    }

    public void setProviders(List<PostProvider> providers) {
        this.providers = providers;
    }
}
