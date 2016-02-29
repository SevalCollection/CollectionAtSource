/**
 * 
 */
package com.seval.billcollector.service;


import com.seval.billcollector.model.State;

/**
 * @author rajviji
 *
 */
public interface StateService {

	public State findStateByCode(String stateCode);
}
