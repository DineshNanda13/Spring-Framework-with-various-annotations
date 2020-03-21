package com.samsung;

import org.springframework.stereotype.Component;

@Component
public class BadDataPlan implements DataPlan {

	@Override
	public String getDataPlan() {
		return "4 Gb for 1 month at 45$";
	}

}
