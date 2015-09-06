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

//Uncomment following and replace it in Solution.java for test
/*		myQueue my1 = new myQueue();
		myQueue my2 = new myQueue();
		myQueue my3 = new myQueue();
		myQueue my4 = new myQueue();
		
		//2-3-4
		ListNode t4 = new ListNode(2);
		t4.next = new ListNode(3);
		t4.next.next = new ListNode(4);
		
		//2-3
		ListNode t5 = new ListNode(2);
		t5.next = new ListNode(3);
		
		//5
		ListNode t6 = new ListNode(55);
		
		//6
		ListNode t7 = null;
		
		my1.front = t4;
		my1.rear = t4.next.next;
		my2.front = t5;
		my2.rear = t5.next;
		my3.front = t6;
		my3.rear = t6;
		my4.front = t7;
		my4.rear = t7;
		
		
		my1.displayQueue();
		my2.displayQueue();
		my3.displayQueue();
		my4.displayQueue();
		
		System.out.println();
		
		my1.enqueue(88);
		my1.displayQueue();
		my2.dequeue();
		my2.displayQueue();
		my2.enqueue(100);
		my2.displayQueue();
		my3.dequeue();
		my3.displayQueue();
		my4.dequeue();
		my4.displayQueue();
*/