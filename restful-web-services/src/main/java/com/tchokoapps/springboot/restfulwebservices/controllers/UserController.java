package com.tchokoapps.springboot.restfulwebservices.controllers;

import com.tchokoapps.springboot.restfulwebservices.domain.Post;
import com.tchokoapps.springboot.restfulwebservices.domain.User;
import com.tchokoapps.springboot.restfulwebservices.exceptions.UserNotFoundException;
import com.tchokoapps.springboot.restfulwebservices.repositories.PostRepository;
import com.tchokoapps.springboot.restfulwebservices.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostsByUserId(@PathVariable int id) {
        Optional<User> userOpt = userRepository.findById(id);

        if (!userOpt.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        return userOpt.get().getPosts();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> userOpt = userRepository.findById(id);

        if (!userOpt.isPresent())
            throw new UserNotFoundException("id-" + id);

        EntityModel<User> resource = EntityModel.of(userOpt.get());

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> userOpt = userRepository.findById(id);
        if(!userOpt.isPresent())
            throw new UserNotFoundException(String.format("User with id=%s cannot be found", id));

        post.setUser(userOpt.get());

        @Valid Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}