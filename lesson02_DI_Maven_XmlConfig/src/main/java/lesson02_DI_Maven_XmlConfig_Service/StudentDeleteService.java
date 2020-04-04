package lesson02_DI_Maven_XmlConfig_Service;

import lesson02_DI_Maven_XmlConfig_DAO.StudentDao;
import lesson02_DI_Maven_XmlConfig_DTO.Student;

public class StudentDeleteService {

	private StudentDao studentDao;
	
	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void delete(Student student) {
		if(verify(student.getCode())) {
			studentDao.delete(student.getCode());
		} else {
			System.out.println("학생 정보를 이용할 수 없습니다.");
		}
	}
	
	public boolean verify(String code){
		Student student = studentDao.selectbyCode(code);
		return student != null ? true : false;
	}
}
