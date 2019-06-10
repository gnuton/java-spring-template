package org.gnuton.test.web;

import org.gnuton.test.models.Topic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class HealthCtrl {
    @GetMapping("/health")
    public ResponseEntity<Object> run(){
        RestTemplate r = new RestTemplate();

        // sending a post
        Topic topicToAdd = new Topic("testId", "testName", "testDesc");
        r.postForObject("http://localhost:8083/topics", topicToAdd, Topic.class);

        // This  shows how to get GET data and deserialize an array of JSONs
        Topic[] topics = r.getForObject("http://localhost:8083/topics", Topic[].class);
        int nOfTestTopics = (int) Arrays.stream(topics).filter(t->t.getId().equals(topicToAdd.getId())).count();

        if (nOfTestTopics < 5){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(null);
    }
}
