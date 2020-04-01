package lesson02_DI_Spring_Diversity_DTO;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EDUInformation {

	private String info;
	private String copyRight;
	private String version;
	private List<String> developers;
	private Map<String, String> administrators;
	private Map<String, DataBaseInfo> dbInfos;
	
	public EDUInformation() {

	}
	
	public void outputEDUInformation(){
		System.out.print("\n\n");
		System.out.println("Developers : " + developers);
		System.out.println("Administrator : " + administrators);
		outputDataBaseInfo();
		System.out.print("\n\n");
	}

	private void outputDataBaseInfo() {
		Set<String> keys = dbInfos.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			DataBaseInfo info = dbInfos.get(key);
			System.out.println("[" + key + "]");
			System.out.print("jdbcUrl:" + info.getJdbcUrl() + "\t");
			System.out.print("userId:" + info.getUserId() + "\t");
			System.out.print("userPw:" + info.getUserPw() + "\n");
		}
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getVersion() {
		return version;
	}

	public List<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}

	public Map<String, String> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Map<String, String> administrators) {
		this.administrators = administrators;
	}

	public Map<String, DataBaseInfo> getDbInfos() {
		return dbInfos;
	}

	public void setDbInfos(Map<String, DataBaseInfo> dbInfos) {
		this.dbInfos = dbInfos;
	}

}
