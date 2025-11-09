package com.fitness.activityservice.Dto.ResponseDto;

import com.fitness.activityservice.Model.ActivityType;
import lombok.Data;

import java.util.Map;

@Data
public class ActivityResponseDTO {

    private String id;
    private int userId;
    private ActivityType activityType;
    private int durationInMinutes;
    private Map<String , Object> additionalMetrics;
}
