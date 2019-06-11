package org.gnuton.test.web;

import org.gnuton.test.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@RestController
public class Health2Ctrl {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/health2")
    public ResponseEntity<Object> run(){
        // sending a post
        Topic topicToAdd = new Topic("testId", "testName", "testDesc");
        webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/topics")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromObject(topicToAdd)).exchange().block();

        // This  shows how to get GET data and deserialize an array of JSONs
        Topic[] topics = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/topics")
                .retrieve()
                .bodyToMono(Topic[].class)// Mono is a reactive way to say "Promise"
                .block(); // await for the mono to be resolved

        int nOfTestTopics = (int) Arrays.stream(topics).filter(t->t.getId().equals(topicToAdd.getId())).count();

        if (nOfTestTopics < 5){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(null);
    }
}
