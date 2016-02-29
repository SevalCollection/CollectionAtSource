package com.seval.billcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	
	@Query("select r from Role r where r.role =?1")
	public Role findByRole(@Param("role") String role);

}