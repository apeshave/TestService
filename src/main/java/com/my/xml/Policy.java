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
 public class Policy {
    
    @Element
    public String name;
    
    @ElementList(entry = "role")
    public List<String> roles = new ArrayList<String>();
    
    @ElementList(entry = "permission")
    public List<String> permissions = new ArrayList<String>();
    
    
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public List<String> getRoles() {
		return roles;
	}




	public void setRoles(List<String> roles) {
		this.roles = roles;
	}




	public List<String> getPermissions() {
		return permissions;
	}




	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}




	@Override
    public String toString() {
        return "Policy{" + "name=" + name + ", roles=" + roles + ", permissions=" + permissions + '}';
    }
    
    
    
    
}
