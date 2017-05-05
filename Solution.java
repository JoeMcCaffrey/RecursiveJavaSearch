import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) throws FileNotFoundException {

		//current directory wher java file is located
		File dirLevel = new File(".");
		findString(dirLevel);
		
	}
	
	public static void findString(File location) throws FileNotFoundException{
		
		String match = "Integration Rules";
		
		File[] fileArray = location.listFiles();
			
		for(int i=0; i < fileArray.length; i++){
			
			//base case
			if(fileArray[i].isFile()){
				
				Scanner scanner = new Scanner(fileArray[i]);
				
				// regex match failed if null
				if(scanner.findInLine(match) != null){

					// print name of file containing string
					System.out.println(fileArray[i].getName());
				}
				scanner.close();
			}
			else {

				// recursive call
				findString(fileArray[i]);
			}
		}			
	}
}

