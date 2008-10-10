package com.livedoor.flow_manager.sources.junit;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.livedoor.flow_manager.sources.dao.imp.SourceDAO;
import com.livedoor.flow_manager.sources.service.SourceService;

public class CacheTest extends TestCase {

	ApplicationContext ac;
	SourceDAO sDao;
	SourceService sService;
	Thread t;	
	protected void setUp() throws Exception {
		super.setUp();
		ac =new FileSystemXmlApplicationContext(
				new String[]{
						"webroot//WEB-INF//conf//spring//applicationContext-permission.xml"
						,"webroot//WEB-INF//conf//spring//applicationContext-permission-other.xml"
//						,"webroot//WEB-INF//permission-hibernate-cfg.xml"
				});
		sDao = (SourceDAO)ac.getBean("sourceDao");
		sService = (SourceService)ac.getBean("sourceService");
	}
//

//		super.tearDown();
//	}􀀇􀂐􀀡􀀖􀂤􀀣􀀖􀀢􀀟􀀡􀁀􀁫􀁮
//
	public void testThread() throws Exception {
		t = Thread.currentThread();
//		t.
	}
}