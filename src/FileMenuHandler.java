import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
	JFrame jframe;
	public static TextFileInput inputFile;
	public static String line="";
	public static StringTokenizer myTokens;
	public static boolean runOnce;

	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}

	
	public void actionPerformed(ActionEvent event) {//listen to user actions
		String menuName = event.getActionCommand();//retrivew user action and set as 'menuName'
		
		if (menuName.equals("OPEN") && runOnce==false) { //if user action = OPEN, proceed to open file chooser
			
			JFileChooser myFile = new JFileChooser(); //create file chooser
			int key = myFile.showOpenDialog(null);
	        myFile.setFileSelectionMode(JFileChooser.FILES_ONLY); //allow files to be selected only
	        
	        if (key == JFileChooser.APPROVE_OPTION) { //if file is chosen, proceed to process file by using TextFileInput and tokenizer
			JOptionPane.showMessageDialog(null, "Opening File...");
			File f = myFile.getSelectedFile(); //save selected file to 'f'
			inputFile = new TextFileInput(f.getAbsolutePath()); //feed absolute path of 'f' to textfileinput
			
			magic(); //start the magic
	        }
	        
	}
		else if (menuName.equals("QUIT")) { //if user action = QUIT, exit
			JOptionPane.showMessageDialog(null, "Good Bye!");
			System.exit(0);
	} 
		
}
	
	
	/** 
	 * magic: responsible for processing text file that the user chooses
	 * 		  tokenizes each line while working with textfileinput
	 * 		  implements try,catch blocks, prints to GUI
	 * @return void 
	 */ 
	public void magic() {

		UnsortedDateList unsorted = new UnsortedDateList(); //create unsorted and sorted date list OBJECTS!
		SortedDateList sorted = new SortedDateList(); //DateList object with the name 'sorted'
		
		while(line!=null) { 
				
			myTokens = new StringTokenizer(line,","); //set myTokens as the current 'line' tokenized and begin working on the line
			
			while ( myTokens.hasMoreTokens() ) { //while line read has MORE TOKENS, check token validity and save to ssnList IF VALID!
					
				String tokenHolder = myTokens.nextToken().trim(); //tokenHolder is holding the value because using .nextToken always forces next token up one unit!!!***
					
				try {
				Date212 dataEntry = new Date212(tokenHolder); //create a new object of type Date212 'dataEntry' that takes in the value held by tokenHolder
				unsorted.add(dataEntry); //append dataEntry to 'unsorted' object DateList
				sorted.add(dataEntry); //insert dataEntry to 'sorted' object DateList
				}
				catch (NumberFormatException nfe) {
					System.out.println("Error in Entry: " + tokenHolder + " - not a number ");
				}
				catch (IllegalDate212Exception e) {
					System.out.println(e.getMessage());
				}
				catch (Exception e) {
					System.out.println("Entry: " + tokenHolder + " - not a valid date");
				}
			}
					
			line = inputFile.readLine(); //move to next line in file and READ it in, store in 'line' for processing in next loop
				
			      }
				
			DateGUI.print(sorted,unsorted,sorted.getLength()); //file is finished reading, call print from DateGUI
			runOnce=true; //set true so the user can't press open file again
		}
	
}