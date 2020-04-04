package lesson04_Maven_JavaConfig_DAO;

import java.util.HashMap;
import java.util.Map;

import lesson04_Maven_JavaConfig_DTO.Student;

public class StudentDao {

	private Map<String, Student> studentMap = new HashMap<String, Student>();
	
	public void insert(Student student) {
		studentMap.put(student.getCode(), student);
	}
	
	public Student selectbyCode(String code) {
		return studentMap.get(code);
	}
	
	public void update(Student student) {
		studentMap.put(student.getCode(), student);
	}
	
	public void delete(String code) {
		studentMap.remove(code);
	}
	
	public Map<String, Student> select() {
		return studentMap;
	}
	
}
