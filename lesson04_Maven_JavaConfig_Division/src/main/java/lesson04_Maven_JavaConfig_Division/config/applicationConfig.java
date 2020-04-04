package lesson04_Maven_JavaConfig_Division.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import lesson04_Maven_JavaConfig_Division.dao.StudentDao;
import lesson04_Maven_JavaConfig_Division.service.StudentAllSelectService;
import lesson04_Maven_JavaConfig_Division.service.StudentDeleteService;
import lesson04_Maven_JavaConfig_Division.service.StudentModifyService;
import lesson04_Maven_JavaConfig_Division.service.StudentRegisterService;
import lesson04_Maven_JavaConfig_Division.service.StudentSelectByIdService;

@Configuration
@Import({importConfig.class})
public class applicationConfig {

	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}

	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}

	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}

	@Bean
	public StudentSelectByIdService selectService() {
		return new StudentSelectByIdService(studentDao());
	}

	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}



}
