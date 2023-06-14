package com.alkimi.dthsubscription.service.implementation;

import com.alkimi.dthsubscription.entity.Subscription;
import com.alkimi.dthsubscription.exception.NotFoundException;
import com.alkimi.dthsubscription.payload.SubscriptionDTO;
import com.alkimi.dthsubscription.repository.SubscriptionRepository;
import com.alkimi.dthsubscription.service.SubscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionServiceImplementation implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ModelMapper modelMapper;

    public SubscriptionServiceImplementation(SubscriptionRepository subscriptionRepository, ModelMapper modelMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscriptionEntity = modelMapper.map(subscriptionDTO, Subscription.class);
        Subscription createdSubscription = subscriptionRepository.save(subscriptionEntity);
        return modelMapper.map(createdSubscription, SubscriptionDTO.class);
    }

    @Override
    public SubscriptionDTO getSubscriptionById(Long subscriptionId) {
        Subscription subscriptionEntity = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new NotFoundException("Subscription not found"));
        return modelMapper.map(subscriptionEntity, SubscriptionDTO.class);
    }

    @Override
    public List<SubscriptionDTO> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        return subscriptions.stream()
                .map(subscription -> modelMapper.map(subscription, SubscriptionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        Subscription subscriptionEntity = subscriptionRepository.findById(subscriptionId)
                        .orElseThrow(() -> new NotFoundException("Not found with id: " + subscriptionId));
        subscriptionRepository.delete(subscriptionEntity);
    }

    @Override
    public SubscriptionDTO updateSubscription(Long subscriptionId, SubscriptionDTO subscriptionDTO) {
        Subscription subscriptionEntity = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new NotFoundException("Subscription not found"));
        modelMapper.map(subscriptionDTO, subscriptionEntity);
        Subscription updatedSubscription = subscriptionRepository.save(subscriptionEntity);
        return modelMapper.map(updatedSubscription, SubscriptionDTO.class);
    }
}
