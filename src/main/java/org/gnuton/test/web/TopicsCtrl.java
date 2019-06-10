package org.gnuton.test.web;

import org.gnuton.test.services.TopicsSrv;
import org.gnuton.test.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TopicsCtrl {
    @Autowired
    private TopicsSrv topicsSrv;

    /* This is not actually needed since RequiredArgsConstructor from lombok provides it
    public TopicsCtrl(TopicsSrv topicsSrv) {
        this.topicsSrv = topicsSrv;
    }*/

    @PutMapping(
            value = "/topics/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@PathVariable String id, @RequestBody Topic topicToDelete){
        topicsSrv.update(id, topicToDelete);
    }

    @GetMapping(value = "/topics")
    public List<Topic> list() {
        return topicsSrv.getAll();
    }

    @GetMapping(value = "topics/{id}")
    public Topic getOne(@PathVariable String id){
        return topicsSrv.getOne(id);
    }

    @PostMapping(
            value = "/topics",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Topic topicToAdd) {
        topicsSrv.add(topicToAdd);
    }

    @DeleteMapping(value = "/topics/{id}")
    public void delete(@PathVariable String id) {
        topicsSrv.remove(id);
    }
}

