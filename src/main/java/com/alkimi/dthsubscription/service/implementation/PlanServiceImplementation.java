package com.alkimi.dthsubscription.service.implementation;

import com.alkimi.dthsubscription.entity.Plan;
import com.alkimi.dthsubscription.exception.NotFoundException;
import com.alkimi.dthsubscription.payload.PlanDTO;
import com.alkimi.dthsubscription.repository.PlanRepository;
import com.alkimi.dthsubscription.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanServiceImplementation implements PlanService {

    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    public PlanServiceImplementation(PlanRepository planRepository, ModelMapper modelMapper) {
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PlanDTO createPlan(PlanDTO planDTO) {
        Plan planEntity = modelMapper.map(planDTO, Plan.class);
        Plan createdPlan = planRepository.save(planEntity);
        return modelMapper.map(createdPlan, PlanDTO.class);
    }

    @Override
    public PlanDTO getPlanById(Long planId) {
        Plan planEntity = planRepository.findById(planId)
                .orElseThrow(() -> new NotFoundException("Plan not found"));
        return modelMapper.map(planEntity, PlanDTO.class);
    }

    @Override
    public List<PlanDTO> getAllPlans() {
        List<Plan> plans = planRepository.findAll();
        return plans.stream()
                .map(plan -> modelMapper.map(plan, PlanDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlan(Long planId) {
        Plan planEntity = planRepository.findById(planId)
                        .orElseThrow(() -> new NotFoundException("plan not found with id: " + planId));
        planRepository.delete(planEntity);
    }

    @Override
    public PlanDTO updatePlan(Long planId, PlanDTO planDTO) {
        Plan planEntity = planRepository.findById(planId)
                .orElseThrow(() -> new NotFoundException("Plan not found"));
        modelMapper.map(planDTO, planEntity);
        Plan updatedPlan = planRepository.save(planEntity);
        return modelMapper.map(updatedPlan, PlanDTO.class);
    }
}
