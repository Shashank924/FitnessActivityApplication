package com.fitness.activityservice.Repository;

import com.fitness.activityservice.Model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    public List<Activity> findByUserId(int userId);
}
