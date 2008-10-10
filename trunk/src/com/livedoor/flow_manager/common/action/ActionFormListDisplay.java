package com.livedoor.flow_manager.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.livedoor.flow_manager.common.entity.PriceMaster;
import com.livedoor.flow_manager.common.form.ActionFormListForm;

public class ActionFormListDisplay extends MappingDispatchAction {

	public ActionForward display( ActionMapping mapping , ActionForm form ,
			HttpServletRequest request , HttpServletResponse response )
			throws Exception
	{
//		HttpSession session = request.getSession() ;
		
		
		PriceMaster pm1 = new PriceMaster();
		PriceMaster pm2 = new PriceMaster();
		PriceMaster pm3 = new PriceMaster();
		
		
		pm1.setMachineType("TMDD001");pm1.setMachineCount("1");
		pm2.setMachineType("TMDE001");pm2.setMachineCount("9");
		pm3.setMachineType("TMDD001");pm3.setMachineCount("10");
		
//		List groupList1 = new ArrayList(15);
//		List groupList2 = new ArrayList(15);
//		List groupList3 = new ArrayList(15);
		
//		System.out.println(" list init size:"+groupList1.size());
		
//		for(int i=0;i<15;i++){
//			
//			if(i==0){
//				groupList1.add(new Group("AAAAA1","1",null));
//				groupList2.add(new Group("AAAAA2","10",null));
//				groupList3.add(new Group("AAAAA3","100",null));
//			}else if(i==1){
//				groupList1.add(new Group("BBBBB1","2",null));
//				groupList2.add(new Group("BBBBB2","20",null));
//				groupList3.add(new Group("BBBBB3","200",null));
//			}else{
//				groupList1.add(new Group());
//				groupList2.add(new Group());
//				groupList3.add(new Group());
//			}
//		}
		
//		pm1.setGroupList(groupList1);
//		pm2.setGroupList(groupList2);
//		pm3.setGroupList(groupList3);

		
		ActionFormListForm aform = (ActionFormListForm)form; 
		aform.setPm(new PriceMaster[]{pm1,pm2,pm3});
		
		return mapping.findForward( "success" ) ;
	}
}
