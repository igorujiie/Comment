package com.ifsp.comenteSobre.repository;

import com.ifsp.comenteSobre.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComenteSobreRepository extends JpaRepository<Post, Long> {
}
