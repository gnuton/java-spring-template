package org.gnuton.test.web;

import org.gnuton.test.models.Course;
import org.gnuton.test.models.Topic;
import org.gnuton.test.services.CoursesSrv;
import org.gnuton.test.services.TopicsSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CoursesCtrl {
    @Autowired
    private CoursesSrv coursesSrv;

    @GetMapping(value = "/topics/{topicId}/courses")
    public List<Course> list(@PathVariable String topicId) {
        return coursesSrv.getAll(topicId);
    }

    @GetMapping(value = "/topics/{topicId}/courses/{id}")
    public Course getOne(
            @PathVariable String topicId,
            @PathVariable String id){
        return coursesSrv.getOne(id);
    }

    @PostMapping(
            value = "/topics/{topicId}/courses",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(
            @PathVariable String topicId,
            @RequestBody Course c)
    {
        c.setTopic(new Topic(topicId, "", "")); // Create a topic with just the id is enough
        coursesSrv.add(c);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{id}")
    public void delete(@PathVariable String id) {
        coursesSrv.remove(id);
    }

    @PutMapping(
            value = "/topics/{topicId}/courses/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(
            @PathVariable String topicId,
            @PathVariable String id,
            @RequestBody Course c)
    {
        c.setTopic(new Topic(topicId, "", ""));
        coursesSrv.update(c);
    }
}

