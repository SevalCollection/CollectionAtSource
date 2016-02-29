/**
 * 
 */
package com.seval.billcollector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.Country;
import com.seval.billcollector.repository.CountryRepository;

/**
 * @author rajviji
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Country findCountryByCode(String countryCode) {
		return countryRepository.findCountryByCode(countryCode);
	}

}
