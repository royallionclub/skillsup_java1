package ua.dp.skillsup.spring.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SocialServiceApp {

    @Autowired
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
