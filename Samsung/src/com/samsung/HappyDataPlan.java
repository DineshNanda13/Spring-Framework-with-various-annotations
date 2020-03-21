package com.samsung;

import org.springframework.stereotype.Component;

@Component
public class HappyDataPlan implements DataPlan {

	@Override
	public String getDataPlan() {
		return "8 Gb for 1 month at 45$";
	}

}
