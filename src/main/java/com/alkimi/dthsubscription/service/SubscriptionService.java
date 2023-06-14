package com.alkimi.dthsubscription.service;

import com.alkimi.dthsubscription.payload.ChannelDTO;
import com.alkimi.dthsubscription.payload.SubscriptionDTO;

import java.util.List;

public interface SubscriptionService {

    SubscriptionDTO getSubscriptionById(Long subscriptionId);

    List<SubscriptionDTO> getAllSubscriptions();

    SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO);

    void deleteSubscription(Long subscriptionId);

    SubscriptionDTO updateSubscription(Long subscriptionId, SubscriptionDTO subscriptionDTO);
}