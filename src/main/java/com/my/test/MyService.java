package com.my.test;

import java.util.Map;

import com.tazdingo.core.Request;
import com.tazdingo.core.Response;
import com.tazdingo.core.ServiceWorkRequest;
import com.tazdingo.core.WorkRequest;
import com.tazdingo.core.util.ConstantUtil;

import edu.neu.coe.platform.serviceserver.ServiceServer;

public class MyService extends ServiceServer {

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
}
