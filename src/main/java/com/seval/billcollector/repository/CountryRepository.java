package com.seval.billcollector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seval.billcollector.model.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
	
	@Query("select ctry from Country ctry where ctry.code = ?1")
    public Country findCountryByCode(String countryCode);
}