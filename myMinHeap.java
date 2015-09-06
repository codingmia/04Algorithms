/*Assume element x has index p, its left child has index (2*p + 1), its right child has index (2*p + 2) */
public class myMinHeap {
	int[] nums;
	int capacity;
	int size;
	
	public myMinHeap(int capacity){
		nums = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}
	public myMinHeap(int[] nums){
		buildMinHeap(nums);
	}
	//Organize numbers into heap
	public void buildMinHeap(int[] nums){
		this.nums = nums;
		this.size = nums.length;
		for(int i = (size - 1)/2; i >= 0; i--){
			System.out.println();
			System.out.println("Iteration: " + i);
			minHeapify(i);	
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
		nums[i] = key;
		//Sift smaller values up
		while(i != 0 && nums[(i-1)/2] > nums[i]){
			swap(nums, i, (i-1)/2);
			i = (i-1)/2;
		}
	}
	//Perform heapify starting from root with index k.
	public void minHeapify(int k){
		int left = (2*k + 1);
		int right = (2*k + 2);
		int minIndex = k;
		//i is increasing
		if(left < size && nums[left] < nums[k]){
			minIndex = left;
		}
		if(right < size && nums[right] < nums[minIndex]){
			minIndex = right;
		}
		if(minIndex != k){
			swap(nums, k, minIndex);
			minHeapify(minIndex);
		}
	}
	public void delete(int index){
		nums[index] = nums[size - 1];
		nums[size-1] = -2;
		int i = index;
		size --;
		
		if(i != 0 && nums[parent(i)] < nums[i]){
			minHeapify(index);
		}else{
			while(i != 0 && nums[parent(i)] > nums[i]){
				swap(nums, i, parent(i));
				i = parent(i);
			}
		}		
	}
	//Remove min value from heap
	public int extractMin(){
		if(size <= 0){
			return Integer.MAX_VALUE;
		}
		if(size == 1){
			size --;
			return nums[0];
		}
		int root = nums[0];
		nums[0] = nums[size - 1]; //nums[0] is always smaller than nums[size-1]
		size --;
		minHeapify(0);
		return root;
	}
	public void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
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
}
