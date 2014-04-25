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
public class User {
	 @Element
    //@Element(name = "username", type = String.class)
    public String username;
    
	 @Element
    //@Element(name = "deviceid", type = String.class)
    public String deviceid;
    
	 
//	 @Element
//	 public Roles roles = new Roles();
//	 
//	 @Element(name = "permissions")
//	 public Permissions permissions;
	 
//	 @ElementList(entry = "role", type = Role.class)
//	 
	 //@ElementList(inline = true)
	 @ElementList(entry = "role")
     List<String> roles = new ArrayList<String>();
    
	 //@ElementList(inline = true)
    @ElementList(entry = "permission")
    List<String> permissions = new ArrayList<String>();
	 
	 
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
        return "User{" + "username=" + username + ", deviceid=" + deviceid + ", roles=" + roles + ", permissions=" + permissions + '}';
    }

//	public Roles getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Roles roles) {
//		this.roles = roles;
//	}
//
//	public Permissions getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(Permissions permissions) {
//		this.permissions = permissions;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

//	public Roles getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Roles roles) {
//		this.roles = roles;
//	}
//
//	public Permissions getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(Permissions permissions) {
//		this.permissions = permissions;
//	}
    
    
    
}
