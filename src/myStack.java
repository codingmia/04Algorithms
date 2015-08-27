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
