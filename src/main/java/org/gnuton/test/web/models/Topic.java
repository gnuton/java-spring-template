package org.gnuton.test.web.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Topic {
    @NonNull
    @Getter // Exposes Getters allowing spring RestController to serialize the data
    private final String id, name, description;
}
