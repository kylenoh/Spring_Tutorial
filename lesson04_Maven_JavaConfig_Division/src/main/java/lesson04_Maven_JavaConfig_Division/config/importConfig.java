package lesson04_Maven_JavaConfig_Division.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lesson04_Maven_JavaConfig_Division.dto.DataBaseInfo;

@Configuration
public class importConfig {

	@Bean
	public DataBaseInfo InfoDev() {
		DataBaseInfo infoDev = new DataBaseInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		infoDev.setUserId("scott");
		infoDev.setUserPw("tiger");

		return infoDev;
	}
}
