package com.alkimi.dthsubscription.service.implementation;

import com.alkimi.dthsubscription.entity.Package;
import com.alkimi.dthsubscription.exception.NotFoundException;
import com.alkimi.dthsubscription.payload.PackageDTO;
import com.alkimi.dthsubscription.repository.PackageRepository;
import com.alkimi.dthsubscription.service.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PackageServiceImplementation implements PackageService {

    private final PackageRepository packageRepository;
    private final ModelMapper modelMapper;

    public PackageServiceImplementation(PackageRepository packageRepository, ModelMapper modelMapper) {
        this.packageRepository = packageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PackageDTO createPackage(PackageDTO packageDTO) {
        Package packageEntity = modelMapper.map(packageDTO, Package.class);
        Package createdPackage = packageRepository.save(packageEntity);
        return modelMapper.map(createdPackage, PackageDTO.class);
    }

    @Override
    public PackageDTO getPackageById(Long packageId) {
        Package packageEntity = packageRepository.findById(packageId)
                .orElseThrow(() -> new NotFoundException("Package not found"));
        return modelMapper.map(packageEntity, PackageDTO.class);
    }

    @Override
    public List<PackageDTO> getAllPackages() {
        List<Package> packages = packageRepository.findAll();
        return packages.stream()
                .map(packageEntity -> modelMapper.map(packageEntity, PackageDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PackageDTO updatePackage(Long packageId, PackageDTO packageDTO) {
        Package packageEntity = packageRepository.findById(packageId)
                .orElseThrow(() -> new NotFoundException("Package not found"));
        modelMapper.map(packageDTO, packageEntity);
        Package updatedPackage = packageRepository.save(packageEntity);
        return modelMapper.map(updatedPackage, PackageDTO.class);
    }

    @Override
    public void deletePackage(Long packageId) {
        Package packageEntity = packageRepository.findById(packageId)
                        .orElseThrow(() -> new NotFoundException("Package not found exception with id:  "+ packageId));
        packageRepository.delete(packageEntity);
    }
}
