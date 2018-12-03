
public class Course {
	
	private String cid;
	private String description;
	private double[] eval;
	
	Course(){}
	
	Course(String cid, String description, double[] eval){
		this.cid = cid;
		this.description = description;
		this.eval = eval;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double[] getEval() {
		return eval;
	}

	public void setEval(double[] eval) {
		this.eval = eval;
	}
	
	public void display(){
		System.out.printf("%-5s%-30s%-20s%-20s%-20s\n",cid,description,eval[0],eval[1],eval[2]);
	}
	
	public String toString(){
		return cid + " " + description + " " + eval[0] + " " + eval[1] + " " + eval[2];
	}
}


