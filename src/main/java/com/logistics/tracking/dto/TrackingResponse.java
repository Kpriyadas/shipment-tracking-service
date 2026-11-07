
package com.logistics.tracking.dto;

public record TrackingResponse(
        String awb,
        String courier,
        String status,
        String currentLocation,
        String estimatedDelivery,
        String message
) {
}
