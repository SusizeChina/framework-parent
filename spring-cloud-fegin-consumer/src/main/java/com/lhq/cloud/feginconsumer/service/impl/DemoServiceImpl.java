package com.lhq.cloud.feginconsumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhq.cloud.feginconsumer.service.DemoService;
import com.lhq.cloud.service.provider.client.DemoInterface;

@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	DemoInterface demoInterface;

	@Override
	public String feginTest() {
		return demoInterface.getServerPort();

	}

}
