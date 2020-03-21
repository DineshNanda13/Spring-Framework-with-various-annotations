package com.samsung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class S1 implements Mobile {
	
	private DataPlan dataPlan;
	
	@Autowired
	public S1(@Qualifier("badDataPlan") DataPlan dataPlan) {
		super();
		this.dataPlan = dataPlan;
	}

	@Override
	public String getVersion() {
		return "The version is S1";
	}

	@Override
	public String getDailyDataPlan() {
		System.out.println("Bad data plan");
		return "By Constructor Injection, data plan is: "+dataPlan.getDataPlan();
	}

}
