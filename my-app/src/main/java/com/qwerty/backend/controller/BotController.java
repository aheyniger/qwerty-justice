package com.qwerty.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qwerty.backend.Prompt;

@RestController
@RequestMapping("/api")
public class BotController {

    @PostMapping(value = "/sendPrompt", consumes = "application/json")
    public String receiveText(@RequestBody Prompt prompt) {
        System.out.println("Got prompt!!");
        System.out.println(prompt.query);
        // String response = ChatGPT.sendPrompt(prompt.promptBody);
        
        String response = "{\"answer\": \"" + prompt.query + "\"}";
        response = response.replace("\n", "\\n");
        return response;

        // return "Received: " + prompt.promptBody;
    }

}


