/*LinkedList Implementation of queue*/
public class myQueue {
	ListNode front;
	ListNode rear;
	//FILO
	public myQueue(){
		this.front = null;
		this.rear = null;
	}
	//Enqueue add to last of linkedlist
	public void enqueue(int val){
		ListNode cur = new ListNode(val);
		if(isEmpty()){
			this.front = cur;//update front+rear
			this.rear = cur;
			return;
		}
		this.rear.next = cur; //update rear
		this.rear = cur;		
	}
	//Dequeue delete from the head of linkedlist
	public ListNode dequeue() {		
		if(isEmpty()){
			return null;
		}
		ListNode pop = this.front;
		this.front = this.front.next; //update front
		if(this.front == null){
			this.rear = null;
		}
		return pop;
	}
	public void displayQueue(){
		if(this.front == null && this.rear == null){
			System.out.println("Front: Null,  Rear: Null");
			return;
		}else{
			if(this.front != null && this.rear != null)
			System.out.println("Front:" + this.front.val + " Rear: " + this.rear.val);
		}	
		ListNode cur = this.front;
		if(cur == null){
			System.out.println("warning, empty list");
			return;
		}
		while(cur != null){
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.println();
	}
	public boolean isEmpty(){
		return this.front == null && this.rear == null;
	}
}
