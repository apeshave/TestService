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
 public class Policy
{
    private String name;
    private List<Role> roles = new ArrayList<Role>();
    private List<Permission> permissions = new ArrayList<Permission>();

    public Policy()
    {
    	
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public void addRole(Role role)
    {
        roles.add(role);
    }

    public void addPermission(Permission permission)
    {
        permissions.add(permission);
    }
}
