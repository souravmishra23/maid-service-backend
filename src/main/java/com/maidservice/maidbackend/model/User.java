package com.maidservice.maidbackend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String password;
    private String role;     // USER, MAID, ADMIN
    private String location;
    private boolean enabled;
}
