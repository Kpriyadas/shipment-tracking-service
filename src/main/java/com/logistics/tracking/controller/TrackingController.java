package com.logistics.tracking.controller;

import com.logistics.tracking.dto.TrackingResponse;
import com.logistics.tracking.service.TrackingService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/{awb}")
    public TrackingResponse getTrackingDetails(
            @PathVariable
            @NotBlank(message = "AWB number cannot be blank")
            String awb) {

        return trackingService.getTrackingDetails(awb);
    }
}