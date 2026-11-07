
package com.logistics.tracking.service;

import com.logistics.tracking.client.ShipAnyClient;
import com.logistics.tracking.dto.TrackingResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrackingService {

    private final ShipAnyClient shipAnyClient;

    // Constructor injection
    public TrackingService(ShipAnyClient shipAnyClient) {
        this.shipAnyClient = shipAnyClient;
    }

    public TrackingResponse getTrackingDetails(String awb) {

        // Call external courier API
        Map<String, Object> response =
                shipAnyClient.trackShipment(awb);

        // Convert external response into our API DTO
        return new TrackingResponse(
                String.valueOf(response.get("awb")),
                String.valueOf(response.get("courier")),
                String.valueOf(response.get("status")),
                String.valueOf(response.get("current_location")),
                String.valueOf(response.get("estimated_delivery")),
                String.valueOf(response.get("message"))
        );
    }
}
