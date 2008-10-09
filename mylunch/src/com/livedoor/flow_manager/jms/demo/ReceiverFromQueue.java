package com.livedoor.flow_manager.jms.demo;

/*
 * @(#)AsynchQueueReceiver.java	1.6 00/08/14
 * 
 * Copyright (c) 2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.log4j.Logger;



/**
 * The AsynchQueueReceiver class consists only of a main method, which fetches 
 * one or more messages from a queue using asynchronous message delivery.
 * <p>
 * Compile TextListener.java before you run this program.
 * <p>
 * Run this program in conjunction with SenderToQueue.  Specify a queue name
 * on the command line when you run the program.
 *
 * @author Kim Haase
 * @version 1.6, 08/14/00
 */
public class ReceiverFromQueue {
	
	private static final Logger log = Logger.getLogger(ReceiverFromQueue.class);
	private static boolean isShutDown =false;
	private static int receviceMsg=0;
	
    class MyListener implements MessageListener{

		public void onMessage(Message msg) {
			log.info("&&& on message : &&&&&&&&&&&&&&&&&&&&&&");
			onMsg1(msg);
//			onMsg2(msg);
		}	
    	
    	public void onMsg1(Message msg){
    		System.out.println("onMsg1()-->");
			ObjectMessage objmsg = (ObjectMessage)msg;
			XxMessage recXm = new XxMessage();
			try {
				receviceMsg++;
				recXm =(XxMessage) objmsg.getObject();
				
				log.info("========== msg no :["+receviceMsg+"]=============");
				log.info("recevieMsg: name="+recXm.getName());
				log.info("recevieMsg: age="+recXm.getAge());
				log.info("=================================================");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	public void onMsg2(Message msg){
//    		System.out.println("test onMessage()");
			ObjectMessage objmsg = (ObjectMessage)msg;
//			CpSpotRateInfo dbi = new CpSpotRateInfo();
//			
//			try {
//
//				dbi =(CpSpotRateInfo) objmsg.getObject();
////				if(dbi.getCurrencyPair() == null 
////						|| !dbi.getCurrencyPair().equals("USD/JPY")) return;
//				receviceMsg++;
//				
//				if(dbi.getCurrencyPair().equalsIgnoreCase("USD/JPY")){
//					
//					System.err.println("========== msg no :["+receviceMsg+"]=============");
//					System.err.println("recevieMsg: AskisTradable="+dbi.getAskBandInfo(0).isTradable());
//					System.err.println("recevieMsg: BidisTradable="+dbi.getBidBandInfo(0).isTradable());
//					System.err.println("recevieMsg: CpSpotRateId="+dbi.getCpSpotRateId());
//					System.err.println("recevieMsg: CounterPartyId="+dbi.getCounterPartyId());
//					System.err.println("recevieMsg: CurrencyPair="+dbi.getCurrencyPair());
//					System.err.println("recevieMsg:  Ask="+dbi.getAskBandInfo(0).getRate());
//					System.err.println("recevieMsg:  Bid="+dbi.getBidBandInfo(0).getRate());
//					System.err.println("=================================================");
//					
//					return ;
//				}
//				
//				log.info("========== msg no :["+receviceMsg+"]=============");
//				log.info("recevieMsg: AskisTradable="+dbi.getAskBandInfo(0).isTradable());
//				log.info("recevieMsg: BidisTradable="+dbi.getBidBandInfo(0).isTradable());
//				log.info("recevieMsg: CpSpotRateId="+dbi.getCpSpotRateId());
//				log.info("recevieMsg: CounterPartyId="+dbi.getCounterPartyId());
//				log.info("recevieMsg: CurrencyPair="+dbi.getCurrencyPair());
//				log.info("recevieMsg:  Ask="+dbi.getAskBandInfo(0).getRate());
//				log.info("recevieMsg:  Bid="+dbi.getBidBandInfo(0).getRate());
//				
//				log.info("=================================================");
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
    	}
    	
    }
	/**
     * Main method.
     *
     * @param args	the queue used by the example
     */
    public static void main(String[] args) {
        String                  queueName = null;
        QueueConnectionFactory  queueConnectionFactory = null;
        QueueConnection         queueConnection = null;
        QueueSession            queueSession = null;
        Queue                   queue = null;
        QueueReceiver           queueReceiver = null;

//        TextListener            textListener = null;
        int                     exitResult = 0;
        
//    	if (args.length != 1) {
//    	    System.out.println("Usage: java AsynchQueueReceiver <queue_name>");
//    	    System.exit(1);
//    	}   	
//        queueName = new String(args[0]);
        
//        queueName="queue/DealRequestQueue";
//        queueName="queue/CpOpmQueue";
        queueName="queue/XxlbqTestQueue";
        
        System.out.println("Queue name is " + queueName);
    	    
        try {
            queueConnectionFactory = 
                SampleUtilities.getQueueConnectionFactory();
            queueConnection = 
                queueConnectionFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(false, 
                Session.AUTO_ACKNOWLEDGE);
            queue = SampleUtilities.getQueue(queueName, queueSession);
        } catch (Exception e) {
            System.out.println("Connection problem: " + e.toString());
            if (queueConnection != null) {
                try {
                    queueConnection.close();
                } catch (JMSException ee) {}
            }
    	    System.exit(1);
        } 

        /*
         * Create receiver.
         * Register message listener (TextListener).
         * Start message delivery; listener displays the message obtained.
         * Block until publisher issues a control message indicating
         * end of publish stream.
         */
        try {
            queueReceiver = queueSession.createReceiver(queue);
//            textListener = new TextListener();
            queueReceiver.setMessageListener(new ReceiverFromQueue().new MyListener());
            queueConnection.start();
 
//            Message om =  queueReceiver.receive();
            
//           while(true){
//        	   
//           }
            
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());
            exitResult = 1;
        } finally {
            if (queueConnection != null
            		&& isShutDown == true) {
                try {
                    queueConnection.close();
                } catch (JMSException e) {
                    exitResult = 1;
                }
            }
        }
        
//        SampleUtilities.exit(exitResult);
    }
}
