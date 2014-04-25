/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author Aditya
 */
@Element
public class Policies {
    
	@ElementList(inline = true)
    public List<Policy> policies = new ArrayList<Policy>();

	
	
    public List<Policy> getPolicies() {
		return policies;
	}



	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}



	@Override
    public String toString() {
        return "Policies{" + "policies=" + policies + '}';
    }
    
    
    
}
