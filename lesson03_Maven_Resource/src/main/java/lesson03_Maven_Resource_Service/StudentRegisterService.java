package lesson03_Maven_Resource_Service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import lesson03_Maven_Resource_DAO.StudentDao;
import lesson03_Maven_Resource_DTO.Student;

public class StudentRegisterService {

	@Resource
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
