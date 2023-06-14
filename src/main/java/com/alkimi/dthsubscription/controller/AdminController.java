package com.alkimi.dthsubscription.controller;

import com.alkimi.dthsubscription.payload.ChannelDTO;
import com.alkimi.dthsubscription.payload.PackageDTO;
import com.alkimi.dthsubscription.payload.PlanDTO;
import com.alkimi.dthsubscription.payload.SubscriptionDTO;
import com.alkimi.dthsubscription.service.ChannelService;
import com.alkimi.dthsubscription.service.PackageService;
import com.alkimi.dthsubscription.service.PlanService;
import com.alkimi.dthsubscription.service.SubscriptionService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RolesAllowed("ADMI")
public class AdminController {

    private final ChannelService channelService;
    private final PackageService packageService;
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    public AdminController(ChannelService channelService, PackageService packageService, PlanService planService, SubscriptionService subscriptionService) {
        this.channelService = channelService;
        this.packageService = packageService;
        this.planService = planService;
        this.subscriptionService = subscriptionService;
    }

    // Channel endpoints

    @GetMapping("/channels")
    public ResponseEntity<List<ChannelDTO>> getAllChannels() {
        List<ChannelDTO> channels = channelService.getAllChannels();
        return ResponseEntity.ok(channels);
    }
    @PostMapping("/channels")
    public ResponseEntity<ChannelDTO> createChannel(@RequestBody ChannelDTO channelDTO) {
        ChannelDTO createdChannel = channelService.createChannel(channelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChannel);
    }

    @PutMapping("/channels/{channelId}")
    public ResponseEntity<ChannelDTO> updateChannel(@PathVariable Long channelId, @RequestBody ChannelDTO channelDTO) {
        ChannelDTO updatedChannel = channelService.updateChannel(channelId, channelDTO);
        return ResponseEntity.ok(updatedChannel);
    }

    @DeleteMapping("/channels/{channelId}")
    public ResponseEntity<Void> deleteChannel(@PathVariable Long channelId) {
        channelService.deleteChannel(channelId);
        return ResponseEntity.noContent().build();
    }

    // Package endpoints
    @PostMapping("/packages")
    public ResponseEntity<PackageDTO> createPackage(@RequestBody PackageDTO packageDTO) {
        PackageDTO createdPackage = packageService.createPackage(packageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPackage);
    }

    @PutMapping("/packages/{packageId}")
    public ResponseEntity<PackageDTO> updatePackage(@PathVariable Long packageId, @RequestBody PackageDTO packageDTO) {
        PackageDTO updatedPackage = packageService.updatePackage(packageId, packageDTO);
        return ResponseEntity.ok(updatedPackage);
    }

    @DeleteMapping("/packages/{packageId}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long packageId) {
        packageService.deletePackage(packageId);
        return ResponseEntity.noContent().build();
    }

    // Plan endpoints
    @PostMapping("/plans")
    public ResponseEntity<PlanDTO> createPlan(@RequestBody PlanDTO planDTO) {
        PlanDTO createdPlan = planService.createPlan(planDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlan);
    }

    @PutMapping("/plans/{planId}")
    public ResponseEntity<PlanDTO> updatePlan(@PathVariable Long planId, @RequestBody PlanDTO planDTO) {
        PlanDTO updatedPlan = planService.updatePlan(planId, planDTO);
        return ResponseEntity.ok(updatedPlan);
    }

    @DeleteMapping("/plans/{planId}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long planId) {
        planService.deletePlan(planId);
        return ResponseEntity.noContent().build();
    }

    // Subscription endpoints
    @PostMapping("/subscriptions")
    public ResponseEntity<SubscriptionDTO> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO createdSubscription = subscriptionService.createSubscription(subscriptionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscription);
    }

    @PutMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable Long subscriptionId, @RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO updatedSubscription = subscriptionService.updateSubscription(subscriptionId, subscriptionDTO);
        return ResponseEntity.ok(updatedSubscription);
    }

    @DeleteMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
        return ResponseEntity.noContent().build();
    }
}
