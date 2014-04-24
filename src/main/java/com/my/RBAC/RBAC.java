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
public abstract class RBAC {
    
    protected static List<Policy> policies = new ArrayList<Policy>();
    
    public abstract boolean checkPolicy(User user);
    public abstract void addRoleToUser(User user, Role role);
    public abstract void addPermission(User user, Permission permission);
    public abstract void addPolicy(Policy policy);
}
