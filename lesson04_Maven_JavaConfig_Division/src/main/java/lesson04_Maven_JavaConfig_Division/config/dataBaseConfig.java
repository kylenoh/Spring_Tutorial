package lesson04_Maven_JavaConfig_Division.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lesson04_Maven_JavaConfig_Division.dto.DataBaseInfo;

@Configuration
public class dataBaseConfig {
	


	@Bean
	public DataBaseInfo InfoProd() {
		DataBaseInfo infoProd = new DataBaseInfo();
		infoProd.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:orcl");
		infoProd.setUserId("masterid");
		infoProd.setUserPw("masterpw");

		return infoProd;
	}
}
