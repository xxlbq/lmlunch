package com.livedoor.flow_manager.jms.service;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jms.core.JmsTemplate102;

public class JmsTopicConsumer {
	private static Logger log = Logger.getLogger(JmsTopicPublisher.class);
	private JmsTemplate102 jmsTopicTemplate;
	private static int receviceMsg=0;
	
	public JmsTemplate102 getJmsTopicTemplate() {
		return jmsTopicTemplate;
	}

	public void setJmsTopicTemplate(JmsTemplate102 jmsTopicTemplate) {
		this.jmsTopicTemplate = jmsTopicTemplate;
	}
	
	
	
	 public Message receive(){

	      Message msg = jmsTopicTemplate.receive(
//	    		  "queue/XxlbqTestQueue"
	    		  );
	      try{

	        TextMessage textMessage = (TextMessage) msg;
	        if( msg!=null){
	        	log.info(" Message Received -->" + textMessage.getText());
	        }
	        else{
	        	log.info("this time get null");
	        }

	      }catch(Exception e){
	            e.printStackTrace();
	      }

	      	return msg;
	    }
	 
	    public static void main(String[] args) throws InterruptedException {
	    	XmlBeanFactory f = new XmlBeanFactory(new FileSystemResource(
					"E:/java/EclipseWorkSpace20060721/permission/"+
					"webroot/WEB-INF/conf/spring/applicationContext-permission-jms.xml"));
	    	JmsTopicConsumer receiver1 = (JmsTopicConsumer)f.getBean("msgConsumer");
//	    	JmsTopicConsumer receiver1 = (JmsTopicConsumer)f.getBean("msgConsumer");
	    	JmsTopicConsumer receiver2 = (JmsTopicConsumer)f.getBean("msgConsumer");
	    	JmsTopicConsumer receiver3 = (JmsTopicConsumer)f.getBean("msgConsumer");
	    	
	    	
//	    	while(true){
	    		log.info("receiver 1 ");
	    		receiver1.receive();
//	    		log.info("receiver 2 ");
//	    		receiver2.receive();
//	    		log.info("receiver 3 ");
//	    		receiver3.receive();
//	    		Thread.sleep(3000);
//	    	}
		}

}
