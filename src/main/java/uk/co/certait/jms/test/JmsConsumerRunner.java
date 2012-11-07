package uk.co.certait.jms.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsConsumerRunner
{
	public static void main (String [] args)
	{
		new ClassPathXmlApplicationContext("applicationContext.xml");
		
		while(true){
			try{
				Thread.sleep(10000);
			}
			catch(InterruptedException ex){
			};
		}
	}
}
