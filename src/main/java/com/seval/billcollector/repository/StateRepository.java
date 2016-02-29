package com.seval.billcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.State;


@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	
	@Query("select stat from State stat where stat.code = ?1")
    public State findStateByCode(String stateCode);
}