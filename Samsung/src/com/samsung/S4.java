package com.samsung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class S4 implements Mobile {
	
	private DataPlan dataPlan;
	
	@Value ("${foo.name}")
	private String name;
	
	@Value ("${foo.email}")
	private String email;
	
	@Autowired
	public void MyCustomData(@Qualifier("happyDataPlan") DataPlan dataPlan) {
		this.dataPlan = dataPlan;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}



	@Override
	public String getVersion() {
		return "The version is S4";
	}

	@Override
	public String getDailyDataPlan() {
		System.out.println("Happy data plan");
		return "By Method Injection, data plan is: "+dataPlan.getDataPlan();
	}

}
