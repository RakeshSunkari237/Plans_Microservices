package com.plans.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.plans.dto.PlansDTO;
import com.plans.service.IPlanService;

@RestController
@CrossOrigin("*")
public class PlansController {

	@Autowired
	private IPlanService service;
	
	@GetMapping("/planIds")
	public List<String> getAllPlanIds(){
		return service.getAllPlanIds();
	}
	
	@GetMapping("/plans")
	public ResponseEntity<?> getAllPlans(){
	try {
		List<PlansDTO> plans = service.getAllPlans();
		return new ResponseEntity<List<PlansDTO>>(plans,HttpStatus.OK);
	
	}catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Some thing wrong please check once ",HttpStatus.INTERNAL_SERVER_ERROR);
		 
		}
	}
	
	
	@GetMapping("plans/{planId}")
	public ResponseEntity<?> getOnePlan(@PathVariable String planId){
		try {
		boolean flag = service.isPlanExist(planId);
		if(flag) {
			PlansDTO planDto = service.getOnePlan(planId);
			return new ResponseEntity<PlansDTO>(planDto,HttpStatus.OK); 
		}else {
			return new ResponseEntity<String>("Plans is not exist", HttpStatus.BAD_REQUEST);
		}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("some thing wrong please try agian", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
}
