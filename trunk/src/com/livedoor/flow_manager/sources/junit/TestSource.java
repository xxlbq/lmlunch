package com.livedoor.flow_manager.sources.junit;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.livedoor.flow_manager.sources.dao.imp.SourceDAO;
import com.livedoor.flow_manager.sources.service.SourceService;
//import com.lm.xml.biz.bean.Person;
//import com.lm.xml.biz.bean.PhoneNumber;
//import com.lm.xml.biz.inf.ObjXmlTransform;

public class TestSource extends TestCase {
	
	ApplicationContext ac;
	SourceDAO sDao;
	SourceService sService;
//	ObjXmlTransform transfrom;
	
	protected void setUp() throws Exception {
		super.setUp();
		ac =new FileSystemXmlApplicationContext(
				new String[]{
//						"webroot//WEB-INF//conf//spring//applicationContext-permission.xml"
//						,
						"webroot//WEB-INF//conf//spring//applicationContext-permission-other.xml"
//						,"webroot//WEB-INF//permission-hibernate-cfg.xml"
				});
//		sDao = (SourceDAO)ac.getBean("sourceDao");
//		sService = (SourceService)ac.getBean("sourceService");
//		transfrom = (ObjXmlTransform)ac.getBean("xstreamSupport");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
//	
//	public void testListParam(){
//		List pList = new ArrayList();
//		pList.add(new Integer(1));
//		pList.add(new Integer(2));
//		pList.add(new Integer(3));
//		
//		String hsql = " From com.livedoor.flow_manager.sources.beans.Source" +
//					  " WHERE sourceId in (:varlist)";
//		Session s = sDao.getHibernateTemplate().getSessionFactory().openSession();
//		Transaction tran = s.beginTransaction();
//		tran.begin();
//		Query q = s.createQuery(hsql);
//		q.setParameterList("varlist", pList);
//		
//		List lis = q.list();
//		
//		tran.commit();
//		s.close();
//		
//		for (Object object : lis) {
//			
//			System.out.println(((Source)object).getSourceName());
//		}
//		
//	}
//	
//
//	
//	public void testQueryRowCount() throws Exception {
//		assertEquals(24, sDao.getSourceCount());
//	}
//	
//	public void testTrans() throws OtherCheckedException{
//		
//		 Source s1 = new Source();
//				
//		 User insertAndUpdateUser = new User();
//		 insertAndUpdateUser.setUserId(3);
//				
//		 // s1.setSourceId(1000);//����
//		 s1.setSourceName("1000s");
//		 s1.setDeletedFlag(0);
//		 s1.setInputDatetime(Calendar.getInstance());
//		 s1.setUpdateDatetime(Calendar.getInstance());
//		 s1.setInputUser(insertAndUpdateUser);
//		 s1.setUpdateUser(insertAndUpdateUser);
//		 
//		
//		sService.addSource(s1);
//	}
//	
//	
//	public void testTrans2() throws SourceException{
//		sService.addTestInsert1();
//	}
//	
//	public void testQueryAllSource(){
//		
//		List list = sDao.queryAllSource();
//		
//		for (int i = 0; i < list.size(); i++) {
//			
//			Source ss = (Source)list.get(i);
//			
//			System.out.println(ss.getSourceName()
//					+":::"+ss.getInputUserName()
//					+":::"+ss.getUpdateUserName()
////					+":::"+ss.getGroupId()
//					
//			);
//		}
//	}
//	
//	public void testGetSourceBySourceName(){
//		
//		List list = sDao.getSourceBySourceName("1");
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(((Source)list.get(i)).getSourceId()+"---"+((Source)list.get(i)).getSourceName());
//		}
//	}
//	
//	public void testGetSourceBySourceId(){
//		
//		Source source=(Source) sDao.getSourceBySourceId(1);
//		
////		System.out.println(source.getSourceName()+""+source.getSourceDesc());
//	}
//	
//	
//	
//	public void testGetGroupsByGetSourceId(){
//		
//		Source source = sDao.getSourceBySourceId(8);
//		
//		List<Group> list = sDao.getGroupsBySource(source);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getId()+"--"+list.get(i).getGroupName());
//		}
//		
//	}
//	
//	public void testAddSource(){
//		
//		Source addSourceTmp = new Source();
//		addSourceTmp.setSourceName("addone");
//		addSourceTmp.setInputUserId(999);
//		addSourceTmp.setInputDatetime(Calendar.getInstance());
//		addSourceTmp.setUpdateDatetime(Calendar.getInstance());
//		addSourceTmp.setDeletedFlag(0);
//		sDao.addSource(addSourceTmp);
//	}
//	
//	public void testDeleteSource(){
//		
//		Source source = sDao.getSourceBySourceId(23);
//		
//		sDao.deleteSource(source);
//	}
//	
//	public void testdeleteSourceByDeleteFlag(){
//		
//		Source source = sDao.getSourceBySourceId(2);
//		
//		sDao.deleteSourceByDeleteFlag(source);
//		
//	}
//	
//	public void testUpdateSource(){
//		
//		Source source =sDao.getSourceBySourceId(20);
//		
//		source.setSourceName("ibm");
//	
////		source.setSourceDesc("202");
//		
//		sDao.updateSource(source);
//	}
//
//	
//	public void testGetSourceListByCriteriaQuerySource() 
//	throws IllegalAccessException, InstantiationException, 
//		InvocationTargetException, NoSuchMethodException{
//		
//		Source source = new Source();
//		
//		User inputUser = new User();
//		
//		inputUser.setUserId(2);
//		
//		User updateUser = new User();
//		
//		updateUser.setUserId(2);
//		
//		source.setUpdateUser(updateUser);
//		source.setInputUser(inputUser);
//		
////		source.setSourceName("1");
////		source.setInputeDatetime(DateUtil.getTestCalendar("20060905"));
//		
//		List<Source> list = sDao.getSourceListByCriteriaQuerySource(source);
//		
//		for (int i = 0; i < list.size(); i++) {
//			
//			Source ss = (Source)list.get(i);
//			
////			System.out.println(ss.getSourceName()+":::"+ss.getInputUserName()+":::"+ss.getUpdateUserName());
//			
//			System.out.println(ss.getSourceName());
//		}
//	}
//	
//	
	public void testXStreamTemplate(){
//		Person p =  new Person();
//		PhoneNumber fax = new PhoneNumber();
//		fax.setCode(123);
//		fax.setNumber("wws");
//		
//		PhoneNumber phone = new PhoneNumber();
//		phone.setCode(123);
//		phone.setNumber("119");
//		
//		p.setFax(fax);
//		p.setPhone(phone);
//		p.setFirstname("lu");
//		p.setLastname("bao");
//		
//		
//		String objxml = transfrom.objConvertToXmlString(p);
//		System.out.println(" xml:"+objxml);
	}

}
