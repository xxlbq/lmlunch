package com.livedoor.flow_manager.jms.action;

import javax.jms.Message;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.jms.service.JMSQueueReceiver;

public class SpringJmsTemplateReceiveAction extends Action{
	
	private JMSQueueReceiver jmsQueueReceiver;
	
	public JMSQueueReceiver getJmsQueueReceiver() {
		return jmsQueueReceiver;
	}

	public void setJmsQueueReceiver(JMSQueueReceiver jmsQueueReceiver) {
		this.jmsQueueReceiver = jmsQueueReceiver;
	}

	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		Message msg = getJmsQueueReceiver().receive();
		if(msg == null) {
			request.setAttribute("receiveText", "jboss warn! no msg sended...");
			return mapping.findForward("success");
		}
        TextMessage textMessage = (TextMessage) msg;
		System.out.println("receiveText:"+textMessage.getText());
        request.setAttribute("receiveText", textMessage.getText());
		return mapping.findForward("success");
	}

}