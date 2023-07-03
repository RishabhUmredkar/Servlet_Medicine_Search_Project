package model;

public class Medicine {

	private int id;
	private String MedicineName;
	private String CompanyName;
	private String Number;
	
	
	
	
	
	
	public Medicine(int id, String medicineName, String companyName, String number) {
		super();
		this.id = id;
		MedicineName = medicineName;
		CompanyName = companyName;
		Number = number;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Medicine(String medicineName, String companyName, String number) {
		super();
		MedicineName = medicineName;
		CompanyName = companyName;
		Number = number;
	}
	
	
	
	
	public Medicine(String medicineName, String number) {
		super();
		MedicineName = medicineName;
		Number = number;
	}




	public Medicine(int id) {
		super();
		id = id;
	}




	public Medicine() {
		super();
	}




	public String getMedicineName() {
		return MedicineName;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}




	@Override
	public String toString() {
		return "Medicine [id=" + id + ", MedicineName=" + MedicineName + ", CompanyName=" + CompanyName + ", Number="
				+ Number + "]";
	}
	
	
	
}
