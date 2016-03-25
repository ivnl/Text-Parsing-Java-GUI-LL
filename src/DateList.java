
public abstract class DateList {
	
   DateNode first = new DateNode(null); /** First node in linked list - dummy node */
   DateNode last = first; /** Last node in linked list */
   int length = 0; /** Number of data items in the list. */

   
   public  int getLength() {
	   return length; //return length of datelist
   }
    
	public String toString() { //this is required or else only node addresses will be printed out, basically turns nodes in to strings
		DateNode p = first.next; //set 'p' as second 
		String returnString = ""; //create a string
		while (p != null) { //while 'p' has not become an empty node we continue looping
			returnString += p.data + "\n"; //return each nodes data as strings in a new line \n
			p = p.next; //set 'p' to 'p.next' to check next node in list... remember only until p becomes null, we stop
		}
		return returnString;
	}

	
	
}
