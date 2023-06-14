package com.alkimi.dthsubscription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "default_package_id")
    private Package defaultPackage;

    @ManyToMany
    @JoinTable(name = "subscription_channel",
            joinColumns = @JoinColumn(name = "subscription_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private List<Channel> additionalChannels;

    @ManyToMany
    @JoinTable(name = "subscription_package",
            joinColumns = @JoinColumn(name = "subscription_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id"))
    private List<Package> additionalPackageEntities;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @OneToMany(mappedBy = "subscription")
    private List<Package> additionalPackages;

}