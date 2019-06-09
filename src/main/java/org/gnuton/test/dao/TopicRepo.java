package org.gnuton.test.dao;

import org.gnuton.test.models.Topic;
import org.springframework.data.repository.CrudRepository;

// For standard CRUD operations there is no need to create a data layer
// First generic type: type of the element you are working with
// Second generic type: type of the primary key
public interface TopicRepo extends CrudRepository<Topic, String> {}
