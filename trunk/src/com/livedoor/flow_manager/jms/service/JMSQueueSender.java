package com.livedoor.flow_manager.jms.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate102;
import org.springframework.jms.core.MessageCreator;

public class JMSQueueSender {

	private JmsTemplate102 jmsQueueTemplate;

	public JmsTemplate102 getJmsQueueTemplate() {
		return jmsQueueTemplate;
	}

	public void setJmsQueueTemplate(JmsTemplate102 jmsQueueTemplate) {
		this.jmsQueueTemplate = jmsQueueTemplate;
	}

	public void sendMesage(final String msg) {
		System.out.println("sending msg ...");
		jmsQueueTemplate.send(
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
				"E:/java/EclipseWorkSpace20080831-xPlugin/mylunch/webroot/WEB-INF/conf/spring/applicationContext-permission-jms.xml"));
		JMSQueueSender sender = (JMSQueueSender) f.getBean("jmsSender");
		sender.sendMesage("queue test it ");
	}
}
