package com.livedoor.flow_manager.jmx.demo;

import javax.management.Attribute;
import javax.management.ObjectName;

import com.sun.jdmk.comm.RmiConnectorAddress;
import com.sun.jdmk.comm.RmiConnectorClient;

public class RMIManager {
	public static void main(String[] args) {
		RmiConnectorClient client = new RmiConnectorClient();
		RmiConnectorAddress address = new RmiConnectorAddress();
		try {
			client.connect(address);
			ObjectName helloWorldName = ObjectName
					.getInstance("HelloAgent:name=helloWorld1");
			client.invoke(helloWorldName, "sayHello", null, null);
			client.setAttribute(helloWorldName, new Attribute("Hello",
					new String("hello girls!")));
			
//			client.setAttribute(helloWorldName, new Attribute("TestAttr",
//					new String("hello test!")));
//			
			client.invoke(helloWorldName, "sayHello", null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
