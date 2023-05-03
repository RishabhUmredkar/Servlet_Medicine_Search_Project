package model;

public class Medicine {

	private String MedicineName;
	private String CompanyName;
	private int Number;
	
	
	
	
	
	
	public Medicine(String medicineName, String companyName, int number) {
		super();
		MedicineName = medicineName;
		CompanyName = companyName;
		Number = number;
	}
	
	
	
	
	public Medicine(String medicineName, int number) {
		super();
		MedicineName = medicineName;
		Number = number;
	}




	public Medicine(int number) {
		super();
		Number = number;
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
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}




	@Override
	public String toString() {
		return "Medicine [MedicineName=" + MedicineName + ", CompanyName=" + CompanyName + ", Number=" + Number + "]";
	}
	
	
	
}
