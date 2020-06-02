package com.plans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plans.entity.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, String> {
	
	@Query(value = " select paln_id from plans", nativeQuery = true)
	public List<String> getAllPlanIds();

}
