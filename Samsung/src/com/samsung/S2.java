package com.samsung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class S2 implements Mobile {
	
	private DataPlan dataPlan;
	
	@Autowired
	public void setDataPlan(@Qualifier("happyDataPlan") DataPlan dataPlan) {
		this.dataPlan = dataPlan;
	}

	@Override
	public String getVersion() {
		return "The version is S2";
	}

	@Override
	public String getDailyDataPlan() {
		System.out.println("Happy data plan");
		return "By Setter Injection, data plan is: "+dataPlan.getDataPlan();
	}

}
