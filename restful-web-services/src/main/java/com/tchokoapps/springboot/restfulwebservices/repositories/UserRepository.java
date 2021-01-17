package com.tchokoapps.springboot.restfulwebservices.repositories;

import com.tchokoapps.springboot.restfulwebservices.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
