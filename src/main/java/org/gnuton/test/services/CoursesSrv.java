package org.gnuton.test.services;

import org.gnuton.test.dao.CourseRepo;
import org.gnuton.test.dao.TopicRepo;
import org.gnuton.test.models.Course;
import org.gnuton.test.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesSrv {
    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAll(String topicId) {
        ArrayList<Course> courses = new ArrayList<>();
        courseRepo.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getOne(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepo.findById(id).get();
    }

    public void add(Course c){
        courseRepo.save(c);
    }

    public void update(Course c) {
        this.add(c); // this works because id is a primary key
    }

    public void remove(String id) {
        courseRepo.deleteById(id);
    }
}
