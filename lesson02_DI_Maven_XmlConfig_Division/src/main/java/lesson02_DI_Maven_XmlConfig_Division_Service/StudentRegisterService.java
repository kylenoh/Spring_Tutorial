package lesson02_DI_Maven_XmlConfig_Division_Service;

import lesson02_DI_Maven_XmlConfig_Division_DAO.StudentDao;
import lesson02_DI_Maven_XmlConfig_Division_DTO.Student;

public class StudentRegisterService {

	private StudentDao studentDao;
	
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
		Student student = studentDao.selectbyCode(code);
		return student == null ? true : false;
	}
}
