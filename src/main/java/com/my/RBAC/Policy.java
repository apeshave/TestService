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
    private List<Role> roles;
    private List<Permission> permissions;

    public Policy(String name) {
        roles = new ArrayList<Role>();
        permissions = new ArrayList<Permission>();
        this.name = name;
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
