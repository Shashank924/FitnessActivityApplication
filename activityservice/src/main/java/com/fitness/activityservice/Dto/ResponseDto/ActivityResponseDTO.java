package com.fitness.activityservice.Dto.ResponseDto;

import com.fitness.activityservice.Model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

public class ActivityResponseDTO {

    private String id;
    private int userId;
    private ActivityType activityType;
    private int durationInMinutes;
    private Map<String , Object> additionalMetrics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Map<String, Object> getAdditionalMetrics() {
        return additionalMetrics;
    }

    public void setAdditionalMetrics(Map<String, Object> additionalMetrics) {
        this.additionalMetrics = additionalMetrics;
    }

    public ActivityResponseDTO(int userId, String id, int durationInMinutes, Map<String, Object> additionalMetrics, ActivityType activityType) {
        this.userId = userId;
        this.id = id;
        this.durationInMinutes = durationInMinutes;
        this.additionalMetrics = additionalMetrics;
        this.activityType = activityType;
    }

    public ActivityResponseDTO() {
    }

    @Override
    public String toString() {
        return "ActivityResponseDTO{" +
                "activityType=" + activityType +
                ", id='" + id + '\'' +
                ", userId=" + userId +
                ", durationInMinutes=" + durationInMinutes +
                ", additionalMetrics=" + additionalMetrics +
                '}';
    }
}
