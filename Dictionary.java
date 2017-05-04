import java.io.*;
import java.util.*;

//Loads dictionary from file, used to check misspellings
public class Dictionary {

	//Holds words from dictionary
	private ArrayList<String> dictionary = new ArrayList<>();
	
	public int getVocabularySize(){
		//returns number of words in the loaded dictionary
		
		return dictionary.size();
	}
	
	public boolean loadDictionaryFromFile(String filePath){
		//Load dictionary file based on file name
		//Same folder as Dictionary Class
		//If found, return true, otherwise return false
		
		File inputFile = new File (filePath);
		try{
			Scanner readfile = new Scanner(inputFile);
			while (readfile.hasNextLine()){
				String input = readfile.nextLine();
				dictionary.add(input);
			}
			return true;
		}
		catch (FileNotFoundException e){
			return false;
		}

	}
	
	public boolean isWord(String word){
		//Check whether a given word is in the dictionary
		//If so, return true, otherwise return false
		
		/*
		File inputFile = new File(word);
		try{
			Scanner readfile = new Scanner(inputFile);
			ArrayList<String> words = new ArrayList<>();
			while (readfile.hasNextLine()){
				
				Scanner line = new Scanner(readfile.nextLine());
				line.useDelimiter("");
				words.add(line.next());
			}
			if(dictionary.contains(words)){
				return true;
			}
			else return false;
		}
		catch (FileNotFoundException e){
			return false;
		}
		*/
		
		//Remove punctuation excepting ' and -
		for(String x : dictionary){
			//stuff
			//Scanner s = new Scanner(word).useDelimiter(" " + "?" + ":" + "," + ".");
			//stuff
			if(word.equalsIgnoreCase(x)){
				return true;
			}
		}
		return false;
	}
	
}
