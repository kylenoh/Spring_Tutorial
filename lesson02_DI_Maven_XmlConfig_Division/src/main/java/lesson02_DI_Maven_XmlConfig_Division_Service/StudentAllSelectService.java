package lesson02_DI_Maven_XmlConfig_Division_Service;

import java.util.Map;

import lesson02_DI_Maven_XmlConfig_Division_DAO.StudentDao;
import lesson02_DI_Maven_XmlConfig_Division_DTO.Student;

public class StudentAllSelectService {

	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> Select() {
		return studentDao.select();
	}
	
}