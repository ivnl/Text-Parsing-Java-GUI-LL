
public class DateNode{
	
	protected Date212 data;
	protected DateNode next;
	
	public DateNode (Date212 d) { // constructor for incoming node creation
		this.data = d;
		this.next = null;
		
	}
	
	  public DateNode()  {
	      this.data = null;
	      this.next = null;
	   }  // constructor for dummy
	  
}
