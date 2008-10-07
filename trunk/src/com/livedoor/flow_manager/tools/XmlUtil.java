//package com.livedoor.flow_manager.tools;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//
//import com.lm.xml.biz.bean.Person;
//import com.lm.xml.biz.bean.PhoneNumber;
//import com.lm.xml.biz.inf.ObjXmlTransform;
//
//public class XmlUtil {
//	public static void main(String[] args) {
//		
//		ApplicationContext ac;
//		ObjXmlTransform transfrom;
//		
//		ac =new FileSystemXmlApplicationContext(
//				new String[]{
//						"webroot//WEB-INF//conf//spring//applicationContext-permission-xmlutil.xml"
//				});
//
//		transfrom = (ObjXmlTransform)ac.getBean("xstreamSupport");
//		
//		
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
//		
//	}
//}
