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


/**
 *
 * @author Aditya
 */
@Element
public class Permissions {
    
	@ElementList(entry = "permission")
    List<String> permissions = new ArrayList<String>();

	
	
    public List<String> getPermissions() {
		return permissions;
	}



	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}



	@Override
    public String toString() {
        return "Permissions{" + "permissions=" + permissions + '}';
    }
}
