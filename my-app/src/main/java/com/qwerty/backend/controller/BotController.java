package com.qwerty.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BotController {

    @PostMapping(value = "/sendPrompt", consumes = "application/json")
    public String receiveText(@RequestBody String prompt) {
        System.out.println("Got prompt!!");
        System.out.println(prompt);
        // String response = ChatGPT.sendPrompt(prompt.promptBody);
        String response = prompt;
        return response;

        // return "Received: " + prompt.promptBody;
    }

}


