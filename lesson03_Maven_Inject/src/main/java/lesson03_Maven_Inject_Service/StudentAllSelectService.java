package lesson03_Maven_Inject_Service;

import javax.inject.Inject;
import javax.inject.Named;

import lesson03_Maven_Inject_DAO.StudentDao;
import lesson03_Maven_Inject_DTO.Student;

public class StudentAllSelectService {

	@Inject
	@Named(value = "studentDao1")
	private StudentDao studentDao;

	public StudentAllSelectService() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student select(String code) {
		if(verify(code)) {
			return studentDao.select(code);
		} else {
			System.out.println("학생 정보를 이용할 수 없습니다.");
		}
		
		return null;
	}
	
	public boolean verify(String code){
		Student student = studentDao.select(code);
		return student != null ? true : false;
	}
}