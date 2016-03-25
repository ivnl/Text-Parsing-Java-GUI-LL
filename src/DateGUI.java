import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;


public class DateGUI extends JFrame {

	Container cPane; //create container 'cPane'
	JMenuBar menuBar;
	static TextArea sorted; //create two text areas for sorted and original lists
	static TextArea unsorted;

	public DateGUI() {
		setTitle("PROJECT 3");
		setSize(300,300);
		setLocation(400, 200);
		createFileMenu();
		createLists();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} 
	
	/** 
	 * createLists: create text areas for storing dates
	 * @return void
	 */ 
	
	public void createLists() {
		
		setLayout(new GridLayout(1, 2));
		sorted = new TextArea(); sorted.setEditable(false); sorted.setBackground(Color.PINK); //set text areas and options
		unsorted = new TextArea(); unsorted.setEditable(false); unsorted.setBackground(Color.LIGHT_GRAY);
		cPane = getContentPane(); //initialize content pane for usage
		cPane.add(unsorted); //add to content pane the text area 'unsorted'
		cPane.add(sorted); //add to content pane the text area 'sorted'
		
	}
	
	/** 
	 * print: appends dates to text areas created from createLists()
	 * @return void
	 */ 
	
	public static void print (DateList x, DateList y, int z) { //print method created to take in two date lists and append them to text areas
		 unsorted.append("ORIGINAL LIST:\n\n"); //append initial line as titles for unsorted list
		 sorted.append("SORTED LIST:\n\n"); //append initial line for sorted list 
	
		 sorted.append(x.toString()); //toString() because append only accepts string type
		 unsorted.append(y.toString());
		 
		 sorted.append("\ntotal valid dates: "+String.valueOf(z)); //output total number of valid dates in lists
		 unsorted.append("\ntotal valid dates: "+String.valueOf(z));
	 }
	

	
	private void createFileMenu() {
		
		menuBar = new JMenuBar(); //create new menu bar
		JMenu fileMenu = new JMenu("FILE"); //create new file tree called "FILE"
		FileMenuHandler fmh = new FileMenuHandler(this); //link to filemenuhandler class
		JMenuItem item; //initialize 'item'

		item = new JMenuItem("OPEN"); //create new item for menu "OPEN"
		item.addActionListener(fmh); //add action listener to OPEN
		fileMenu.add(item); //attach "OPEN" to fileMenu "FILE"

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("QUIT"); // Quit
		item.addActionListener(fmh); //
		fileMenu.add(item); //

		setJMenuBar(menuBar); //set and attach filemenu to menu bar*
		menuBar.add(fileMenu);
	}


} 
