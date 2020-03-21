package com.samsung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class S3 implements Mobile {
	
	@Autowired
	@Qualifier ("badDataPlan")
	private DataPlan dataPlan;

	@Override
	public String getVersion() {
		return "The version is S3";
	}

	@Override
	public String getDailyDataPlan() {
		System.out.println("Bad data plan");
		return "By Field Injection, data plan is: "+dataPlan.getDataPlan();
	}

}
