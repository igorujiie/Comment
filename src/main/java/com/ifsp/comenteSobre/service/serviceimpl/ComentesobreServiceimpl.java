package com.ifsp.comenteSobre.service.serviceimpl;

import com.ifsp.comenteSobre.model.Post;
import com.ifsp.comenteSobre.repository.ComenteSobreRepository;
import com.ifsp.comenteSobre.service.ComentesobreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComentesobreServiceimpl implements ComentesobreService {

    @Autowired
    ComenteSobreRepository comenteSobreRepository;

    @Override
    public List<Post> findAll() {
        return comenteSobreRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return comenteSobreRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return comenteSobreRepository.save(post);
    }
}
