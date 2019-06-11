package org.gnuton.test.services;

import org.gnuton.test.models.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicsSrv {
    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
            new Topic("id1", "name1", "desc1"),
            new Topic("id2", "name2", "desc2"),
            new Topic("id3", "name3", "desc3"),
            new Topic("id4", "name4", "desc4")
    ));

    public List<Topic> getAll() {
        return this.topics;
    }

    public Topic getOne(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public boolean add(Topic topicToAdd){
        System.out.println(topicToAdd);
        topics.add(topicToAdd);
        return true;
    }

    public void update(String id, Topic newTopic) {
        for (int i=0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)){
                topics.set(i, newTopic);
                return;
            }
        }
    }

    public void remove(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
