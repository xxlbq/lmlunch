package com.livedoor.flow_manager.noGenerator;

public interface INoGeneratorService {


	int getIntegerId(String idKey) throws Exception;

	String getPrefixId(String prefix, String value) throws Exception;

}
