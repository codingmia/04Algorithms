 import java.util.*;
public class myTree {
	 public myTree(){
		 
	 }
	 //Return the TreeNode(and its subtree) with given value
	 public TreeNode find(TreeNode root, int target){
          if(root == null || root.val == target ){
              return root; 
          }
          if(target < root.val){
              return find(root.left, target);
          }
          else{
              return find(root.right, target);
          }
	 }
	 //Return a new tree with TreeNode target inserted
	 public TreeNode insert(TreeNode root, int target){
		 if(root == null){
			 return new TreeNode(target);			
		 }
		 if(target < root.val){
			 root.left = insert(root.left, target);
		 }
		 else if(target > root.val){
			 root.right = insert(root.right, target);
		 }
		 return root;
	 }
	 
	 public TreeNode findMax(TreeNode root){
		 while(root != null && root.right != null){
			 root = root.right;
		 }
		 return root;
	 }
	 public TreeNode findMin(TreeNode root){
		 while(root != null && root.left != null){
			 root = root.left;
		 }
		 return root;
	 }
	 public TreeNode delete(TreeNode root, int target){
		 if(root == null){
			 return null;
		 }
		 if(target < root.val){
			 root.left = delete(root.left, target);
		 }else if(target > root.val){
			 root.right = delete(root.right, target);
		 }
		 else{
			 if(root.right == null || root.left == null){
				 return root.right == null ? root.left : root.right;
			 }else{
				 TreeNode oldRoot = root;
				 root = findMax(oldRoot.left);
				 root.left = delete(oldRoot.left, root.val);
				 root.right = oldRoot.right;
			 }
		 }
	 	 return root;
	 }
	 public void printTree(TreeNode tmpRoot) {

	      /**  Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
	        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

	        currentLevel.add(tmpRoot);

	        while (!currentLevel.isEmpty()) {
	            Iterator<TreeNode> iter = currentLevel.iterator();
	            while (iter.hasNext()) {
	                TreeNode currentNode = iter.next();
	                if (currentNode.left != null) {
	                    nextLevel.add(currentNode.left);
	                }
	                if (currentNode.right != null) {
	                    nextLevel.add(currentNode.right);
	                }
	                System.out.print(currentNode.val + " ");
	            }
	            System.out.println();
	            currentLevel = nextLevel;
	            nextLevel = new LinkedList<TreeNode>();

	        }**/

	    }
	 public TreeNode find_Iter(TreeNode root, int target){
		 TreeNode cur = root;
		 while(cur != null){
			 if(cur.val == target){
				 return cur;
			 }
			 if(target < cur.val){
				 cur = cur.left;
			 }else{
				 cur = cur.right;
			 }
		 }
		 return null;
	 }
	 public TreeNode insert_Iter(TreeNode root, int target){
		 TreeNode cur = root;
		 TreeNode parent = root;
		 while(cur != null){
			 parent = cur;
			 if(target == cur.val){
				 return root;
			 }
			 if(target < cur.val){
				 cur = cur.left;
			 }else if(target > cur.val){
				 cur = cur.right;
			 }
		 }
		 if(target > parent.val)
			 parent.right = new TreeNode(target);
		 else
			 parent.left = new TreeNode(target);
		 return root;
	 }
}

/**
	 }**/