
public class myMaxHeap {
	int[] nums;
	int capacity;
	int size;
	 
	public myMaxHeap(int capacity){
		nums = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}
	public myMaxHeap(int[] nums){
		buildMaxHeap(nums);
	}
	public void heapSort(int[] nums){
		buildMaxHeap(nums);
		for(int i = nums.length - 1; i >= 0; i--){
			nums[i] = extractMax();
		}
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	public void buildMaxHeap(int[] nums){
		this.nums = nums;
		this.size = nums.length;
		for(int i = (size - 1)/2; i >= 0; i--){
			System.out.println();
			System.out.println("Iteration: " + i);
			maxHeapify(i);	
			for(int j = 0; j < 20; j++){
				System.out.print(nums[j] + " ");
			}
		}
				
	}
	public void insert(int key){
		if(size == capacity){
			return;
		}
		nums[size++] = key;
		int i = size - 1;
		//sift bigger valuesyoutu up
		while(i != 0 && nums[parent(i)] < nums[i]){
			swap(nums, i, parent(i));
			i = parent(i);
		}
	}
	//Perform maxHepify from root index
	public void maxHeapify(int index){
		int maxIndex = index;
		int left = left(index);
		int right = right(index);
		if(left < size && nums[left]> nums[index]){
			maxIndex = left;
		}
		if(right < size && nums[right] > nums[maxIndex]){
			maxIndex = right;
		}
		if(maxIndex != index){//Need to swap with its child
			swap(nums, maxIndex, index);
			maxHeapify(maxIndex);
		}
	}
	public void delete(int index){
		nums[index] = nums[size - 1];
		nums[size-1] = -2;
		int i = index;
		size --;
		
		if(i != 0 && nums[parent(i)] > nums[i]){
			maxHeapify(index);
		}else{
			while(i != 0 && nums[parent(i)] < nums[i]){
				swap(nums, i, parent(i));
				i = parent(i);
			}
		}		
	}
	public int extractMax(){
		if(size <= 0){
			return Integer.MAX_VALUE;
		}
		if(size == 1){
			size --;
			return nums[0];
		}
		int root = nums[0];
		nums[0] = nums[size - 1];
		nums[size - 1] = -2;
		size --;
		maxHeapify(0);
		return root;
	}
	
	public int getMax(){
		return size > 0 ? nums[0] : Integer.MAX_VALUE;
	}
	public int left(int index){
		return 2*index + 1;
	}
	public int right(int index){
		return 2*index + 2;
	}
	public int parent(int index){
		return (index - 1)/2;
	}
	public void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	public void showMaxHeap(){
		for(int i = 0; i < nums.length; i++ ){
			System.out.print(nums[i] + " ");
			if(i == 0 || i == 2 || i == 6 || i == 14 || i == 30){
				System.out.println();
			}
		}
	}
}

/*
//int[] nums = new int[16];
int[] nums = new int[20];
for(int i = 0; i < 20; i++){
	nums[i] = i;
}
myMaxHeap my2 = new myMaxHeap(20);
//System.out.println();
//my2.showMaxHeap();
//System.out.println();
//my2.delete(3);
//my2.extractMax();

my2.heapSort(nums);
my2.showMaxHeap();

myMaxHeap my = new myMaxHeap(16);5
my.insert(1);
my.insert(5);
my.insert(4);
my.insert(2);
my.insert(3);
my.insert(10);
my.showMaxHeap();
my.delete(1);
//my.extractMax();
System.out.println();
my.showMaxHeap();
*/
