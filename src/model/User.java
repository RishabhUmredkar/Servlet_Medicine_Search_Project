package model;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String number;
	private String pass;
	

	public User(int id, String name, String email, String number, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.pass = pass;
	}

	
	public User(String name, String email, String number, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.pass = pass;
	}


	public User(String name, String email, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
	}


	public User(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", number=" + number + ", pass=" + pass + "]";
	}



}
