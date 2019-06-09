package org.gnuton.test.dao;

import org.gnuton.test.models.Course;
import org.gnuton.test.models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// For standard CRUD operations there is no need to create a data layer
// First generic type: type of the element you are working with
// Second generic type: type of the primary key
public interface CourseRepo extends CrudRepository<Course, String> {
    // NOTE: if we name a method as findByProperty where property belongs to Course
    //       spring data JPA will implement the method for you
    public List<Course> findByName(String name);

    // NOTE: JPA can look into properties of topic too as long as we pass it into the name in camelCase
    public List<Course> findByTopicId(String topicId);
}
