package com.fitness.activityservice.Controller;

import com.fitness.activityservice.Dto.RequestDto.ActivityRequestDTO;
import com.fitness.activityservice.Dto.ResponseDto.ActivityResponseDTO;
import com.fitness.activityservice.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponseDTO> saveActivity(@RequestBody ActivityRequestDTO requestDTO) {
        ActivityResponseDTO response = activityService.saveActivity(requestDTO);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ActivityResponseDTO>> getAllActivityForUser(@PathVariable int userId) {
        return ResponseEntity.ok(activityService.getAllActivityForUser(userId));
    }

    @GetMapping
    public ResponseEntity<ActivityResponseDTO> getActivityById(@RequestHeader("X-Activity-ID") String id) {
        return ResponseEntity.ok(activityService.getActivity(id));
    }
}
