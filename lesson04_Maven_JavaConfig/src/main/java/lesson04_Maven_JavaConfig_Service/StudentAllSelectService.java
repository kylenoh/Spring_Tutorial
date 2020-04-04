package lesson04_Maven_JavaConfig_Service;

import java.util.Map;

import lesson04_Maven_JavaConfig_DAO.StudentDao;
import lesson04_Maven_JavaConfig_DTO.Student;

public class StudentAllSelectService {

	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> Select() {
		return studentDao.select();
	}
	
}