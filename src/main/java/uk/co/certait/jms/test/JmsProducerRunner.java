package uk.co.certait.jms.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsProducerRunner
{
	public static void main (String [] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JmsProducer producer = context.getBean(JmsProducer.class);
		int count  = 1;
		
		while(true){
			try{
				producer.simpleSend(count);
				++ count;
				
				Thread.sleep(4000);
			}
			catch(InterruptedException ex){
			};
		}
	}
}
