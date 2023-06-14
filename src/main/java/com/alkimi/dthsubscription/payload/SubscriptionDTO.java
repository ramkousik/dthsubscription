package com.alkimi.dthsubscription.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SubscriptionDTO {
    private Long id;
    private String name;
    private Integer duration;
    private PackageDTO defaultPackage;
    private List<ChannelDTO> additionalChannels;
    private List<PackageDTO> additionalPackages;
    private PlanDTO plan;




}