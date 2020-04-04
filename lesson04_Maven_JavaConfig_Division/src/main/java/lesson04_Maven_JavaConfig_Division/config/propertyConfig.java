package lesson04_Maven_JavaConfig_Division.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lesson04_Maven_JavaConfig_Division.dto.DataBaseInfo;
import lesson04_Maven_JavaConfig_Division.dto.EDUInformation;

@Configuration
public class propertyConfig {
	
	@Autowired
	DataBaseInfo InfoDev;
	
	@Autowired
	DataBaseInfo InfoProd;
	
	@Bean
	public EDUInformation informationService() {
		EDUInformation info = new EDUInformation();

		info.setInfo("Education Management System program");
		info.setCopyRight("COPYRIGHT(C) 2020 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT KYLE FOR MORE INFORMATION.");
		info.setVersion("The version is 1.0");

		ArrayList<String> developers = new ArrayList<String>();
		developers.add("Kyle");
		developers.add("Joy");
		developers.add("Oraf");
		info.setDevelopers(developers);

		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Kyle", "Kyley@springPjt.org");
		administrators.put("Joy", "Joy@springPjt.org");

		Map<String, DataBaseInfo> dbInfo = new HashMap<String, DataBaseInfo>();
		dbInfo.put("dev", InfoDev);
		dbInfo.put("real", InfoProd);
		info.setDbInfos(dbInfo);

		return info;
	}
}
