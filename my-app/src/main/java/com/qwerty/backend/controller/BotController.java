package com.qwerty.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qwerty.backend.helpers.ChatGPT;
import com.qwerty.backend.helpers.Prompt;

@RestController
@RequestMapping("/api")
public class BotController {

    @PostMapping(value = "/ask", consumes = "application/json")
    public String receiveText(@RequestBody Prompt prompt) {

        String response = ChatGPT.sendPrompt(prompt.promptBody);
        return response;

        // return "Received: " + prompt.promptBody;
    }

}


