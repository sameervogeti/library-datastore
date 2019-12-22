package com.library.librarydatastore.controllers;

import com.library.librarydatastore.model.request.PublisherRequest;
import com.library.librarydatastore.service.publisher.impl.PublisherServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/v1/library-datastore/publisher")
public class PublisherController {

    @Autowired
    PublisherServiceImpl publisherService;

    @PostMapping
    public ResponseEntity<Integer> createPublisher(@RequestBody PublisherRequest publisherRequest) {
        return new ResponseEntity(publisherService.addPublisher(publisherRequest), HttpStatus.CREATED);
    }

    @GetMapping("/getpublisherDetails/{publisherId}")
    public ResponseEntity<Integer> getPublisher(@PathVariable Integer publisherId) {
        return new ResponseEntity(publisherService.findByPublisherId(publisherId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Integer> updatePublisher(@RequestBody PublisherRequest publisherRequest) {
        return new ResponseEntity(publisherService.updatePublisherInformation(publisherRequest), HttpStatus.OK);
    }
}
