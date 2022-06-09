package com.ifsp.comenteSobre.service;

import com.ifsp.comenteSobre.model.Post;

import java.util.List;

public interface ComentesobreService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);

}
