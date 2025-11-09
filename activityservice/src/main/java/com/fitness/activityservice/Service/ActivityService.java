package com.fitness.activityservice.Service;

import com.fitness.activityservice.Dto.RequestDto.ActivityRequestDTO;
import com.fitness.activityservice.Dto.ResponseDto.ActivityResponseDTO;
import com.fitness.activityservice.Model.Activity;
import com.fitness.activityservice.Repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ModelMapper mapper;

    public ActivityResponseDTO saveActivity(ActivityRequestDTO dto) {
        Activity activity = new Activity();
        mapper.map(dto , activity);

        Activity savedActivity = activityRepository.save(activity);

        ActivityResponseDTO response = new ActivityResponseDTO();
        mapper.map(savedActivity , response);

        return response;
    }

    public List<ActivityResponseDTO> getAllActivityForUser(int userId) {

        List<Activity> activities = activityRepository.findByUserId(userId);

        return activities
                .stream().map(this::mapToActivityResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponseDTO getActivity(String id) {

        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity Not Found With id : " + id));

        ActivityResponseDTO response = new ActivityResponseDTO();
        mapper.map(activity , response);
        return response;
    }

    public ActivityResponseDTO mapToActivityResponse(Activity activity) {
        ActivityResponseDTO response = new ActivityResponseDTO();
        mapper.map(activity , response);
        return response;
    }
}
