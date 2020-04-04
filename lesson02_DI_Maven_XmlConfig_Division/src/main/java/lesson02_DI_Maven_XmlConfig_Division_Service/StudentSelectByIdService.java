package lesson02_DI_Maven_XmlConfig_Division_Service;

import lesson02_DI_Maven_XmlConfig_Division_DAO.StudentDao;
import lesson02_DI_Maven_XmlConfig_Division_DTO.Student;

public class StudentSelectByIdService {

	private StudentDao studentDao;
	
	public StudentSelectByIdService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student select(String code) {
		if(verify(code)) {
			return studentDao.selectbyCode(code);
		} else {
			System.out.println("학생 정보를 이용할 수 없습니다.");
		}
		
		return null;
	}
	
	public boolean verify(String code){
		Student student = studentDao.selectbyCode(code);
		return student != null ? true : false;
	}
}
