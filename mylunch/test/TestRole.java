

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.livedoor.flow_manager.role.dao.RoleDao;
import com.livedoor.flow_manager.sources.dao.imp.SourceDAO;
import com.livedoor.flow_manager.sources.service.SourceService;


public class TestRole {
	
	private static ApplicationContext ac;
	private static RoleDao rDao;
//	RoleDao sDao;
//	RoleService sService;
//	ObjXmlTransform transfrom;
	
	protected static void setUp() throws Exception {
//		super.setUp();
		ac =new FileSystemXmlApplicationContext(
				new String[]{
//						"webroot//WEB-INF//conf//spring//applicationContext-permission.xml"
//						,
						"webroot//WEB-INF//conf//spring//applicationContext-permission.xml"
//						,"webroot//WEB-INF//permission-hibernate-cfg.xml"
				});
		rDao = (RoleDao)ac.getBean("roleDao");
//		sService = (SourceService)ac.getBean("sourceService");
//		transfrom = (ObjXmlTransform)ac.getBean("xstreamSupport");
	}

	protected static void tearDown() throws Exception {
//		super.tearDown();
	}
//	

	public static void main(String[] args) throws Exception {
			setUp();
			
			
			
			tearDown();
		
	
	}
}
