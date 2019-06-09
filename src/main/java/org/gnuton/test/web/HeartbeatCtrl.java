package org.gnuton.test.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatCtrl {
    @GetMapping(value = "/heartbeat")
    public Boolean getHearthbeat() {
        return true;
    }
}
