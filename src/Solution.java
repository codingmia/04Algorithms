
public class Solution {
	public static void main(String[] args){
		myQueue my1 = new myQueue();
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
	}
}
