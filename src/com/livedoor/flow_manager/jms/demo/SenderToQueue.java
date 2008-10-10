package com.livedoor.flow_manager.jms.demo;


import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.log4j.Logger;





/**
 * The SenderToQueue class consists only of a main method, which sends 
 * several messages to a queue.
 * <p>
 * Run this program in conjunction with either SynchQueueReceiver or 
 * AsynchQueueReceiver.  Specify a queue name on the command line when you run 
 * the program.  By default, the program sends one message.  Specify a number 
 * after the queue name to send that number of messages.
 *
 */
public class SenderToQueue {

	private static final Logger log = Logger.getLogger(SenderToQueue.class);
	
    /**
     * Main method.
     *
     * @param args	the queue used by the example and, optionally, the
     *                   number of messages to send
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        String                  queueName = null;
        QueueConnectionFactory  queueConnectionFactory = null;
        QueueConnection         queueConnection = null;
        QueueSession            queueSession = null;
        Queue                   queue = null;
        QueueSender             queueSender = null;
        ObjectMessage           message = null;

        int                     exitResult = 0;

    	
//        queueName="queue/DealRequestQueue";
        queueName="queue/XxlbqTestQueue";
        
        System.out.println("Queue name is " + queueName);

    	    
        try {
        	
            queueConnectionFactory 	= SampleUtilities.getQueueConnectionFactory();
            queueConnection 		= queueConnectionFactory.createQueueConnection();
            queueSession 			= queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            queue 					= SampleUtilities.getQueue(queueName, queueSession);
            
    	} catch (Exception e) {
    		
            log.error("Connection problem: " + e.toString());
            if (queueConnection != null) {
                try {
                    queueConnection.close();
                } catch (JMSException ee) {} 
            }
    	    System.exit(1);
    	} 

        /*
         * Create sender.
         * Create text message.
         * Send five messages, varying text slightly.
         * Send end-of-messages message.
         * Finally, close connection.
         */
        try {
        	
            queueSender = queueSession.createSender(queue);
            XxMessage xm = null;
            int number=0;
//            for (int i = 0; i < 100; i++) {
            while(true){

                number++;
                
                xm = new XxMessage();
                xm.setName("007");
                xm.setAge(number);
                
                message = queueSession.createObjectMessage(xm);
                queueSender.send(message);
                
                log.info(" has send "+number+"message " +
                		"[ name:"+((XxMessage)message.getObject()).getName()+"," +
                		"age:"+((XxMessage)message.getObject()).getAge()+"] ");
                
                Thread.sleep(1000*3);
                
            }

//           Send a non-text control message indicating end of messages.
//           queueSender.send(queueSession.createMessage());
            
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());
            exitResult = 1;
        } finally {
            if (queueConnection != null) {
                try {
                    queueConnection.close();
                } catch (JMSException e) {
                    exitResult = 1;
                }
            }
        }
        
    	SampleUtilities.exit(exitResult);
    }
    

}
