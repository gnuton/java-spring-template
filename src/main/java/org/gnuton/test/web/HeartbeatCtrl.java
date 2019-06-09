package org.gnuton.test.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/heartbeat", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HeartbeatCtrl {
    @ResponseBody
    @RequestMapping(method = GET)
    public Boolean getHearthbeat() {
        return true;
    }
}
