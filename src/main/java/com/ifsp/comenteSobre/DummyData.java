package com.ifsp.comenteSobre;

import com.ifsp.comenteSobre.model.Post;
import com.ifsp.comenteSobre.repository.ComenteSobreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class DummyData {

    @Autowired
    ComenteSobreRepository comenteSobreRepository;

//    @PostConstruct
    public void savePosts(){
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("Igor ujiie");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Lorem ipsum");

        Post post2 = new Post();
        post2.setAutor("IRiva");
        post2.setData(LocalDate.now());
        post2.setTitulo("API REST");
        post2.setTexto("Lorem ipsum");

        postList.add(post1);
        postList.add(post2);

        for (Post post: postList){
            Post postSaved = comenteSobreRepository.save(post);
            System.out.println(postSaved.getId());
        }


    }

}
