package com.project.giftoo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/comments")
public class CommentsController {

    @GetMapping("")
    public String comment() {
        return "nothing";
    }
}
