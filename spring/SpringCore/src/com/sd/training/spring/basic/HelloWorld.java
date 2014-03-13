package com.sd.training.spring.basic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * URL for download Jars
	http://mvnrepository.com/artifact/org.springframework
*/
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringContext.xml");
 
		Greating greating = (Greating) context.getBean("greating");
		System.out.println(greating.getSayHello());

	}

}

 
