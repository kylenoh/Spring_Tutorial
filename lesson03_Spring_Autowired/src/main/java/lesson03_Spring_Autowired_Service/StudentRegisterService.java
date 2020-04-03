package lesson03_Spring_Autowired_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lesson03_Spring_Autowired_DAO.StudentDao;
import lesson03_Spring_Autowired_DTO.Student;

public class StudentRegisterService {

	@Autowired
	@Qualifier("chooseDao")
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
