package com.mjiang.email.web.rest;

import com.mjiang.email.model.HealthCheckStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckRestController {

    /**
     * Check status every certain duration to make sure the server is up.
     *
     * TODO: Add a rest controller to mark server down or up for testing
     *
     * @return
     */
    @RequestMapping("/rest/healthCheck")
    public ResponseEntity<HealthCheckStatus> checkHealth() {
        return null;
    }
}
