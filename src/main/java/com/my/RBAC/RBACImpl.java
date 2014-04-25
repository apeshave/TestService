package com.my.RBAC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.my.xml.Permissions;
import com.my.xml.Policies;
import com.my.xml.Policy;
import com.my.xml.RoleList;
import com.my.xml.Userlist;

public class RBACImpl implements RBAC {

	public final String POLICIES = "../conf/policies.xml";
	public final String ROLES = "../conf/roleList.xml";
	public final String USERS = "../conf/userList.xml";
	public final String PERMISSIONS = "../conf/permissions.xml";

	public RBACImpl() throws Exception {
		setRoles();
		setPermissions();
		setPolicies();
		setUsers();
	}

	public void setPolicies() throws Exception {

		Serializer serializer = new Persister();
		File policyFile = new File(POLICIES);
		Policies policyList = serializer.read(Policies.class, policyFile);

		for (Policy p : policyList.policies) {
			com.my.RBAC.Policy policy = new com.my.RBAC.Policy();
			policy.setName(p.name);

			for (String s : p.permissions)
				policy.addPermission(new Permission(s));

			for (String s : p.roles)
				policy.addRole(new Role(s));

			policies.add(policy);
		}

	}

	public void setRoles() throws Exception {
		Serializer serializer = new Persister();
		File roleFile = new File(ROLES);
		RoleList rolelist = serializer.read(RoleList.class, roleFile);

		for (String s : rolelist.getRoles())
			roles.add(new Role(s));
	}

	public void setPermissions() throws Exception {
		Serializer serializer = new Persister();
		File permissionFile = new File(PERMISSIONS);
		Permissions permissionList = serializer.read(Permissions.class,
				permissionFile);

		for (String s : permissionList.getPermissions())
			permissions.add(new Permission(s));
	}

	public void setUsers() throws Exception {
		Serializer serializer = new Persister();
		File userFile = new File(USERS);
		Userlist userlist = serializer.read(Userlist.class, userFile);

		for (com.my.xml.User u : userlist.getUserlist()) {
			User user = new User();
			user.setDeviceID(u.deviceid);
			user.setUsername(u.username);

			for (String s : u.getPermissions()) {
				Permission p = new Permission(s);
				permissions.add(p);
			}

			for (String s : u.getRoles()) {
				Role role = new Role(s);
				roles.add(role);
			}
			users.add(user);
		}
	}

	@Override
	public boolean checkPolicy(User user) {

		List<com.my.RBAC.Policy> relevantPolicies = getPoliciesWithCriteria(
				user.getRoles(), user.getPermissions());

		if (null != relevantPolicies)
			return true;
		else
			return false;
	}

	/**
	 * This method gets the matching policies with the roles and permissions
	 * specified to the user
	 * 
	 * @param roles
	 *            - roles assigned to user
	 * @param permissions
	 *            - Permissions assigned to user
	 * @return null or policies matching the criteria
	 */
	public List<com.my.RBAC.Policy> getPoliciesWithCriteria(List<Role> roles,
			List<Permission> permissions) {

		List<com.my.RBAC.Policy> satisfyingPolicies = new ArrayList<com.my.RBAC.Policy>();
		if (null != policies)
			for (com.my.RBAC.Policy policy : policies) {
				for (Role role : roles)
					if (policy.getRoles().contains(role))
						satisfyingPolicies.add(policy);
			}

		List<com.my.RBAC.Policy> finalPolicies = new ArrayList<com.my.RBAC.Policy>();
		for (com.my.RBAC.Policy policy : satisfyingPolicies) {
			for (Permission permission : permissions)
				if (policy.getPermissions().contains(permission))
					finalPolicies.add(policy);
		}

		if (finalPolicies.size() != 0)
			return finalPolicies;
		else
			return null;
	}
	
	public User getUserByUsername(String username)
	{
		for(User user: users)
		{
			if(user.getUsername().equals(username))
				return user;
		}
		
		return null;
	}
	
	public com.my.RBAC.Policy getPolicyByName(String name) {
		
		for(com.my.RBAC.Policy policy : policies)
			if(policy.getName().equals(name))
				return policy;
		
		return null;
		
	}

}
