package com.seval.billcollector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where  u.organization.organizationid=?1")
  	public List<User> findAllUsersByOrganization(@Param("organizationid") Long organizationid);
	
	@Query("select u from User u where u.username =?1")
	public User findByUsername(@Param("username") String username);

}