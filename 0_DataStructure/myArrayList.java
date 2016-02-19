
/**
    Description:
    Write a program to implement your own ArrayList class. It should
    contain add(), get(), remove(), size() methods. Use dynamic array logic.
    It should increase its size when it reaches threshold.
    E.g.
    Double capacity if length >= capacity
    1/2 capacity if length == 1/4 capacity 
*/

public class myArrayList {
    private String[] elements;
    private int capacity;
    private int length;
    
	public myArrayList() {
		this.length = 0;
		this.capacity = 10;
		this.elements = new String[capacity];
	}
	public myArrayList(int num){
		this.length = 0;
		this.capacity = num;
		this.elements = new String[capacity];
	}
    public void add(String item){
		if(item == null) return;
        if(length + 1 >= capacity){
        	updateSize(capacity*2);
		}
		elements[length] = item;
		length++;
    }
    public String get(int index) throws MyOwnException{
    	if(isValidIndex(index)){
    		return elements[index];
    	}else{
    		throw new MyOwnException("Index: " + index + " is out of range. Please check the index");
    	}
    }
	public int size(){
		return this.length;
	}	
	public void remove(int index) throws MyOwnException{
		if(isValidIndex(index)){
			//remove
			for(int i = index; i < length; i++){
				elements[i] = elements[i+1];
			}
			elements[length] = null;
			length--;
			if(length <= Math.ceil(capacity/4)){
				updateSize(capacity/2);
			}		
		}else{
			throw new MyOwnException("No elements to remove in the arraylist");
		}		
	}
	
	public void remove(String val){
		int occurence = 0;
		boolean[] occurs = new boolean[length];
		int index = 0; //repeats the non-duplicate set
		for(int i = 0; i < length; i++){
			if(elements[i].equals(val)){
				occurs[i] = true;
				occurence ++;
			}else{
				occurs[i] = false;
			}
		}
		if(occurence == 0){
			return;
		}
		for(int i = 0; i < length; i++){
			if(!occurs[i]){
				elements[index++] = elements[i];
			}			
		}
		length -= occurence;
		if(length <= Math.ceil(capacity/4)){
			updateSize(capacity/2);
		}
	}
	//Utility methods
	public boolean isValidIndex(int index){
		return index >= 0 && index <= this.length;
	}
	public void updateSize(int newCapacity){
		this.capacity = newCapacity;
		String[] newElements = new String[newCapacity];
		for(int i = 0; i < this.length; i++){
			newElements[i] = this.elements[i];
		}
		this.elements = newElements;
	}
	public void showMe(){
		System.out.println();
		System.out.println("----------------");
		System.out.println("Capacity: " + this.capacity);
		System.out.println("Size: " + this.length);
		System.out.println("Contents: ");
		for(int i = 0; i < capacity; i++){
			if(i < this.length)
				System.out.print(this.elements[i] + ",  ");
			else
				System.out.print("-@-" + "  ");
			if(i != 0 && i % 5 == 0){
				System.out.println();
			}
		}
	}
	//getters and setters for external access
	public String[] getElements() {
		return this.elements;
	}	
	public void setElements(String[] elems){
		this.elements = elems;
	}
	public int getCapacity(){
		return this.capacity;
	}
	public void setCapacity(int capac){
		this.capacity = capac;
	}
}

class MyOwnException extends Exception {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyOwnException(String msg){
      super(msg);
   }
}

//Uncomment following and replace it in Solution.java for test
/**
 * public class Solution {
	public static void main(String[] args){
		myArrayList my1 = new myArrayList(3);
		my1.add("a");
		my1.add("b");
		my1.showMe();
		my1.add("b");
		my1.add("b");
		my1.add("e");
		my1.showMe();
		my1.remove("d");
		my1.showMe();
		my1.remove("b");
		my1.showMe();
		my1.remove("a");
		my1.showMe();
		myArrayList my2 = new myArrayList(10);
	}	
}
 * **/