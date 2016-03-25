
public class SortedDateList extends DateList {
	
	/**
	 * insert method, sorts the dates by checking all relevant neighbors against conditions
	 * @return void
	 */
	public void add(Date212 s) {
		
		DateNode pointA=first; //make a point 'a' and abuse it to track our position
    	DateNode pointB=first.next; //and point 'b' which is after 'a'
    	DateNode n = new DateNode(s); //make new node 'n' with the incoming data from Date212 's'
    	
    	while (pointA.next!=null) { //while ref point A.next is not null
    		pointB=pointA.next;  //set point B to follow A
    		if(pointB.data.compareTo(s)>0) break;  //if incoming data 's' is greater than b, break from this loop!
    		pointA=pointA.next;  //otherwise, move point A one position 
    	}
    	
    	if (pointA.next ==null) { //list is empty, append incoming data
    		last.next = n; 
    		last = n;
    		length++;
    	}
    	
    	else { //list is not empty, insert incoming data 'n' in between A and B
    		pointA.next=n;
    		n.next=pointB;
    		length++; 
    	}
    
   }
	
}
