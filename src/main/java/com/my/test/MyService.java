package com.my.test;

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

public class MyService extends ServiceServer implements RBAC {

	public MyService(String servicename, String password, String adminpassword,
			String defaultplatformurl) {
		super(servicename, password, adminpassword, defaultplatformurl);
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
		Request userRequest =  serviceWorkRequest.getRequest();
		Map<String, String> data =  userRequest.getData();
		String username = data.get(ConstantUtil.USERNAME);
		String deviceId = data.get(ConstantUtil.DEVICEID);
		
		//At this point we will fetch the user from the database
		//We will also fetch all the roles, permissions and policies.
		//We will then check the policies with the role and permission given to the
		//user.
		
		User user = new User();
		
		Response response = null;
		if(username != null && deviceId != null){
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
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void addRoleToUser(User user, Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPermission(User user, Permission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPolicy(Policy policy) {
		// TODO Auto-generated method stub
		
	}
}
