package lesson03_Spring_Inject_DAO;

import java.util.HashMap;
import java.util.Map;

import lesson03_Spring_Inject_DTO.Student;

public class StudentDao {

	private Map<String, Student> studentMap = new HashMap<String, Student>();
	
	public void insert(Student student) {
		studentMap.put(student.getCode(), student);
	}

	public Student select(String code) {
		return studentMap.get(code);
	}
	
}
