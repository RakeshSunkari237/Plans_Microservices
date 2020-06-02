package com.plans.service;

import java.util.List;

import com.plans.dto.PlansDTO;

public interface IPlanService {

	public List<PlansDTO> getAllPlans();
	public PlansDTO getOnePlan(String planId);
	public boolean isPlanExist(String planId);
	public List<String> getAllPlanIds();
	
}
