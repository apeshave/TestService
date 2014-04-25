package com.my.test;

import edu.neu.coe.platform.serviceserver.AbstractServiceConfig;
import edu.neu.coe.platform.serviceserver.ServiceServer;

public class MyServiceConfig extends AbstractServiceConfig {

	public MyServiceConfig() {
	}

	@Override
	protected ServiceServer newServiceServer(String servicename,
			String password, String adminpassword, String platformurl) {
		try {
			return new MyService(servicename, password, adminpassword, platformurl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
