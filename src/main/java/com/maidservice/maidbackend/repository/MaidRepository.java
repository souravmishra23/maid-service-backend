package com.maidservice.maidbackend.repository;


import com.maidservice.maidbackend.model.Maid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaidRepository extends MongoRepository<Maid, String> {
    List<Maid> findByLocationContainingIgnoreCase(String location);
    List<Maid> findByServicesContainingIgnoreCase(String service);
    List<Maid> findByLocationContainingIgnoreCaseAndServicesContainingIgnoreCase(String location, String service);
}
