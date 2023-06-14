package com.alkimi.dthsubscription.service;

import com.alkimi.dthsubscription.entity.Package;
import com.alkimi.dthsubscription.payload.PackageDTO;

import java.util.List;

public interface PackageService {
    PackageDTO getPackageById(Long packageId);
    List<PackageDTO> getAllPackages();
    PackageDTO updatePackage(Long packageId, PackageDTO packageDTO);
    PackageDTO createPackage(PackageDTO packageDTO);
    void deletePackage(Long packageId);


}
