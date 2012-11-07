package uk.co.certait.jms.test;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsProducer
{
	private JmsTemplate jmsTemplate;
	private Queue queue;

	public void simpleSend(final int count)
	{
		this.jmsTemplate.send(this.queue, new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				return session.createTextMessage(Integer.toString(count));
			}
		});
	}
	
	public void setConnectionFactory(ConnectionFactory cf)
	{
		this.jmsTemplate = new JmsTemplate(cf);
	}

	public void setQueue(Queue queue)
	{
		this.queue = queue;
	}
}
