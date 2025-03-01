package com.qwerty.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qwerty.backend.ChatGPT;
import com.qwerty.backend.Prompt;

@RestController
@RequestMapping("/api")
public class BotController {

    @PostMapping(value = "/sendPrompt", consumes = "application/json")
    public String receiveText(@RequestBody Prompt prompt) {
        System.out.println("Got prompt!!");
        System.out.println(prompt.query);
        String response = ChatGPT.sendPrompt(prompt.query);
        
        String responseJson = "{\"answer\": \"" + response + "\"}";
        responseJson = responseJson.replace("\n", "<br>");
        return responseJson;

        // return "Received: " + prompt.promptBody;
    }

}


