package com.livedoor.flow_manager.jms.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate102;
import org.springframework.jms.core.MessageCreator;

public class JmsTopicPublisher {
	Logger log = Logger.getLogger(JmsTopicPublisher.class);
	private JmsTemplate102 jmsTopicTemplate;

	public JmsTemplate102 getJmsTopicTemplate() {
		return jmsTopicTemplate;
	}

	public void setJmsTopicTemplate(JmsTemplate102 jmsTopicTemplate) {
		this.jmsTopicTemplate = jmsTopicTemplate;
	}

	public void sendMesage(final String msg) {
		System.err.println("topic sending...");
		jmsTopicTemplate.send(
		//				   "queue/XxlbqTestQueue", 
				new MessageCreator() {
					public Message createMessage(Session session)
							throws JmsException, JMSException {
						return session.createTextMessage(msg);
					}
				});

	}

	public static void main(String[] args) {
		XmlBeanFactory f = new XmlBeanFactory(new FileSystemResource(
				"E:/java/EclipseWorkSpace20060721/permission/"+
				"webroot/WEB-INF/conf/spring/applicationContext-permission-jms.xml"));
//		JmsTopicPublisher sender = (JmsTopicPublisher) f.getBean("msgPublisher");
		JmsTopicPublisher sender = (JmsTopicPublisher) f.getBean("msgProducer");
		
		if(sender == null)
				System.out.println("Error :sender is null.");
		
		System.out.println(sender.getJmsTopicTemplate().isPubSubDomain());
		
//		sender.getJmsTopicTemplate().setDefaultDestinationName("topic/postUserTopic");
		int index=0;
		
//		while(true){
			index++;
			sender.sendMesage("topic test it "+ index);
			
//			try {
////				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}
}
