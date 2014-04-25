package com.my.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.my.RBAC.Permission;
import com.my.RBAC.Policy;
import com.my.RBAC.RBAC;
import com.my.RBAC.Role;
import com.my.RBAC.User;
import com.tazdingo.core.Request;
import com.tazdingo.core.Response;
import com.tazdingo.core.ServiceWorkRequest;
import com.tazdingo.core.WorkRequest;
import com.tazdingo.core.util.ConstantUtil;

import edu.neu.coe.platform.serviceserver.ServiceServer;

/**
 * @author Aditya
 *
 */
public class MyService extends ServiceServer implements RBAC {

	
	/**
	 * This method initialized the policies specified to 
	 * the service 
	 */
	public void init() {
		// Uncomment it after creation of the DAO pattern.
		// policies = policyDAO.getAllPolicies();
	}

	public MyService(String servicename, String password, String adminpassword,
			String defaultplatformurl) {
		super(servicename, password, adminpassword, defaultplatformurl);
		init();
	}

	@Override
	protected Response processRequest(WorkRequest request) {
		Response response = new Response();
		String operation = request.getRequest().getData()
				.get(ConstantUtil.OPERATION);
		String privilage = new String("1");
		if (checkprivilege(privilage, operation))
			response.getData().put(ConstantUtil.MESSAGE,
					ConstantUtil.DEFAULT_MESSAGE);
		else
			response.getData().put(ConstantUtil.MESSAGE, ConstantUtil.ERROR);

		return response;
	}

	@Override
	protected Response excuteRequest(String usersessionid) {

		ServiceWorkRequest serviceWorkRequest = (ServiceWorkRequest) workqueue
				.pullWorkRequest(usersessionid);
		Request userRequest = serviceWorkRequest.getRequest();
		Map<String, String> data = userRequest.getData();
		String username = data.get(ConstantUtil.USERNAME);
		String deviceId = data.get(ConstantUtil.DEVICEID);

		// At this point we will fetch the user from the database
		// We will also fetch all the roles, permissions and policies.
		// We will then check the policies with the role and permission given to
		// the
		// user.
		// User user = userDAO.getUserByUsername(username);
		 
		User user = new User();

		Response response = null;
		if (username != null && deviceId != null) {
			response = new Response();
			response.setData(data);
		}

		return response;
	}

	@Override
	protected boolean checkprivilege(String privilege, String operation) {
		return super.checkprivilege(privilege, operation);
	}

	@Override
	public boolean checkPolicy(User user) {

		List<Policy> relevantPolicies = getPoliciesWithCriteria(
				user.getRoles(), user.getPermissions());

		if (null != relevantPolicies)
			return true;
		else
			return false;
	}

	/**
	 * This method gets the matching policies with the roles and 
	 * permissions specified to the user
	 * 
	 * @param roles - roles assigned to user
	 * @param permissions - Permissions assigned to user
	 * @return null or policies matching the criteria
	 */
	public List<Policy> getPoliciesWithCriteria(List<Role> roles,
			List<Permission> permissions) {
		
		List<Policy> satisfyingPolicies = new ArrayList<Policy>();
		if (null != policies)
			for (Policy policy : policies) {
				for (Role role : roles)
					if (policy.getRoles().contains(role))
						satisfyingPolicies.add(policy);
			}

		List<Policy> finalPolicies = new ArrayList<Policy>();
		for (Policy policy : satisfyingPolicies) {
			for (Permission permission : permissions)
				if (policy.getPermissions().contains(permission))
					finalPolicies.add(policy);
		}

		if (finalPolicies.size() != 0)
			return finalPolicies;
		else
			return null;
	}

}
