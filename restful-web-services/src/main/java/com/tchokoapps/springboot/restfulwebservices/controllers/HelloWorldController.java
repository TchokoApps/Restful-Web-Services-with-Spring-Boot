package com.tchokoapps.springboot.restfulwebservices.controllers;

import com.tchokoapps.springboot.restfulwebservices.beans.HelloWorldBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        HelloWorldBean helloWorldBean = new HelloWorldBean("Hello World Bean");
        log.info(helloWorldBean.toString());
        return helloWorldBean;
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        HelloWorldBean helloWorldBean = new HelloWorldBean(String.format("Hello World, %s", name));
        log.info(helloWorldBean.toString());
        return helloWorldBean;
    }
}
