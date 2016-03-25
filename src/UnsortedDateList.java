
public class UnsortedDateList extends DateList {
	
	public void add (Date212 s) { //append method to attach items to end of linked list
	      DateNode n = new DateNode(s); //create new node 'n' with data from 's'
	      last.next = n; //point the PREVIOUS last node on the linked list to new node 'n'
	      last = n; //the idea behind 'append' is that we attach a node to the end of the list, so 'n' becomes the new last node 
	      length++;
	}
}
