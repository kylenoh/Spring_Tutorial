package lesson02_DI_Maven_XmlConfig_Division_Service;

import lesson02_DI_Maven_XmlConfig_Division_DAO.StudentDao;
import lesson02_DI_Maven_XmlConfig_Division_DTO.Student;

public class StudentModifyService {

	private StudentDao studentDao;
	
	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void modify(Student student) {
		if(verify(student.getCode())) {
			studentDao.update(student);
		} else {
			System.out.println("학생 정보를 이용할 수 없습니다.");
		}
	}
	
	public boolean verify(String code){
		Student student = studentDao.selectbyCode(code);
		return student != null ? true : false;
	}
}
