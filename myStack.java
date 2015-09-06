/* LinkedList Implementation of stack*/
public class myStack {
	LinkedList items;
	//operate from the head, 
	//e.g. 1, 2->1, 3->2->1, 
	public myStack(){
		
	}
	public ListNode pop(){
		if(this.isEmpty()){
			return null;
		}else{
			ListNode tmp = items.getHead();
			items.setHead(tmp.next);
			return tmp;
		}
	}
	public void push(int val){
		items.insert(val);
	}
	public void displayStack(){
		items.displayList();
	}
	public boolean isEmpty() {
		if(items.getHead() == null){
			return true;
		}else{
			return false;
		}
	}
}
//Uncomment following and replace it in Solution.java for test
/*myStack my = new myStack();
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
		my.displayStack();*/