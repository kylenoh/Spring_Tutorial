package lesson04_Maven_JavaConfig_Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lesson04_Maven_JavaConfig_DAO.StudentDao;
import lesson04_Maven_JavaConfig_DTO.DataBaseInfo;
import lesson04_Maven_JavaConfig_DTO.EDUInformation;
import lesson04_Maven_JavaConfig_Service.StudentAllSelectService;
import lesson04_Maven_JavaConfig_Service.StudentDeleteService;
import lesson04_Maven_JavaConfig_Service.StudentModifyService;
import lesson04_Maven_JavaConfig_Service.StudentRegisterService;
import lesson04_Maven_JavaConfig_Service.StudentSelectByIdService;

@Configuration
public class applicationConfig {

/*
 * <bean id="studentDao" class="lesson02_DI_Spring_Diversity_XML_DAO.StudentDao" ></bean>
 */
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
/*
 * <bean id="registerService" class="lesson02_DI_Spring_Diversity_XML_Service.StudentRegisterService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
 */
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
/*
 * 	<bean id="modifyService" class="lesson02_DI_Spring_Diversity_XML_Service.StudentModifyService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
 */
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
/*
 * 	<bean id="deleteService" class="lesson02_DI_Spring_Diversity_XML_Service.StudentDeleteService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
 * */	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
/*
 * 	<bean id="selectService" class="lesson02_DI_Spring_Diversity_XML_Service.StudentSelectByIdService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
 * */	
	@Bean
	public StudentSelectByIdService selectService() {
		return new StudentSelectByIdService(studentDao());
	}
/*
 * 	<bean id="allSelectService" class="lesson02_DI_Spring_Diversity_XML_Service.StudentAllSelectService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
 * */	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}

/** -------------------------------------------------------------*/	

/*
 * 	<bean id="InfoDev" class="lesson02_DI_Spring_Diversity_XML_DTO.DataBaseInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:orcl" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	</bean>
 * */
	@Bean
	public DataBaseInfo InfoDev() {
		DataBaseInfo infoDev = new DataBaseInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		infoDev.setUserId("scott");
		infoDev.setUserPw("tiger");
		
		return infoDev;
	}
/*
 * 	<bean id="InfoProd" class="lesson02_DI_Spring_Diversity_XML_DTO.DataBaseInfo" scope="prototype">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@192.168.0.1:1521:orcl" />
		<property name="userId" value="masterid" />
		<property name="userPw" value="masterpw" />
	</bean>
 * */
	@Bean
	public DataBaseInfo InfoProd() {
		DataBaseInfo infoProd = new DataBaseInfo();
		infoProd.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:orcl");
		infoProd.setUserId("masterid");
		infoProd.setUserPw("masterpw");
		
		return infoProd;
	}
/** -------------------------------------------------------------*/		
	
/*
 * 	<bean id="informationService" class="lesson02_DI_Spring_Diversity_XML_DTO.EDUInformation">
		<property name="info">
			<value>Education Management System program</value>
		</property>
		<property name="copyRight">
			<value>COPYRIGHT(C) 2020 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT KYLE FOR MORE INFORMATION.</value>
		</property>
		<property name="version">
			<value>The version is 1.0</value>
		</property>
		<property name="developers">
			<list>
				<value>Kyle</value>
				<value>Joy</value>
				<value>Oraf</value>
			</list>
		</property>
		<property name="administrators">
			<map>
				<entry>
					<key>
						<value>Kyle</value>
					</key>
					<value>Kyley@springPjt.org</value>
				</entry>
				<entry>
					<key>
						<value>Joy</value>
					</key>
					<value>Joy@springPjt.org</value>
				</entry>
			</map>
		</property>
		<property name="dbInfo">
			<map>
				<entry>
					<key>
						<value>dev</value>
					</key>
					<ref bean="InfoDev"/>
				</entry>
				<entry>
					<key>
						<value>real</value>
					</key>
					<ref bean="InfoProd"/>
				</entry>
			</map>
		</property>
	</bean>
 * */
	@Bean
	public EDUInformation informationService() {
		EDUInformation info = new EDUInformation();
		
		info.setInfo("Education Management System program");
		info.setCopyRight("COPYRIGHT(C) 2020 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT KYLE FOR MORE INFORMATION.");
		info.setVersion("The version is 1.0");
		
		ArrayList<String>developers = new ArrayList<String>();
		developers.add("Kyle");
		developers.add("Joy");
		developers.add("Oraf");
		info.setDevelopers(developers);
		
		Map<String, String>administrators = new HashMap<String, String>();
		administrators.put("Kyle", "Kyley@springPjt.org");
		administrators.put("Joy", "Joy@springPjt.org");

		Map<String, DataBaseInfo>dbInfo = new HashMap<String, DataBaseInfo>();
		dbInfo.put("dev", InfoDev());
		dbInfo.put("real", InfoProd());
		info.setDbInfos(dbInfo);
		
		return info;
	}
}
