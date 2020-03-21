# Spring-Framework-with-various-annotations
Annotations like @Component, @Autowired, @Qualifier, @Value are used

// File name : applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">
    
    <context:property-placeholder location="classpath:info"/>
    
	<!-- add entry to enable component scanning -->

	<context:component-scan
		base-package="com.samsung" />

</beans>

// File name : info

foo.name = "Dinesh"
foo.email = "Dinesh76@gmail.com"

// File name : Mobile.java

package com.samsung;

public interface Mobile {
	
	public String getVersion();
	
	public String getDailyDataPlan();

}

// File name : S1.java

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

// File name : S2.java

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

// File name : S3.java

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

// File name : S4.java

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

// File name : DataPlan.java

package com.samsung;

public interface DataPlan {
	
	public String getDataPlan();

}

// File name : HappyDataPlan.java

package com.samsung;

import org.springframework.stereotype.Component;

@Component
public class HappyDataPlan implements DataPlan {

	@Override
	public String getDataPlan() {
		return "8 Gb for 1 month at 45$";
	}

}

// File name : BadDataPlan.java

package com.samsung;

import org.springframework.stereotype.Component;

@Component
public class BadDataPlan implements DataPlan {

	@Override
	public String getDataPlan() {
		return "4 Gb for 1 month at 45$";
	}

}

// File name : Samsung.java

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
