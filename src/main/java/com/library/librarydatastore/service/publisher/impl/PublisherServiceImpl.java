package com.library.librarydatastore.service.publisher.impl;

import com.library.librarydatastore.entities.Publisher;
import com.library.librarydatastore.model.request.PublisherRequest;
import com.library.librarydatastore.repositories.PublisherRepository;
import com.library.librarydatastore.service.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher findByPublisherId(Integer publisherId) {
        return publisherRepository.findById(publisherId).get();

    }

    @Override
    public Integer addPublisher(PublisherRequest publisherRequest) {
        Publisher publisherToAdd = new Publisher();
        publisherToAdd.setPhoneNumber(publisherRequest.getPhoneNumber());
        publisherToAdd.setBooksByPublisherId(publisherRequest.getBooksByPublisherId());
        publisherToAdd.setName(publisherRequest.getName());
        publisherToAdd.setEmailId(publisherRequest.getEmailId());

        Publisher publisher = publisherRepository.save(publisherToAdd);
        return publisher.getPublisherId();
    }

    @Override
    public void deletePubsliher(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public Integer updatePublisherInformation(PublisherRequest publisherRequest) {
        Publisher publisher = findByPublisherId(publisherRequest.getPublisherId());
        if (publisher != null) {
            PublisherRequest publisherToBeUpdated = new PublisherRequest();
            publisherToBeUpdated.setEmailId(publisherRequest.getEmailId());
            publisherToBeUpdated.setName(publisherRequest.getName());
            publisherToBeUpdated.setPhoneNumber(publisherRequest.getPhoneNumber());
            publisherToBeUpdated.setBooksByPublisherId(publisherRequest.getBooksByPublisherId());
            return addPublisher(publisherToBeUpdated);
        }
        throw new RuntimeException("Publisher to Update not found");
    }
}
