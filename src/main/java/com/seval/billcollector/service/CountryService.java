/**
 * 
 */
package com.seval.billcollector.service;


import com.seval.billcollector.model.Country;

/**
 * @author rajviji
 *
 */
public interface CountryService {

	public Country findCountryByCode(String countryCode);
	
}
