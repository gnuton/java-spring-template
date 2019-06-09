package org.gnuton.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data // = @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
      // There are no final fields since Hibernate wants to use NoArgs constructor
      // so there are no required fields
@Entity // Defines an entity to be persisted with the following fields
@AllArgsConstructor
@NoArgsConstructor // Hibernate requires it for storing this data
public class Course {
    @Id // set this var as primary key in the DB - cannot be null
    private  String id;
    @NotNull // enforce not null for the rest of fields too
    private  String name, description;
    @ManyToOne // Many Courses can have the same topic now for JPA
    private Topic topic;
}
