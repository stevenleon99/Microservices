package com.robotpal.robotservice.repository;

import com.robotpal.robotservice.model.Position;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PositionRepository extends MongoRepository<Position, String> {

}
