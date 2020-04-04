package lesson03_Maven_Autowired_DTO;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	
	@Autowired
	private String code;
	private String Id;
	private String Pw;
	private String Name;

	public Student(String code, String id, String pw, String name) {
		this.code = code;
		Id = id;
		Pw = pw;
		Name = name;
	}

	public String getCode() {
		return code;
	}

	@Autowired
	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPw() {
		return Pw;
	}

	public void setPw(String pw) {
		Pw = pw;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
