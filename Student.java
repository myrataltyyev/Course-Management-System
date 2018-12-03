
public class Student {
	
	private String id;
	private String[] name;
	private String department;
	private String email;
	
	Student(){}
	
	Student(String id, String name, String department){
		this.id = id;
		this.name = name.split(" ");
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name[0] + " " + name[1];
	}

	public void setName(String name) {
		this.name = name.split(" ");
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail() {
		this.email = name[0].toLowerCase().charAt(0) + name[1].toLowerCase() + "@fatih.edu.tr";
	}
	
	public void display(){
		System.out.printf("%-7s%-20s%-30s%s\n",id,name[0]+" "+name[1],department,email);
	}

	public String toString() {
		return id + " " + name[0] + " " + name[1] + " " + department + " " + email;
	}
	
	
}
