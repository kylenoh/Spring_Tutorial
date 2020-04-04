package lesson03_Maven_Inject_Service;

import javax.inject.Inject;
import javax.inject.Named;

import lesson03_Maven_Inject_DAO.StudentDao;
import lesson03_Maven_Inject_DTO.Student;

public class StudentRegisterService {

	@Inject
	@Named(value = "studentDao1")
	private StudentDao studentDao;
	
	public StudentRegisterService() {
		// TODO Auto-generated constructor stub
	}

	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void register(Student student) {
		String code = student.getCode();
		if(verify(code)) {
			studentDao.insert(student);
		} else {
			System.out.println("해당 학생은 이미 등록되었습니다.");
		}
	}
	
	public boolean verify(String code){
		Student student = studentDao.select(code);
		return student == null ? true : false;
	}
}
