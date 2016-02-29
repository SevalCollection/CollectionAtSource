package com.seval.billcollector.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Role;

@Repository
public interface UserRolesRepository extends CrudRepository<Role, Long> {
	
	@Query("select a.role from Role a, User b where b.username=?1 and a.user.userid=b.userid and b.enabled=1")
    public List<String> findRoleByUserName(String username);
	
}