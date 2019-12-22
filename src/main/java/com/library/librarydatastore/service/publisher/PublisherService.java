package com.library.librarydatastore.service.publisher;

import com.library.librarydatastore.entities.Publisher;
import com.library.librarydatastore.model.request.PublisherRequest;

public interface PublisherService {
    Publisher findByPublisherId(Integer publisherId);

    Integer addPublisher(PublisherRequest publisherRequest);

    void deletePubsliher(Integer publisherId);

    Integer updatePublisherInformation(PublisherRequest publisherRequest);

}
