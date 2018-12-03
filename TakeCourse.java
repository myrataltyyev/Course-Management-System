
public class TakeCourse {
	static java.util.Random rand = new java.util.Random();
	
	private Student student;
	private Course course;
	private String grade;
	
	public TakeCourse() {}

	public TakeCourse(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		int midterm1 = rand.nextInt(101);
		int midterm2 = rand.nextInt(101);
		int finalExam = rand.nextInt(101);
		
		double result = midterm1*course.getEval()[0] + midterm2*course.getEval()[1] + finalExam*course.getEval()[2];
		
		if (result >= 90) grade = "A";
		else if (result < 90 && result >= 80) grade = "B";
		else if (result < 80 && result >=70) grade = "C";
		else if (result < 70 && result >=60) grade = "D";
		else grade = "F";
	}
	
	public void display(){
		System.out.printf("%-7s%-20s%-25s%-15s%s\n",student.getId(),student.getName(),student.getDepartment(),course.getCid(),course.getDescription());
	}
	
	public String toString(){
		return student.getId() + " " + student.getName() + " " + student.getDepartment() + " " + course.getCid() + " " + course.getDescription() + " " + grade;
	}
	
}

