import java.io.*;
import java.util.*;

//has the dictionary object, and grades essays
public class Grader {

	
	// student instance
	private boolean available;

	// graded student instance
	private Student student;

	//dictionary instance
	private Dictionary dict;

	// Constructor that initializes the local dictionary field by variable dict
	public Grader(Dictionary dict) {
		this.dict = dict;
	}

	// uses isWord()
	// parse file

	public boolean gradeStudent(String fileName) {
		fileName += ".txt";
		String name;
		String id;
		String school;
		String essay = null;
		String major;
		//String classification;
		ArrayList<String> errorList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String y = br.readLine();
			if(y.equals("HighSchool Student")){
				//classification = br.readLine();
				name = br.readLine();
				id = br.readLine();
				school = br.readLine();
				for(int i = 0; i < 9999; i++){
					String line = br.readLine();
					if(line != null){
						String[] tokens = line.split(" ");
						for (int j = 0; j < tokens.length; j++){
							tokens[j] = processWord(tokens[j]);
						}
						for(String z: tokens){
							if(dict.isWord(z) == false){
								errorList.add(z);
							}
						}
					}
				}
				student = new HighSchoolStudent(name, id, essay, errorList, school);
				available = false;
				return true;
			}
			if(y.equals("Undergraduate Student")){
				name = br.readLine();
				id = br.readLine();
				major = br.readLine();
				for(int i = 0; i < 9999; i++){
					String line = br.readLine();
					if(line != null){
						String[] tokens = line.split(" ");
						for (int j = 0; j < tokens.length; j++){
							tokens[j] = processWord(tokens[j]);
						}
						for(String z: tokens){
							if(dict.isWord(z) == false){
								errorList.add(z);
							}
						}
					}
				}
				student = new UndergraduateStudent(name, id, essay, errorList, major);
				available = false;
				return true;
			}
			if(y.equals("Graduate Student")){
				name = br.readLine();
				id = br.readLine();
				major = br.readLine();
				String advisor = br.readLine();
				for(int i = 0; i < 9999; i++){
					String line = br.readLine();
					if(line != null){
						String[] tokens = line.split(" ");
						for (int j = 0; j < tokens.length; j++){
							tokens[j] = processWord(tokens[j]);
						}
						for(String z: tokens){
							if(dict.isWord(z) == false){
								errorList.add(z);
							}
						}
					}
				}
				student = new GraduateStudent(name, id, essay, errorList, major, advisor);
				available = false;
				return true;
			}
		}
		catch(Exception e){
			return false;
		}
		return false;
	}
	//this additional method removes all punctuation except for ' and - by using replaceAll
	private static String processWord (String x){
		return x.replaceAll("[](){},.;:!?<>%]","");
	}

	// A method to check whether the grader is available to grade the next
	// student.
	// Available means student field is null and available variable is true.
	// checks if student is available
	public boolean isAvailable() {
		if (student != null) {
			available = false;
		} else
			available = true;
		return available;
	}

	// Getter method to get the graded/generated student instance
	public Student getStudent() {
		return student;
	}

	// Method to reset local variables, except for dict field because it must be held constant to grade the other essays.
	// When reset method is called, student variable is changed to null and available
	// variable is changed to true, regardless of current status.
	public void reset() {
		student = null;
		available = true;
	}
}
