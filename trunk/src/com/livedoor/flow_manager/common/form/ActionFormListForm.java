package com.livedoor.flow_manager.common.form;

import org.apache.struts.validator.ValidatorActionForm;

import com.livedoor.flow_manager.common.entity.PriceMaster;

public class ActionFormListForm extends ValidatorActionForm {
	
	private PriceMaster[] pm;
	
	private String[] machineType;
	private String[] machineCount;
//	private String[] groupType;
//	private String[] groupCount;
	
	
	
//	public String[] getGroupCount() {
//		return groupCount;
//	}
//
//	public void setGroupCount(String[] groupCount) {
//		this.groupCount = groupCount;
//		
////		if(pm == null){
////			pm = new ArrayList();
////		}
////		
////		for (int i = 0; i < machineCount.length; i++) {
////			if(pm.get(i) == null){
////				pm.set(1, new PriceMaster());
////			}
////			
////			List gList = new ArrayList();
////			
////			for (int j = i*15; j < (1+i)*15; j++) {
////				Group gp = new Group(machineType[i],machineCount[i],null);
////				gList.add(gp);
////			}
////			
////			PriceMaster p = (PriceMaster)pm.get(i);
////			p.setGroupList(gList);
////		}
//		
//	}

//	public String[] getGroupType() {
//		return groupType;
//	}
//
//	public void setGroupType(String[] groupType) {
//		this.groupType = groupType;
//	}

	public String[] getMachineCount() {
		return machineCount;
	}

	public void setMachineCount(String[] machineCount) {
		this.machineCount = machineCount;
		
//		if(pm == null){
//			pm = new ArrayList();
//		}
//		
//		for (int i = 0; i < machineCount.length; i++) {
//			
//			PriceMaster tempPm = (PriceMaster)pm.get(i);
//			
//			if(tempPm == null){
//				tempPm= new PriceMaster();
//				tempPm.setMachineCount(machineCount[i]);
//				
//				pm.set(i, tempPm);
//			}else{
//				tempPm.setMachineCount(machineCount[i]);
//			}
//			
//		}
	}

	public String[] getMachineType() {
		return machineType;
	}

	public void setMachineType(String[] machineType) {
		this.machineType = machineType;
//		
//		if(pm == null){
//			pm = new ArrayList();
//		}
//		
//		for (int i = 0; i < machineType.length; i++) {
//			
//			PriceMaster tempPm ;
//			if(pm.get(i) == null){
//				
//				tempPm= new PriceMaster();
//				tempPm.setMachineType(machineType[i]);
//				
//				pm.set(i, tempPm);
//			
//			
//			
//			}else{
//				tempPm =(PriceMaster) pm.get(i);
//				tempPm.setMachineType(machineType[i]);
//			}
//			
//		}
	}

	public PriceMaster[] getPm() {
		return pm;
	}

	public void setPm(PriceMaster[] pm) {
		
		if(null != machineType){
//			System.out.println("oooo->"+machineType.length);
//			System.out.println("oooo->"+machineCount.length);
		}
		
		
		if(null ==pm){
			PriceMaster[] nPm = new PriceMaster[machineType.length];
			
			for (int i = 0; i < nPm.length; i++) {
				nPm[i] = new PriceMaster();
				nPm[i].setMachineType(machineType[i]);
				nPm[i].setMachineCount(machineCount[i]);
			}
			
			this.pm = nPm;
		}else{
			this.pm = pm;
		}
		
		
		
	}



//	@Override
//	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//		
//		ActionErrors es = checkField();
//		
//		initPmList();
//		
//		if(es.size() > 0){
//			return es;
//		}
//		
//		return super.validate(mapping, request);
//	}



//	private void initPmList() {
//		
//		pm = new ArrayList();
//		for (int i = 0; i < machineType.length; i++) {
//			PriceMaster pmEntity = new PriceMaster();
//			pmEntity.setMachineType(machineType[i]);
//			pmEntity.setMachineCount(machineCount[i]);
//			
//			List gList = new ArrayList();
//		
//			
//			for (int j = i*15; j < (1+i)*15; j++) {
//				Group gp = new Group(machineType[i],machineCount[i],null);
//				gList.add(gp);
//			}
//			
//			
//			pmEntity.setGroupList(gList);
//			pm.add(pmEntity);
//		}
//		
//	
//	}
//
//	private ActionErrors checkField() {
//		
//		ActionErrors errs = new ActionErrors();
//		for (int i = 0; i < machineType.length; i++) {
//			if (UtilValidate.isEmpty(machineType[i]) 
//					&& UtilValidate.isNotEmpty(machineCount[i]) ){
//				errs.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.msg.1"));
//				
//			}
//		}
//		
//		for (int i = 0; i < groupType.length; i++) {
//			if (UtilValidate.isNotEmpty(groupType[i]) 
//					&& UtilValidate.isEmpty(groupCount[i])){
//				errs.add(ActionErrors.GLOBAL_MESSAGE,  new ActionMessage("error.msg.2"));
//			}
//		}
//		return errs;
//	}
//	
//	
	
	

}
