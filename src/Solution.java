
public class Solution {
	public static void main(String[] args){
		myStack my = new myStack();
		//2-3-4
		ListNode t4 = new ListNode(2);
		t4.next = new ListNode(3);
		t4.next.next = new ListNode(4);
		LinkedList l4 = new LinkedList();
		l4.setHead(t4);
		
		my.items = l4;
		my.displayStack();
		my.pop();
		my.pop();
		my.displayStack();
		my.pop();
		my.displayStack();
		my.pop();
		my.displayStack();
		
		my.push(0);
		my.push(5);
		my.push(2);
		my.displayStack();
		
		my.pop();
		my.displayStack();
		
	}
}
