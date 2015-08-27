/*Basic LinkedList Operations*/

//http://geeksquiz.com/linked-list-set-2-inserting-a-node/
//http://geeksquiz.com/linked-list-set-3-deleting-node/

public class LinkedList {
	private ListNode head;
	
    public LinkedList(){
        this.head = null;
    }
    public LinkedList(ListNode obj){
        this.head = obj;
    }
	//getters and setters for outer class access.
    public ListNode getHead(){
    	return this.head;
    }
    public void setHead(int val){
    	this.head = new ListNode(val);
    }
    public void setHead(ListNode obj){
    	this.head = obj;
    }
    
	//front
	public void insert(int val){
		ListNode newHead = new ListNode(val);
		newHead.next = this.head;
		this.head = newHead;
		return;
	}
	//insert after a given node
	public void insertAfter(ListNode obj, int val){
		if(obj == null){
			if(this.head == null){
				this.head = new ListNode(val);
			}else{
				return;
			}
		}
		ListNode tmp = new ListNode(val);
		tmp.next = obj.next;
		obj.next = tmp;
	}
	//insert at the end
	public void append(int val){
		ListNode cur = this.head;
		if(cur == null){
			this.head = new ListNode(val);
			return;
		}
		while(cur != null && cur.next != null){
			cur = cur.next;
		}
		cur.next = new ListNode(val);
	}
	
	public void delete(int val){
		ListNode cur = this.head;
		if(cur == null){
			return;
		}
		while(cur != null && cur.val == val){
			cur = cur.next;
		}
		this.head = cur; 
		while(cur != null && cur.next != null){
			if(cur.next.val != val){
				cur = cur.next;
			}
			else{
				cur.next = cur.next.next;
			}
		}
	}
	
	public void displayList(){
		ListNode cur = this.head;
		if(cur == null){
			System.out.println("warning, empty list");
		}
		while(cur != null){
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.println();
	}
}

/*
//2-3-3
ListNode t1 = new ListNode(2);
t1.next = new ListNode(3);
t1.next.next = new ListNode(3);
//3-3-3
ListNode t2 = new ListNode(3);
t2.next = new ListNode(3);
t2.next.next = new ListNode(3);
//3-2-3
ListNode t3 = new ListNode(3);
t3.next = new ListNode(2);
t3.next.next = new ListNode(3);

//2-3-4
ListNode t4 = new ListNode(2);
t4.next = new ListNode(3);
t4.next.next = new ListNode(4);

//2-3
ListNode t5 = new ListNode(2);
t5.next = new ListNode(3);

//3-2
ListNode t6 = new ListNode(3);
t6.next = new ListNode(2);

LinkedList l1 = new LinkedList();
LinkedList l2 = new LinkedList();
LinkedList l3 = new LinkedList();
LinkedList l4 = new LinkedList();
LinkedList l5 = new LinkedList();
LinkedList l6 = new LinkedList();

l1.head = t1;
l2.head = t2;
l3.head = t3;
l4.head = t4;
l5.head = t5;
l6.head = t6;

l1.displayList();
l2.displayList();
l3.displayList();
l4.displayList();
l5.displayList();
l6.displayList();

l1.insert(1);
l2.append(5);
l3.insertAfter(t3.next, 99);


l1.delete(3);
l2.delete(3);
l3.delete(3);
l4.delete(3);
l5.delete(3);
l6.delete(3);
 	
System.out.println("+++++");
l1.displayList();
l2.displayList();
l3.displayList();
l4.displayList();
l5.displayList();
l6.displayList();
*/
