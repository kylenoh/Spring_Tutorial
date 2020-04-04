package lesson04_Maven_JavaConfig_Division.assembler;

import lesson04_Maven_JavaConfig_Division.dao.StudentDao;
import lesson04_Maven_JavaConfig_Division.service.StudentAllSelectService;
import lesson04_Maven_JavaConfig_Division.service.StudentDeleteService;
import lesson04_Maven_JavaConfig_Division.service.StudentModifyService;
import lesson04_Maven_JavaConfig_Division.service.StudentRegisterService;
import lesson04_Maven_JavaConfig_Division.service.StudentSelectByIdService;

public class StudentAssembler {

	private StudentDao studentDao;
	private StudentRegisterService registerService;
	private StudentModifyService modifyService;
	private StudentDeleteService deleteService;
	private StudentSelectByIdService selectbyIdService;
	private StudentAllSelectService SelectAllService;
	
	public StudentAssembler() {
		studentDao = new StudentDao();
		registerService = new StudentRegisterService(studentDao);
		modifyService = new StudentModifyService(studentDao);
		deleteService = new StudentDeleteService(studentDao);
		selectbyIdService = new StudentSelectByIdService(studentDao);
		SelectAllService = new StudentAllSelectService(studentDao);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public StudentRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(StudentRegisterService registerService) {
		this.registerService = registerService;
	}

	public StudentModifyService getModifyService() {
		return modifyService;
	}

	public void setModifyService(StudentModifyService modifyService) {
		this.modifyService = modifyService;
	}

	public StudentDeleteService getDeleteService() {
		return deleteService;
	}

	public void setDeleteService(StudentDeleteService deleteService) {
		this.deleteService = deleteService;
	}

	public StudentSelectByIdService getSelectbyIdService() {
		return selectbyIdService;
	}

	public void setSelectbyIdService(StudentSelectByIdService selectbyIdService) {
		this.selectbyIdService = selectbyIdService;
	}

	public StudentAllSelectService getSelectAllService() {
		return SelectAllService;
	}

	public void setSelectAllService(StudentAllSelectService selectAllService) {
		SelectAllService = selectAllService;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	

	
}
