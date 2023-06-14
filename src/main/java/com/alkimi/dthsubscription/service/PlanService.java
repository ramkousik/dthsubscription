package com.alkimi.dthsubscription.service;

import com.alkimi.dthsubscription.entity.Plan;
import com.alkimi.dthsubscription.payload.PlanDTO;

import java.util.List;

public interface PlanService {
    PlanDTO createPlan(PlanDTO planDTO);
    void deletePlan(Long planId);
    PlanDTO updatePlan(Long planId, PlanDTO planDTO);

    PlanDTO getPlanById(Long planId);

    List<PlanDTO> getAllPlans();


}
