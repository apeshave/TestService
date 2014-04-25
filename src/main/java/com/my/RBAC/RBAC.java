/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.my.RBAC;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Aditya
 */
public interface RBAC {

	static List<Policy> policies = new ArrayList<Policy>();

	/**
	 * This method takes the user as input and checks the roles and permissions
	 * associated with it and matches it with the available policies.
	 * 
	 * @param user - the user object to be checked
	 * @return whether he is authorized or not
	 */
	public abstract boolean checkPolicy(User user);
}
