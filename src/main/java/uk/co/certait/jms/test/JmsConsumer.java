package uk.co.certait.jms.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageFormatException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class JmsConsumer implements SessionAwareMessageListener
{
	private static final DateFormat df = new SimpleDateFormat("HH:mm:ss");
	
	public void onMessage(Message message, Session session) throws JMSException
	{
		System.out.println("Incoming message: " + df.format(new Date()));
		TextMessage tm = (TextMessage)message;
		
		try
		{
			int i = Integer.parseInt(tm.getText());
			
			System.out.println("Hey, I Got a message: " + i);
			
			if(i % 3 == 0)
			{
				throw new MessageFormatException("Error processing message!");
			}
		}
		catch (Exception e)
		{
			throw new MessageFormatException("Not Numeric");
		}
	}
}
