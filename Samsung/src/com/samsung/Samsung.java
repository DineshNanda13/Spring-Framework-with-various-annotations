package com.samsung;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Samsung {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Mobile theMobile = context.getBean("s4", Mobile.class);
		
		System.out.println(theMobile.getVersion());
		
		System.out.println(theMobile.getDailyDataPlan());
		
		//System.out.println(theMobile.getName());
		//System.out.println(theMobile.getEmail());
		
		context.close();
	}

}
