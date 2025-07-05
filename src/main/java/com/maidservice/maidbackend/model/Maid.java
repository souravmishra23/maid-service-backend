package com.maidservice.maidbackend.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "maids")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maid {
    @Id
    private String id;

    private String name;
    private int experience;
    private List<String> services;
    private String location;
    private String availability;
    private boolean verified;
    private double hourlyRate;
    private double rating;
}
