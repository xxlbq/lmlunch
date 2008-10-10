package com.livedoor.flow_manager.group_source.junit;

import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.livedoor.flow_manager.group_source.beans.GroupSource;
import com.livedoor.flow_manager.group_source.dao.imp.GroupSourceManager;

public class TestGroupSource extends TestCase {
	
	ApplicationContext ac;
	GroupSourceManager s;
	

	
	protected void setUp() throws Exception {
		super.setUp();
		ac =new FileSystemXmlApplicationContext(new String[]{"webroot//WEB-INF//applicationContext-permission.xml","webroot//WEB-INF//applicationContext-permission-source.xml"});
		s = (GroupSourceManager)ac.getBean("groupSourceManager");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testQueryAllGroupSource() {

		List list = s.queryAllGroupSource();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(((GroupSource) list.get(i)).getGroupSourceId()
					+ "---" + ((GroupSource) list.get(i)).getGroupSourceDesc());
		}
	}
	
	public void testgetGroupSourceByGroupSourceId(){
		
		GroupSource gs = s.getGroupSourceByGroupSourceId(1);
		
		System.out.println(gs.getGroupSourceDesc());
		
	}
	public void testAddGroupSource(){
		
		GroupSource addGroupSourceTmp = new GroupSource();
		
		addGroupSourceTmp.setGroupId(999222);
		addGroupSourceTmp.setSourceId(999222);
		addGroupSourceTmp.setDeletedFlag(1);
		addGroupSourceTmp.setGroupSourceDesc("this is test add");
		addGroupSourceTmp.setInputDatetime(Calendar.getInstance());
		addGroupSourceTmp.setInputUserId(999);
		addGroupSourceTmp.setUpdateDatetime(Calendar.getInstance());
		addGroupSourceTmp.setUpdateUserId(999);
		
		s.addGroupSource(addGroupSourceTmp);
	}
	
	public void testUpdateGroupSource(){
		
		GroupSource groupSource = s.getGroupSourceByGroupSourceId(15);

		groupSource.setSourceId(77);
		groupSource.setGroupId(77);
		
		groupSource.setGroupSourceDesc("update done~~");
		
		s.updateGroupSource(groupSource);
	}
	

	
	public void testDeleteGroupSource(){
		
		GroupSource groupSource = s.getGroupSourceByGroupSourceId(15);
		
		s.deleteGroupSource(groupSource);
	}
	
	public void testDeleteGroupSourceByDeleteFlag(){
		
		GroupSource groupSource = s.getGroupSourceByGroupSourceId(2);
		
		s.deleteGroupSourceByDeleteFlag(groupSource);
		
	}
	

}
