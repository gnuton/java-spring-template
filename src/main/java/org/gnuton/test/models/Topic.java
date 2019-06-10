package org.gnuton.test.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @NonNull
    @Getter // Exposes Getters allowing spring RestController to serialize the data
    private String id, name, description;
}
