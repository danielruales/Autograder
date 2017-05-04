import java.util.*;
import java.io.*;

//Child class of the Student Class by being extended at the beginning 
public class GraduateStudent extends Student {
	private String major;
	private String advisor;
	
	//Constructor
	GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor){
		super(name, id, essay, errorList);
		this.major = major;
		this.advisor = advisor;
	}
	
	//Getter/Setter methods
	public String getMajor(){
		return major;
	}
	
	public void setMajor(String major){
		this.major = major;
	}
	
	public String getAdvisor(){
		return advisor;
	}
	
	public void setAdvisor(String advisor){
		this.advisor = advisor;
	}
	
	//uses the abstract method in given class in order to print
		
		public void writeToFile(){
			try{
			    PrintWriter writer = new PrintWriter(getId() + "_graded.txt", "UTF-8");
			    writer.println("Undergraduate Student " + getName());
			    writer.println("Student ID: " + getId());
			    writer.println("Major: " + getMajor());
			    writer.println("Advisor: " + getAdvisor());
				writer.println(getPrintableErrorList());
			    writer.close();
			}
			catch (IOException e) {
				
			}


		}
		
}
