
package com.logistics.tracking.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
public class ShipAnyClient {

    private final RestClient restClient;

    public ShipAnyClient(
            @Qualifier("shipAnyRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public Map<String, Object> trackShipment(String awb) {

        return restClient.get()
                .uri("/api/tracking/{awb}", awb)
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});
    }
}
