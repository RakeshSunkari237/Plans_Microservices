package com.plans.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plans.dto.PlansDTO;
import com.plans.entity.Plans;
import com.plans.repository.PlansRepository;
import com.plans.service.IPlanService;

@Service
public class PlansServiceImpl implements IPlanService {

	@Autowired
	private PlansRepository repository;
	
	public List<PlansDTO> getAllPlans() {
		List<PlansDTO> plansDto=new ArrayList<PlansDTO>();
		List<Plans> plans = repository.findAll();
		plans.forEach( plan -> {
			PlansDTO pdto=new PlansDTO();
			BeanUtils.copyProperties(plan, pdto);
			plansDto.add(pdto);
		});
		return plansDto;
	}

	public PlansDTO getOnePlan(String planId) {
		Optional<Plans> optional = repository.findById(planId);
		Plans plan = optional.get();
		PlansDTO pdto=new PlansDTO();
		BeanUtils.copyProperties(plan, pdto);
		return pdto;
	}

	@Override
	public boolean isPlanExist(String planId) {

		return repository.existsById(planId);
	}

	@Override
	public List<String> getAllPlanIds() {
		return repository.getAllPlanIds();
	}

}
