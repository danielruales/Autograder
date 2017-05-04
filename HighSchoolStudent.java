import java.io.*;
import java.util.*;

//Child class of the Student Class by being extended at the beginning 
public class HighSchoolStudent extends Student {
	private String nameOfSchool;
	
	//Constructor
	HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool){
		super(name, id, essay, errorList);
		this.nameOfSchool = nameOfSchool;
	}
	
	//Getter/Setter methods
	public String getSchoolName(){
		return nameOfSchool;
	}
	
	public void setSchoolName(String schoolName){
		nameOfSchool = schoolName;
	}
	
	//uses the abstract method in given class in order to print
	public void writeToFile(){
		try{
		    PrintWriter writer = new PrintWriter(getId() + "_graded.txt", "UTF-8");
		    writer.println("High School Student " + getName());
		    writer.println("Student ID: " + getId());
		    writer.println("School Name: " + getSchoolName());
			writer.println(getPrintableErrorList());
		    writer.close();
		}
		catch (IOException e) {
			
		}

		
	}
}
