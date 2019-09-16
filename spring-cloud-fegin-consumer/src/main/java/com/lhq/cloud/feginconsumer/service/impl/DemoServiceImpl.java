package com.lhq.cloud.feginconsumer.service.impl;

<<<<<<< HEAD
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
=======
import com.lhq.cloud.feginconsumer.service.DemoService;
import com.lhq.cloud.service.provider.client.DemoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoInterface demoInterface;

    @Override
    public String feginTest() {
        return demoInterface.getServerPort();

    }
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3

}
