/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.xml;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author Aditya
 */
@Root(strict = false)
public class Userlist {
 
	public Userlist() {
	}

	@ElementList(inline = true)
    //@ElementList(entry = "user", type = Userlist.class)
    List<User> userlist = new ArrayList<User>();
	

    public List<User> getUserlist() {
		return userlist;
	}




	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}




	@Override
    public String toString() {
        return "Userlist{" + "roles=" + userlist + '}';
    }
    
}
