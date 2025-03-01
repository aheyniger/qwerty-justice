package com.qwerty.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class ChatGPT {
    public static String sendPrompt(String prompt) {
       String uri = "https://api.openai.com/v1/chat/completions";
       String apiKey = System.getenv("GPT_KEY");
       String model = "ft:gpt-3.5-turbo-1106:personal::B6Nze977";

       try {
            // URI uriObj = new URI(uri);
            // URL obj = uriObj.toURL();
            URL obj = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
        
            System.out.println("--------------------------------");
            System.out.println("\nSending prompt...");
            // The request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuffer response = new StringBuffer();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            System.out.println("Received response: " + response.toString());
            System.out.println("--------------------------------");
            // calls the method to extract the message.
            return extractMessageFromJSONResponse(response.toString());

        }
        // catch (URISyntaxException e) {
        //     throw new RuntimeException(e);
        // }
        catch (IOException e) {
            throw new RuntimeException("Runtime exception: " + e);
        }
   }

   public static String extractMessageFromJSONResponse(String response) {
       int start = response.indexOf("content")+ 11;

       int end = response.indexOf("\"", start);

       return response.substring(start, end);

   }
}
