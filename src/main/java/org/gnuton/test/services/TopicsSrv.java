package org.gnuton.test.services;

import org.gnuton.test.dao.TopicRepo;
import org.gnuton.test.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicsSrv {
    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> getAll() {
        ArrayList<Topic> topics = new ArrayList<>();
        topicRepo.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getOne(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepo.findById(id).get();
    }

    public void add(Topic topicToAdd){
        topicRepo.save(topicToAdd);
    }

    public void update(String id, Topic newTopic) {
        this.add(newTopic); // this works because id is a primary key
    }

    public void remove(String id) {
        topicRepo.deleteById(id);
    }
}
