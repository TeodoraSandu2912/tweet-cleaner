package com.bham.pij.assignments.twit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TweetCleaner {

	private static ArrayList<String> raw = new ArrayList<String>();
	private static ArrayList<String> cleaned = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {

		new TweetCleaner();
		
		System.out.println("Done.");
	}
	
	public TweetCleaner() throws IOException {

		loadRaw();
		
		clean();
		
		saveClean();
	}

	private void clean() {
		
		for (String line: raw) {
			
			String cln = clean(line);

			if (cln != null) {
				
				String[] toks = cln.split(" ");
				
				for (String s: toks) {
					addClean(s);			
				}	
			}
		}
	}

	public String clean(String input) {
        String[] inputSplitted = input.split(" ");
        String cleanedInput = "";

        boolean valid = true;
        for(int j = 0; j < inputSplitted.length; j++){
            String s = inputSplitted[j];
            valid = true;
            for(int x = 0; x <s.length(); x++){
                if(s.charAt(0) == '@' 
                   || s.charAt(0) == '#' 
                   || s.contains("https://") 
                   || Character.isDigit(s.charAt(x)) 
                   || s.equalsIgnoreCase("RT")){
                    valid = false;
            }
          }
                
            if(valid != false){
                
            	String secWord = "";

                for(int x = 0; x < s.length(); x++){
                	 String newWord = "";

                	if(s.charAt(x) == '-'){
                        newWord = newWord.replace("-","");
                    }
                    
                	else if(Character.isAlphabetic(s.charAt(x)) 
                    || (s.charAt(x) == '!' && x == s.length()-1 && s.length() > 1) 
                    || (s.charAt(x) == '?' && x == s.length()-1 && s.length() > 1) 
                    || (s.charAt(x) == '\'' && s.length() > 1)){
                        newWord += s.charAt(x);
                    
                }
                    else
                    {
                newWord += newWord.replace(s.charAt(x),' ');
        }
             secWord += newWord;
    }
             cleanedInput = cleanedInput.trim();
             cleanedInput += " " + secWord;
 }
         
}       
    cleanedInput = cleanedInput.trim();    
    if(cleanedInput.equals(" ") || cleanedInput == null){
        return null;
    }
    if(cleanedInput.length() != 0){
        return cleanedInput;
    }
    if(cleanedInput.isEmpty()){
        valid = false;
    }
    return null;
    
	}

	

	private void addClean(String clean) {
		
		cleaned.add(clean);
	}
	
	private void saveClean() throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("cleaned.txt");
		
		for (String s: cleaned) {
			pw.print(s + " ");
		}
		
		pw.close();
		
	}
	
	private void loadRaw() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File("donald.txt")));
		
		String line = "";
		
		while ((line = br.readLine())!= null) {
			
			raw.add(line);
		
		}
		
		br.close();
	}
}
