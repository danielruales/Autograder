import java.io.*;
import java.util.*;

//Child class of the Student Class by being extended at the beginning 
public class UndergraduateStudent extends Student {
	private String major;
	
	//Constructor
	UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major){
		super(name, id, essay, errorList);
		this.major = major;
	}
	
	//Getter/Setter methods
	public String getMajor(){
		return major;
	}
	
	public void setMajor(String major){
		this.major = major;
	}
	
	//uses the abstract method in given class in order to print
	public void writeToFile(){
		try{
		    PrintWriter writer = new PrintWriter(getId() + "_graded.txt", "UTF-8");
		    writer.println("Undergraduate Student " + getName());
		    writer.println("Student ID: " + getId());
		    writer.println("Major: " + getMajor());
			writer.println(getPrintableErrorList());
		    writer.close();
		}
		catch (IOException e) {
			
		}
	}

	
}
