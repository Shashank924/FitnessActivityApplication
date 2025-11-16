package com.fitness.activityservice.Dto.RequestDto;

import com.fitness.activityservice.Model.ActivityType;
import lombok.Data;

import java.util.Map;

@Data
public class ActivityRequestDTO {
    private int userId;
    private ActivityType activityType;
    private int durationInMinutes;
    private Map<String , Object> additionalMetrics;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
