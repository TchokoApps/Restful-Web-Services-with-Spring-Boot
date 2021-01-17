package com.tchokoapps.springboot.restfulwebservices.repositories;

import com.tchokoapps.springboot.restfulwebservices.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
