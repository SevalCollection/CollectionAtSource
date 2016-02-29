/**
 * 
 */
package com.seval.billcollector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.State;
import com.seval.billcollector.repository.StateRepository;

/**
 * @author rajviji
 *
 */
@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;

	@Override
	public State findStateByCode(String stateCode) {
		return stateRepository.findStateByCode(stateCode);
	}
	

}
