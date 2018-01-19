package ua.dp.skillsup.spring.homework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
import ua.dp.skillsup.spring.homework.service.ServiceApi;

import java.util.List;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;



public class PostProvider {


    private ServiceApi serviceApi;
    private PostFilter postFilter;
    private String keyWord;


    public List<Post> getPosts(){
        return postFilter.filterByKeyword(serviceApi.getPosts(), keyWord);
    }


    public ServiceApi getServiceApi() {
        return serviceApi;
    }


    public void setServiceApi(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    public PostFilter getPostFilter() {
        return postFilter;
    }

    public void setPostFilter(PostFilter postFilter) {
        this.postFilter = postFilter;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
