package org.gnuton.test.web;

import lombok.RequiredArgsConstructor;
import org.gnuton.test.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/data",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor // creates the constructor
public class DataController {
    @Autowired
    private DataService dataService;

    /*
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }*/

    @RequestMapping(method= RequestMethod.POST)
    public boolean add(String payload) {
        return dataService.add(payload);
    }
}
