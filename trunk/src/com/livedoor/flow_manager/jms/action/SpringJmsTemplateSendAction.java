package com.livedoor.flow_manager.jms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.livedoor.flow_manager.jms.service.JMSQueueSender;

public class SpringJmsTemplateSendAction extends Action{
	
	private JMSQueueSender jmsQueueSender;
	
	public JMSQueueSender getJmsQueueSender() {
		return jmsQueueSender;
	}

	public void setJmsQueueSender(JMSQueueSender jmsQueueSender) {
		this.jmsQueueSender = jmsQueueSender;
	}

	public ActionForward execute(ActionMapping mapping,
			   ActionForm form,
			   HttpServletRequest request,
			   HttpServletResponse response) throws Exception {
		
		getJmsQueueSender().sendMesage(""+request.getParameter("sendmsg"));
		System.out.println("send msg:"+request.getParameter("sendmsg"));
		return mapping.findForward("success");
	}

}
