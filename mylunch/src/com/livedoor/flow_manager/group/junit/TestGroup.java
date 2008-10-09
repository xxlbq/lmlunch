package com.livedoor.flow_manager.group.junit;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.livedoor.flow_manager.group.beans.Group;
import com.livedoor.flow_manager.group.implments.GroupDaoImpl;
import com.livedoor.flow_manager.sources.beans.Source;

public class TestGroup extends TestCase {
	
	ApplicationContext ac;
	GroupDaoImpl s;
	
//	public TestSource(String arg0) {
//		super(arg0);
//	}

	
	protected void setUp() throws Exception {
		super.setUp();
		ac =new FileSystemXmlApplicationContext("webroot//WEB-INF//applicationContext.xml");
		s = (GroupDaoImpl)ac.getBean("groupService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetGroupByLoadGroupId(){
		
		Group group = s.getGroupByLoadGroupId(2);
		
		System.out.println(group.getId()+"--"+group.getGroupName()+"--"+group.getGroupDesc());
	}
	
	public void testGetSourcsByGroup(){
		List<Source> sourceList = s.getSourcsByGroup(s.getGroupByLoadGroupId(2));
		
		for (int i = 0; i < sourceList.size(); i++) {
//			System.out.println(sourceList.get(i).getSourceId()+"--"+sourceList.get(i).getSourceName()+"--"+sourceList.get(i).getSourceDesc());
		}
		
		
		System.out.println();
	}
}
