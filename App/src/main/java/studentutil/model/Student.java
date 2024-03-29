package studentutil.model;

public class Student {
	int id;
	String name;
	String department;
	String branch;
	String address;

	public Student() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student(int id, String name, String department, String branch, String address) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.branch = branch;
		this.address = address;
	}

	public Student(String name, String department, String branch, String address) {
		this.name = name;
		this.department = department;
		this.branch = branch;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getBranch() {
		return branch;
	}

	public String getAddress() {
		return address;
	}
}