package com.livedoor.flow_manager.jms.service;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jms.core.JmsTemplate102;

public class JMSQueueReceiver {

	private JmsTemplate102 jmsQueueTemplate;


	public void setJmsQueueTemplate(JmsTemplate102 jmsQueueTemplate) {
		this.jmsQueueTemplate = jmsQueueTemplate;
	}
	
	 public Message receive(){
	      Message msg = jmsQueueTemplate.receive(
//	    		  "queue/XxlbqTestQueue"
	    		  );
	      try{

	        TextMessage textMessage = (TextMessage) msg;
	        if( msg!=null){
	        	System.out.println(" Message Received -->" + textMessage.getText());
	        }else{
	        	System.out.println(" msg is null !~");
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
			JMSQueueReceiver receiver = (JMSQueueReceiver)f.getBean("jmsReceiver");
	    	while(true){
	    	receiver.receive();
	    	Thread.sleep(1000);
	    	}
		}

}
